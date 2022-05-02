package beat_10;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;//GUI 사용되는 라이브러리
import javax.swing.JLabel;


public class DynamicBeat extends JFrame {

	// 더블 버퍼링을 이용해 매순간 이미지를 불러온다.
	private Image screenImage;
	private Graphics screenGraphics;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/rightButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/hardButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../imgs/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/backButtonBasic.png"));

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../imgs/gameinfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../imgs/judgementLine.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../imgs/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../imgs/noteBasic.png")).getImage();
	private Image Background = new ImageIcon(Main.class.getResource("../imgs/introBackground.jpg")).getImage();

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../imgs/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int buttonSize = 40;
	private int mouseX, mouseY;

	private boolean isMainScreen = false;// 메인화면인지 여qn
	private boolean isGameScreen = false;// 게임화면인지 여부

	ArrayList<Track> trackList = new ArrayList<Track>();

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;

	private Music introMusic = new Music("introMusic.mp3", true);

	private int nowSelected = 0;
	
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

		
		introMusic.start();

		// 음악과 그에 맞는 이미지
		trackList.add(new Track("Sapphire title image.png", "StartSapphireImage.png", "GameSapphireImage.png",
				"Sapphire Selected.mp3", "NIVIRO - Sapphire [NCS Release].mp3"));
		trackList.add(new Track("Phoenix title image.png", "StartPhoenixImage.png", "GamePhoenixImage.png",
				"Phoenix Selected.mp3", "Netrum & Halvorsen - Phoenix [NCS Release].mp3"));
		trackList.add(new Track("Demons title image.png", "StartDemonsImage.png", "GameDemonsImage.png",
				"Demons Selected.mp3", "NIVIRO - Demons [NCS Release].mp3"));
		exitButton.setBounds(Main.SCREEN_WIDTH - 30, 0, 30, 30);

		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);

		exitButton.addMouseListener(new MouseAdapter() {
			// 해당 버튼에 마우스가 올라오면
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav", false);
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

		startButton.setBounds(Main.SCREEN_WIDTH / 2 - 150, Main.SCREEN_HEIGHT - Main.SCREEN_HEIGHT / 3, 300, 74);

		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);

		startButton.addMouseListener(new MouseAdapter() {
			// 해당 버튼에 마우스가 올라오면
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			// 마우스가 치워지면
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 게임시작 이벤트
				enteredMain();

			}
		});

		add(startButton);

		quitButton.setBounds(Main.SCREEN_WIDTH / 2 - 150, Main.SCREEN_HEIGHT - Main.SCREEN_HEIGHT / 4, 300, 74);

		quitButton.setBorderPainted(false);// 테두리 유무
		quitButton.setContentAreaFilled(false);// 테두리 내부 보이기 여부
		quitButton.setFocusPainted(false);

		quitButton.addMouseListener(new MouseAdapter() {
			// 해당 버튼에 마우스가 올라오면
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav", false);
				buttonEnterdeMusic.start();
			}

			// 마우스가 치워지면
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 누르면 0 해당 프로그램 종료
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("exitBtnPressed.wav", false);
				buttonPressedMusic.start();
				try {
					// 약간의 딜레이를 준다
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});

		add(quitButton);

		leftButton.setVisible(false);
		leftButton.setBounds(Main.SCREEN_WIDTH / 4 - buttonSize, Main.SCREEN_HEIGHT - Main.SCREEN_HEIGHT / 4,buttonSize, buttonSize);

		leftButton.setBorderPainted(false);// 테두리 유무
		leftButton.setContentAreaFilled(false);// 테두리 내부 보이기 여부
		leftButton.setFocusPainted(false);

		leftButton.addMouseListener(new MouseAdapter() {
			// 해당 버튼에 마우스가 올라오면
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav", false);
				buttonEnterdeMusic.start();
			}

			// 마우스가 치워지면
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 누르면 0 해당 프로그램 종료
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("exitBtnPressed.wav", false);
				buttonPressedMusic.start();
				// 왼쪽버튼 클릭 이벤트
				selectLeft();
			}
		});

		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(Main.SCREEN_WIDTH - Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT - Main.SCREEN_HEIGHT / 4,
				buttonSize, buttonSize);

		rightButton.setBorderPainted(false);// 테두리 유무
		rightButton.setContentAreaFilled(false);// 테두리 내부 보이기 여부
		rightButton.setFocusPainted(false);

		rightButton.addMouseListener(new MouseAdapter() {
			// 해당 버튼에 마우스가 올라오면
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav", false);
				buttonEnterdeMusic.start();
			}

			// 마우스가 치워지면
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 누르면 0 해당 프로그램 종료
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("exitBtnPressed.wav", false);
				buttonPressedMusic.start();
				// 오른쪽버튼 클릭 이벤트
				selectRight();
			}
		});

		add(rightButton);

		easyButton.setVisible(false);
		easyButton.setBounds(Main.SCREEN_WIDTH / 2 - 260, Main.SCREEN_HEIGHT - Main.SCREEN_HEIGHT / 4 + 70, 250, 70);

		easyButton.setBorderPainted(false);// 테두리 유무
		easyButton.setContentAreaFilled(false);// 테두리 내부 보이기 여부
		easyButton.setFocusPainted(false);

		easyButton.addMouseListener(new MouseAdapter() {
			// 해당 버튼에 마우스가 올라오면
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav", false);
				buttonEnterdeMusic.start();
			}

			// 마우스가 치워지면
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 누르면 0 해당 프로그램 종료
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("exitBtnPressed.wav", false);
				buttonPressedMusic.start();

				gameStart(nowSelected, "easy");
			}
		});

		add(easyButton);

		hardButton.setVisible(false);
		hardButton.setBounds(Main.SCREEN_WIDTH - Main.SCREEN_WIDTH / 2 + 10,
				Main.SCREEN_HEIGHT - Main.SCREEN_HEIGHT / 4 + 70, 250, 70);

		hardButton.setBorderPainted(false);// 테두리 유무
		hardButton.setContentAreaFilled(false);// 테두리 내부 보이기 여부
		hardButton.setFocusPainted(false);

		hardButton.addMouseListener(new MouseAdapter() {
			// 해당 버튼에 마우스가 올라오면
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav", false);
				buttonEnterdeMusic.start();
			}

			// 마우스가 치워지면
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 누르면 0 해당 프로그램 종료
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("exitBtnPressed.wav", false);
				buttonPressedMusic.start();

				gameStart(nowSelected, "hard");
			}
		});

		add(hardButton);

		backButton.setVisible(false);
		backButton.setBounds(30,50,60,60);

		backButton.setBorderPainted(false);// 테두리 유무
		backButton.setContentAreaFilled(false);// 테두리 내부 보이기 여부
		backButton.setFocusPainted(false);

		backButton.addMouseListener(new MouseAdapter() {
			// 해당 버튼에 마우스가 올라오면
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdeMusic = new Music("exitBtnEntered.wav", false);
				buttonEnterdeMusic.start();
			}

			// 마우스가 치워지면
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 누르면 0 해당 프로그램 종료
			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});

		add(backButton);

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
	}

	// paint는 JFrame을 상속받은 GUI게임에서 가장 먼저 그려주는 것
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphics);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics2D g) {
		// 배경화면을 반복적으로 그려주는거
		g.drawImage(Background, 0, 0, null);
		if (isMainScreen)
		{
			g.drawImage(selectedImage, (Main.SCREEN_WIDTH - 400) / 2, Main.SCREEN_HEIGHT / 2 - 200, null);
			g.drawImage(titleImage, 340, 30, null);
		}
		if(isGameScreen)
		{
			//나중에 정리하자
			g.drawImage(noteRouteImage,240,30,null);
			g.drawImage(noteRouteImage,344,30,null);
			g.drawImage(noteRouteImage,448,30,null);
			g.drawImage(noteRouteImage,548,30,null);
			g.drawImage(noteRouteImage,648,30,null);
			g.drawImage(noteRouteImage,752,30,null);
			g.drawImage(noteRouteImage,856,30,null);
			g.drawImage(noteRouteImage,960,30,null);
			g.drawImage(noteRouteLineImage,340,30,null);
			g.drawImage(noteRouteLineImage,444,30,null);
			g.drawImage(noteRouteLineImage,540,30,null);
			g.drawImage(noteRouteLineImage,748,30,null);
			g.drawImage(noteRouteLineImage,852,30,null);
			g.drawImage(noteRouteLineImage,956,30,null);
			g.drawImage(noteRouteLineImage,1060,30,null);
			g.drawImage(gameInfoImage,0,660,null);
			g.drawImage(judgementLineImage,0,580,null);
			g.drawImage(noteBasicImage,344,580,null);
			g.drawImage(noteBasicImage,968,200,null);
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.drawString("NIVIRO - Sapphire", 20, 702);//이부분도 트랙 클래스를 이용하자
			g.drawString("Easy", 1192, 702);
			g.setColor(Color.DARK_GRAY);
			g.drawString("s", 282, 609);
			g.drawString("d", 384, 609);
			g.drawString("f", 485, 609);
			g.drawString("Space bar", 573,609 );
			g.drawString("j", 796, 609);
			g.drawString("k", 896, 609);
			g.drawString("l", 1004, 609);
			g.setColor(Color.LIGHT_GRAY);
			g.setFont(new Font("Elephant",Font.BOLD,30));
			g.drawString("000000", 565, 702);
			
		}
		paintComponents(g);// JLabel 같은거를 그려준다.
		this.repaint();
	}

	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../imgs/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../imgs/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music("../music/" + trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}

	// 매개변수에 선택한 곡과 난이도를 받아 온다
	public void gameStart(int newSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		isGameScreen = true;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		backButton.setVisible(true);

		Background = new ImageIcon(Main.class.getResource("../imgs/" + trackList.get(newSelected).getGameImage())).getImage();

	}
	public void backMain() {
		enteredMain();
	}
	
	public void enteredMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../imgs/MainBackground.jpg")).getImage();
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		backButton.setVisible(false);
		isMainScreen = true;
		isGameScreen = false;
		nowSelected=0;
		introMusic.close();
		selectTrack(0);
	}
}
