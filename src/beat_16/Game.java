package beat_16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../imgs/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../imgs/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../imgs/gameinfo.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image blueFlareImage = new ImageIcon(Main.class.getResource("../imgs/blueFlare.png")).getImage();

	private String titleName;
	private String diffcutly;
	private String musicTitle;
	private Music gameMusic;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.diffcutly = difficulty;
		this.musicTitle = musicTitle;

		gameMusic = new Music(this.musicTitle, false);
		
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for (int i = 0; i < noteList.size(); i++)
		{
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);// 이부분도 트랙 클래스를 이용하자
		g.drawString(diffcutly, 1192, 702);
		g.setColor(Color.DARK_GRAY);
		g.drawString("s", 282, 609);
		g.drawString("d", 384, 609);
		g.drawString("f", 485, 609);
		g.drawString("Space bar", 573, 609);
		g.drawString("j", 796, 609);
		g.drawString("k", 896, 609);
		g.drawString("l", 1004, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
		g.drawImage(blueFlareImage,320,379,null);
	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();	
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName,this.diffcutly);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName,String diffcutly) {
		Beat[] beats = null;
		if(titleName.equals("NIVIRO - Sapphire")&& diffcutly.equals("Easy"))//150bpm이다
		{
			//처음 비트가 떨어지는 시간
			int startTime = 1500 - Main.REACH_TIME * 1000;
			int gap = 150;//최소 박자의 간격
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap*2, "S"),
					new Beat(startTime + gap*3, "D"),
					new Beat(startTime + gap*4, "F"),
					new Beat(startTime + gap*5, "F"),
			};
		}
		else if(titleName.equals("NIVIRO - Sapphire")&& diffcutly.equals("Hard"))
		{
			//처음 비트가 떨어지는 시간
			int startTime = 1500 - Main.REACH_TIME * 1000;
			int gap = 150;//최소 박자의 간격
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap*2, "S"),
					new Beat(startTime + gap*3, "D"),
					new Beat(startTime + gap*4, "F"),
					new Beat(startTime + gap*5, "F"),
			};
		}
		else if (titleName.equals("NIVIRO - Demons")&& diffcutly.equals("Easy")){//160bpm
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if (titleName.equals("NIVIRO - Demons")&& diffcutly.equals("Hard")){//160bpm
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Netrum & Halvorsen - Phoenix")&& diffcutly.equals("Easy")) {//165bpm
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),	
			};
		}
		else if(titleName.equals("Netrum & Halvorsen - Phoenix")&& diffcutly.equals("Hard")) {//165bpm
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),	
			};
		}
		int i=0;
		gameMusic.start();
		while(i < beats.length && !interrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.gettime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//노트가 내려 올때 배열상 앞에 있는 노트의 키를 눌렀는지 체크 하여 판정한다
	public void judge(String input) {
		for(int i=0;i < noteList.size();i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
}