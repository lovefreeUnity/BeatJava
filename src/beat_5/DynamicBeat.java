package beat_5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;//GUI ���Ǵ� ���̺귯��
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	// ���� ���۸��� �̿��� �ż��� �̹����� �ҷ��´�.
	private Image screenImage;
	private Graphics screenGraphics;

	private Image Background = new ImageIcon(Main.class.getResource("../imgs/introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../imgs/menuBar.png")));

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/quitButtonBasic.png"));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private int mouseX, mouseY;

	public DynamicBeat() {
		setUndecorated(true);// ����� �⺻ �޴��� ����
		setTitle("DynamicBeat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// paintComponents�� ���� �Ͼ��
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		exitButton.setBounds(Main.SCREEN_WIDTH-30, 0, 30, 30);

		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);

		exitButton.addMouseListener(new MouseAdapter() {
			// �ش� ��ư�� ���콺�� �ö����
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav", false);
				buttonEnterdeMusic.start();
			}

			// ���콺�� ġ������
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ������ 0 �ش� ���α׷� ����
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("exitBtnPressed.wav", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});

		add(exitButton);

		startButton.setBounds(Main.SCREEN_WIDTH/2-150,Main.SCREEN_HEIGHT-Main.SCREEN_HEIGHT/3, 300, 74);

		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);

		startButton.addMouseListener(new MouseAdapter() {
			// �ش� ��ư�� ���콺�� �ö����
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// ���콺�� ġ������
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// ���ӽ��� �̺�Ʈ
				startButton.setVisible(false);
				quitButton.setVisible(false);
				Background = new ImageIcon(Main.class.getResource("../imgs/MainBackground.jpg")).getImage();
			}
		});

		add(startButton);

		quitButton.setBounds(Main.SCREEN_WIDTH/2-150,Main.SCREEN_HEIGHT-Main.SCREEN_HEIGHT/4, 300, 74);

		quitButton.setBorderPainted(false);//�׵θ� ����
		quitButton.setContentAreaFilled(false);//�׵θ� ���� ���̱� ����
		quitButton.setFocusPainted(false);

		quitButton.addMouseListener(new MouseAdapter() {
			// �ش� ��ư�� ���콺�� �ö����
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav", false);
				buttonEnterdeMusic.start();
			}

			// ���콺�� ġ������
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ������ 0 �ش� ���α׷� ����
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("exitBtnPressed.wav", false);
				buttonPressedMusic.start();
				try {
					//�ణ�� �����̸� �ش�
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});

		add(quitButton);

		menuBar.setBounds(0, 0, Main.SCREEN_WIDTH, 30);

		// ���콺 �� ��ǥ ���� �޾ƿ´�
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});

		// �޴����� �巡���ϸ� �̵���ų�� �ִ�.
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});

		// jFrame�� �޴��ٰ� �߰���
		add(menuBar);

		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	// paint�� JFrame�� ��ӹ��� GUI���ӿ��� ���� ���� �׷��ִ� ��
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		screenDraw(screenGraphics);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		//���ȭ���� �ݺ������� �׷��ִ°�
		g.drawImage(Background, 0, 0, null);
		paintComponents(g);// JLabel �����Ÿ� �׷��ش�.
		this.repaint();
	}

}
