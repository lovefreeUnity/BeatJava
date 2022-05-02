package beat_16;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../imgs/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	
	//��ƮŸ���� ���� ��ȯ���ִ� �Լ�
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {//���� ��Ʈ�� ���࿩��
		return proceeded;
	}
	public void close() {//��Ʈ ���� ���� Ȥ�� ������ ���� �Լ�
		proceeded = false;
	}
	
	public Note(String noteType) {
		if (noteType.equals("S")) {// ��Ʈ Ÿ�Կ� ���� x���� �ٲ��ش�
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
		} else// �����̽����� ��Ʈ
		{
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}

	public void drop() {// ��Ʈ�� y��ǥ�� �������ش�
		y += Main.NOTE_SPEED;
		if(y > 620) {
			//��Ʈ�� ��������
			System.out.println("Miss");
			close();
		}
	}

	@Override
	public void run() {// ��Ʈ�� �������� �ִϸ��̼�
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
