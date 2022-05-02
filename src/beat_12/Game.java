package beat_12;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../imgs/noteBasic.png")).getImage();
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

	private String titleName;
	private String diffcutly;
	private String musicTitle;
	private Music gameMusic;

	public Game(String titleName, String difficulty,String musicTitle) {
		this.titleName = titleName;
		this.diffcutly = difficulty;
		this.musicTitle = musicTitle;
		
		gameMusic = new Music(this.musicTitle, false);
		gameMusic.start();
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
		g.drawImage(noteRouteLineImage, 1052, 30, null);;
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		g.drawImage(noteBasicImage, 344, 580, null);
		g.drawImage(noteBasicImage, 960, 200, null);
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);// �̺κе� Ʈ�� Ŭ������ �̿�����
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
	}

	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	}

	@Override
	public void run() {

	}
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
}