package beat_4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	private Player player;
	private boolean isLoop;//무한 반복인지 한번만 재생인지 설정할 변수
	private File file;
	private FileInputStream fiS;
	private BufferedInputStream bis;
	
	public Music(String name,boolean isLoop) {
		//try 에서 오류 발생시 catch로 넘어 간다.
		try {
			//변수 초기화
			this.isLoop=isLoop;
			//파일을 버퍼에 담아서 읽어올 수 있다
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fiS = new FileInputStream(file);
			bis = new BufferedInputStream(fiS);
			player = new Player(bis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//지금이 노래의 몇초인지 알려주는 함수
	public int gettime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	public void close() {
		isLoop = false;
		player.close();
		//노래 들려주는 메소드 종료
		this.interrupt();
	}
	//isLoop 가 true 이면 이곡은 무한 반복이다.
	@Override
	public void run() {
		try {
			do {
				player.play();
				fiS = new FileInputStream(file);
				bis = new BufferedInputStream(fiS);
				player = new Player(bis);
			}while(isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
