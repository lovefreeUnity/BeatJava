package beat_16;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../imgs/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	
	//노트타입이 뭔지 반환해주는 함수
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {//현재 노트의 진행여부
		return proceeded;
	}
	public void close() {//노트 진행 중지 혹은 삭제를 위한 함수
		proceeded = false;
	}
	
	public Note(String noteType) {
		if (noteType.equals("S")) {// 노트 타입에 따라 x값을 바꿔준다
			x = 228;
		} else if (noteType.equals("D")) {
			x = 332;
		} else if (noteType.equals("F")) {
			x = 436;
		} else if (noteType.equals("Space")) {
			x = 540;
		} else if (noteType.equals("J")) {
			x = 744;
		} else if (noteType.equals("K")) {
			x = 848;
		} else if (noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}

	public void screenDraw(Graphics2D g) {
		if (!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else// 스페이스바의 노트
		{
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}

	public void drop() {// 노트의 y좌표를 움직여준다
		y += Main.NOTE_SPEED;
		if(y > 620) {
			//노트를 놓쳤을떼
			System.out.println("Miss");
			close();
		}
	}

	@Override
	public void run() {// 노트가 떨어지는 애니메이션
		try {
			while (true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void judge() {
		if(y >= 613) {
			System.out.print("Late");
			close();
		}
		else if(y >= 600) {
			System.out.print("Good");
			close();
		}
		else if(y >= 573) {
			System.out.print("Perfect");
			close();
		}
		else if(y >= 550) {
			System.out.print("Good");
			close();
		}
		else if(y >= 535) {
			System.out.print("Early");
			close();
		}
	}
}
