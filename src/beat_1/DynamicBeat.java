package beat_1;

import javax.swing.JFrame;//GUI ���Ǵ� ���̺귯��

public class DynamicBeat extends JFrame {

	public DynamicBeat() {
		setTitle("DynamicBeat");//����
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//���ο��� ������ �ػ�
		setResizable(false);//âũ�� ���� ���� ���� false
		setLocationRelativeTo(null);//����� ��ǻ�� ���߾ӿ� â�� �߰� �ȴ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���� â�� ���������� ���α׷��� ����ǰ� �ϴ� ��
		setVisible(true);//����â�� ���̰� �Ѵ�.
	}
	
}
