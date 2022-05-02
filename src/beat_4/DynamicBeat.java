package beat_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;//GUI 사용되는 라이브러리
import javax.swing.JLabel;

import beat_5.Main;

public class DynamicBeat extends JFrame {

	// 더블 버퍼링을 이용해 매순간 이미지를 불러온다.
	private Image screenImage;
	private Graphics screenGraphics;

	private Image introBackground = new ImageIcon(Main.class.getResource("../imgs/introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../imgs/menuBar.png")));

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/exitButtonBasic.png"));

	private JButton exitButton = new JButton(exitButtonBasicImage);

	private int mouseX, mouseY;

	public DynamicBeat() {
		setUndecorated(true);// 실행시 기본 메뉴바 삭제
		setTitle("DynamicBeat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// paintComponents의 배경색 하얀색
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		exitButton.setBounds(Main.SCREEN_WIDTH-30, 0, 30, 30);

		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);

		exitButton.addMouseListener(new MouseAdapter() {
			// 해당 버튼에 마우스가 올라오면
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav",false);
				buttonEnterdeMusic.start();
			}

			// 마우스가 치워지면
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 누르면 0 해당 프로그램 종료
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdeMusic = new Music("exitBtnPressed.wav",false);
				buttonEnterdeMusic.start();
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});

		add(exitButton);
		menuBar.setBounds(0, 0, Main.SCREEN_WIDTH, 30);
		// 마우스 의 좌표 값을 받아온다
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		// 메뉴판을 드래그하면 이동시킬수 있다.
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		// jFrame에 메뉴바가 추가됨
		add(menuBar);

		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	// paint는 JFrame을 상속받은 GUI게임에서 가장 먼저 그려주는 것
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		screenDraw(screenGraphics);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		// 한동안 그려주는거
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);// JLabel 같은거를 그려준다.
		this.repaint();
	}

}
