package beat_4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	private Player player;
	private boolean isLoop;//���� �ݺ����� �ѹ��� ������� ������ ����
	private File file;
	private FileInputStream fiS;
	private BufferedInputStream bis;
	
	public Music(String name,boolean isLoop) {
		//try ���� ���� �߻��� catch�� �Ѿ� ����.
		try {
			//���� �ʱ�ȭ
			this.isLoop=isLoop;
			//������ ���ۿ� ��Ƽ� �о�� �� �ִ�
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fiS = new FileInputStream(file);
			bis = new BufferedInputStream(fiS);
			player = new Player(bis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//������ �뷡�� �������� �˷��ִ� �Լ�
	public int gettime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	public void close() {
		isLoop = false;
		player.close();
		//�뷡 ����ִ� �޼ҵ� ����
		this.interrupt();
	}
	//isLoop �� true �̸� �̰��� ���� �ݺ��̴�.
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
