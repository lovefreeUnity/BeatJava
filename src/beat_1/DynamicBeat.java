package beat_1;

import javax.swing.JFrame;//GUI 사용되는 라이브러리

public class DynamicBeat extends JFrame {

	public DynamicBeat() {
		setTitle("DynamicBeat");//제목
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//메인에서 설정한 해상도
		setResizable(false);//창크기 변경 가능 여부 false
		setLocationRelativeTo(null);//실행시 컴퓨터 정중앙에 창이 뜨게 된다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임 창을 종료했을때 프로그램이 종료되게 하는 것
		setVisible(true);//게임창을 보이게 한다.
	}
	
}
