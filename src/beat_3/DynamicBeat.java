package beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;//GUI 사용되는 라이브러리

public class DynamicBeat extends JFrame {

	//더블 버퍼링을 이용해 매순간 이미지를 불러온다.
	private Image screenImage;
	private Graphics screenGraphics;
	
	//배경사진
	private Image introBackground;
	
	public DynamicBeat() {
		setTitle("DynamicBeat");//제목
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//메인에서 설정한 해상도
		setResizable(false);//창크기 변경 가능 여부 false
		setLocationRelativeTo(null);//실행시 컴퓨터 정중앙에 창이 뜨게 된다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임 창을 종료했을때 프로그램이 종료되게 하는 것
		setVisible(true);//게임창을 보이게 한다.
		
		//메인 클래스의 위치를 기반으로 이미지 파일을 얻은뒤  그 이미지를 Background 변수에 초기화
		introBackground = new ImageIcon(Main.class.getResource("../imgs/introBackground.jpg")).getImage();
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}
	
	//paint는 JFrame을 상속받은 GUI게임에서 가장 먼저 그려주는 것
	public void paint(Graphics g) {
		//프로그램 화면 만큼 이미지를 생성해서
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		//배경화면으로 쓸 그래픽 객체를 얻어오겠다
		screenGraphics = screenImage.getGraphics();
		//함수
		screenDraw(screenGraphics);
		//그려준다
		g.drawImage(screenImage, 0, 0, null);
		
	}
	public void screenDraw(Graphics g) {
		//0.0 위치에 그려준다
		g.drawImage(introBackground, 0, 0, null);
		//페인트 함수를 반복실행한다.
		this.repaint();
	}
	
}
