package beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;//GUI ���Ǵ� ���̺귯��

public class DynamicBeat extends JFrame {

	//���� ���۸��� �̿��� �ż��� �̹����� �ҷ��´�.
	private Image screenImage;
	private Graphics screenGraphics;
	
	//������
	private Image introBackground;
	
	public DynamicBeat() {
		setTitle("DynamicBeat");//����
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//���ο��� ������ �ػ�
		setResizable(false);//âũ�� ���� ���� ���� false
		setLocationRelativeTo(null);//����� ��ǻ�� ���߾ӿ� â�� �߰� �ȴ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���� â�� ���������� ���α׷��� ����ǰ� �ϴ� ��
		setVisible(true);//����â�� ���̰� �Ѵ�.
		
		//���� Ŭ������ ��ġ�� ������� �̹��� ������ ������  �� �̹����� Background ������ �ʱ�ȭ
		introBackground = new ImageIcon(Main.class.getResource("../imgs/introBackground.jpg")).getImage();
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}
	
	//paint�� JFrame�� ��ӹ��� GUI���ӿ��� ���� ���� �׷��ִ� ��
	public void paint(Graphics g) {
		//���α׷� ȭ�� ��ŭ �̹����� �����ؼ�
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		//���ȭ������ �� �׷��� ��ü�� �����ڴ�
		screenGraphics = screenImage.getGraphics();
		//�Լ�
		screenDraw(screenGraphics);
		//�׷��ش�
		g.drawImage(screenImage, 0, 0, null);
		
	}
	public void screenDraw(Graphics g) {
		//0.0 ��ġ�� �׷��ش�
		g.drawImage(introBackground, 0, 0, null);
		//����Ʈ �Լ��� �ݺ������Ѵ�.
		this.repaint();
	}
	
}
