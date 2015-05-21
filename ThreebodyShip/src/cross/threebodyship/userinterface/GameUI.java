package cross.threebodyship.userinterface;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import cross.threebodyship.listener.PauseButtonListener;
//import cross.threebodyship.listener.PauseButtonListener;
import cross.threebodyship.model.Game;
import cross.threebodyship.model.Planet;
import cross.threebodyship.model.Rock;
import cross.threebodyship.model.Ship;
import cross.threebodyship.model.Star;
import cross.threebodyship.model.SuperStar;
import cross.threebodyship.transaction.GameController;
import cross.threebodyship.util.RotateImage;

public class GameUI extends ThreebodyPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StageUI stageUI;
	public PauseUI pauseUI;
	GameController controller;
	public Game game;
	JLabel speedLabel;
	JLabel degreeLabel;
	public int num;
	JButton pauseButton;
	public BeforeUI beforeUI;
	JLabel stageTitle = null;

	int degree = 0;
	BufferedImage ship_img;
	public RotateThread rt = new RotateThread();

	int currentSuper1 = 1;
	int currentSuper2 = 1;
	SuperStar[] superStar = new SuperStar[2];
	Image[] superImage1 = new Image[51];
	Image[] superImage2 = new Image[51];
	MediaTracker tracker;
	public SuperAnimeThread1 sat1;
	public SuperAnimeThread2 sat2;
	int left1;
	int left2;

	public GameUI(Game game, StageUI stageUI) {
		this.stageUI = stageUI;
		this.game = game;

		init();
	}

	public void init() {
		setLayout(null);
		setSize(MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);

		pauseUI = new PauseUI(stageUI, this);
		pauseUI.setVisible(false);
		add(pauseUI);

		controller = new GameController(this.game);

		addKeyListener(controller);
		addMouseListener(controller);
		addMouseMotionListener(controller);

		// beforeUI = new BeforeUI(this);
		// add(beforeUI);

		pauseButton = new JButton();
		pauseButton.setBounds(924, 0, 100, 100);
		pauseButton.setIcon(new ImageIcon("img/Button/btn-pause-normal.png"));
		pauseButton.setRolloverIcon(new ImageIcon(
				"img/Button/btn-pause-hover.png"));
		pauseButton.setContentAreaFilled(false);
		pauseButton.setBorderPainted(false);
		pauseButton.setFocusPainted(false);
		pauseButton.addMouseListener(new PauseButtonListener(this, pauseUI));
		add(pauseButton);

		setupSuperImg1();
		setupSuperImg2();
		sat1 = new SuperAnimeThread1();
		sat2 = new SuperAnimeThread2();
	}

	public void paintComponent(Graphics g) {
		// g.fillRect(0,0,MainUI.WIDTH,MainUI.HEIGHT);

		Image cover = new ImageIcon("img/GameBackground/cover-game.png")
				.getImage();
		g.drawImage(cover, 0, 0, MainUI.WIDTH, MainUI.HEIGHT, 0, 0, 1024, 768,
				null);

		Image GB_IMG = new ImageIcon("img/GameBackground/game-"
				+ game.gameNumber + ".png").getImage();
		g.drawImage(GB_IMG, 0, 0, MainUI.WIDTH, MainUI.HEIGHT, 0, 0, 1024, 768,
				null);
		// 画卫星
		Image planet = new ImageIcon("img/Gamebackground/Planet/planet-"
				+ game.gameNumber + ".png").getImage();
		for (int i = 0; i < game.data.planets.size(); i++) {
			g.drawImage(planet, (int) game.data.planets.get(i).location.x
					- (int) game.data.planets.get(i).size / 2,
					(int) game.data.planets.get(i).location.y
							- (int) game.data.planets.get(i).size / 2, null);
		}

		// 画超新星
		if ((game.gameNumber == 13) || (game.gameNumber == 14)
				|| (game.gameNumber == 15)||(game.gameNumber==16)) {
			int j = 0;
			for (int i = 0; i < game.starList.size(); i++) {
				if (game.starList.get(i).style.equals("Super")) {
					superStar[j] = (SuperStar) game.starList.get(i);
					j++;
				}
			}
			if (game.gameNumber == 16) {
				g.drawImage(
						superImage1[currentSuper1],
						(int) superStar[0].getLocation().x
								- superStar[0].getGravityScope() / 2,
						(int) superStar[0].getLocation().y
								- superStar[0].getGravityScope() / 2+19, null);
			}else{
				g.drawImage(
						superImage1[currentSuper1],
						(int) superStar[0].getLocation().x
								- superStar[0].getGravityScope() / 2,
						(int) superStar[0].getLocation().y
								- superStar[0].getGravityScope() / 2, null);
				if (game.gameNumber == 15) {
					g.drawImage(
							superImage2[currentSuper2],
							(int) superStar[1].getLocation().x
									- superStar[1].getGravityScope() / 2,
							(int) superStar[1].getLocation().y
									- superStar[1].getGravityScope() / 2, null);
				}
			}
			
		}
		

//		paintstar(g, game.starList);
		// paintplanet(g, game.planets);
		// paintRocks(g, game.rockList);

		// paintWinArea(g);
		// paintstartArea(g);
		paintShip(g, game.ship);
		if (game.isStarting) {
			paintPowerTank(g);
		}

	}

	public void paintPowerTank(Graphics g) {
		Image tank = new ImageIcon("img/Component/powertank.png").getImage();
		Image power = new ImageIcon("img/Component/powerfull.png").getImage();
		if (game.rectwidth > 0) {
			g.drawImage(tank, (int) (game.mousePoint.x),
					(int) (game.mousePoint.y) - 30, 134, 38, null);
		}
		g.drawImage(power, (int) (game.mousePoint.x),
				(int) (game.mousePoint.y) - 28, (int) (game.mousePoint.x)
						+ game.rectwidth - 2, (int) (game.mousePoint.y) + 10,
				0, 0, game.rectwidth, 38, null);
	}

	// 画开始方向线
	public void paintLine(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine((int) game.startingPoint.x, (int) game.startingPoint.y,
				(int) game.mousePoint.x, (int) game.mousePoint.y);
	}

	// 画获胜区域
	public void paintWinArea(Graphics g) {
		g.setColor(new Color(255, 255, 0, 100));

		// int height = mainCanvas.getHeight();
		// double r = 690;
		int locationx = (int) (game.winPoint.x - game.winAreaR);
		int locationy = (int) (game.winPoint.y - game.winAreaR);

		g.fillOval(locationx, locationy, (int) game.winAreaR * 2,
				(int) game.winAreaR * 2);
	}

	// 画开始的发射台
	public void paintstartArea(Graphics g) {
		g.setColor(new Color(255, 255, 0, 100));

		int height = MainUI.HEIGHT;
		double r = game.StartingAreaR;
		int locationx = (int) (game.startingPoint.x - game.StartingAreaR);
		int locationy = (int) (game.startingPoint.y - game.StartingAreaR);

		g.fillOval(locationx, locationy, (int) r * 2, (int) r * 2);
	}

	// 画星球
	public void paintstar(Graphics g, ArrayList<Star> starList) {

		for (int i = 0; i < starList.size(); i++) {
			if (!starList.get(i).isExisted)
				continue;

			Color color = starList.get(i).color;

			double alpha = 100;

			if (starList.get(i).style.equals("Super")) {
				SuperStar superStar = (SuperStar) starList.get(i);
				alpha = superStar.leftTime * 50;
				if (alpha < 0)
					alpha = 0;
			}
			try {
				g.setColor(color);
			} catch (Exception e) {
				// TODO: handle exception
			}
			g.fillOval((int) (starList.get(i).getLocation().x - starList.get(i)
					.getGravityScope() / 2), (int) (starList.get(i)
					.getLocation().y - starList.get(i).getGravityScope() / 2),
					starList.get(i).getGravityScope(), starList.get(i)
							.getGravityScope());
			try {

				g.setColor(new Color(0, 0, 0, (int) alpha));
			} catch (Exception e) {
				// TODO: handle exception
			}

			g.fillOval((int) (starList.get(i).getLocation().x - starList.get(i)
					.getSize() / 2),
					(int) (starList.get(i).getLocation().y - starList.get(i)
							.getSize() / 2), starList.get(i).getSize(),
					starList.get(i).getSize());
		}
	}

	public void paintplanet(Graphics g, ArrayList<Planet> planets) {

		for (int i = 0; i < planets.size(); i++) {
			Planet planet = planets.get(i);
			if (!planet.isExisted)
				continue;
			// System.out.println("enter ui:"+i);
			g.setColor(planet.color);
			g.fillOval((int) (planet.location.x - planet.size / 2),
					(int) (planet.location.y - planet.size / 2), planet.size,
					planet.size);
		}

	}

	public void paintRocks(Graphics g, ArrayList<Rock> rocks) {
		g.setColor(Color.blue);

		for (int i = 0; i < rocks.size(); i++) {
			Rock rock = rocks.get(i);
			g.fillOval((int) (rock.location.x - rock.size / 2),
					(int) (rock.location.y - rock.size / 2), (int) rock.size,
					(int) rock.size);
		}
	}

	// 画飞船
	public void paintShip(Graphics g, Ship ship) {

		// Image ship_img = new ImageIcon("img/Ship/ship.png").getImage();
		g.drawImage(ship_img,
				(int) (ship.getLocation().x - ship.getSize() / 2),
				(int) (ship.getLocation().y - ship.getSize() / 2),
				ship.getSize(), ship.getSize(), null);
	}

	// 装载超新星图片
	public void setupSuperImg1() {
		tracker = new MediaTracker(this);
		Toolkit toolkit = getToolkit();
		for (int i = 0; i < superImage1.length; i++) {
			superImage1[i] = toolkit.getImage("img/Gamebackground/Superstar"
					+ game.gameNumber + "/super" + i + ".png");
		}

		for (int i = 0; i < superImage1.length; i++) {
			tracker.addImage(superImage1[i], 0);
		}
	}

	public void setupSuperImg2() {
		tracker = new MediaTracker(this);
		Toolkit toolkit = getToolkit();
		for (int i = 0; i < superImage2.length; i++) {
			superImage2[i] = toolkit.getImage("img/Gamebackground/Superstar"
					+ game.gameNumber + "/super2/super" + i + ".png");
		}

		for (int i = 0; i < superImage2.length; i++) {
			tracker.addImage(superImage2[i], 1);
		}
	}

	// 观察Game的动态
	public void update(Observable o, Object arg0) {
		repaint();
	}

	public class RotateThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (!game.isFailed) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						repaint();
					}
				});

				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}

				degree++;
				degree %= 360;
				BufferedImage src;
				try {
					src = ImageIO.read(new File("img/Ship/ship-0.125.png"));
					ship_img = RotateImage.Rotate(src, degree);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public class SuperAnimeThread1 extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				tracker.waitForID(0);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int maxTime = (int) superStar[0].leftTime;
			while ((currentSuper1 < 50)) {
				try {
					Thread.sleep(20);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (superStar[0].leftTime <= 0) {
					currentSuper1++;
					repaint();
				} else {
					if (game.isFailed) {
						break;
					}
					left1 = (int) superStar[0].leftTime;
					// System.out.println(currentSuper1);
					if (left1 == maxTime) {
						currentSuper1 = maxTime - left1 + 1;
					} else {
						currentSuper1 = maxTime - left1;
					}
				}
			}
			System.out.println("done");
		}
	}

	public class SuperAnimeThread2 extends Thread {
		@Override
		public void run() {
			try {
				tracker.waitForID(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int maxTime = (int) superStar[1].leftTime;
			while ((currentSuper2 < 50)) {
				try {
					Thread.sleep(20);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (superStar[1].leftTime <= 0) {
					currentSuper2++;
					repaint();
				} else {
					if (game.isFailed) {
						break;
					}
					left2 = (int) superStar[1].leftTime;
					// System.out.println(currentSuper1);
					if (left2 == maxTime) {
						currentSuper2 = maxTime - left2 + 1;
					} else {
						currentSuper2 = maxTime - left2;
					}
				}
			}
			System.out.println("done");
		}
	}

}
