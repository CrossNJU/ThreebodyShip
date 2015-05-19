package cross.threebodyship.userinterface;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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

	public GameUI(Game game, StageUI stageUI) {
		this.stageUI = stageUI;
		this.game = game;

		init();
	}

	public void init() {
		setLayout(null);
		setSize(MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);

		pauseUI = new PauseUI(stageUI,this);
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

		Image planet = new ImageIcon("img/Gamebackground/Planet/planet-"
				+ game.gameNumber + ".png").getImage();
		for (int i = 0; i < game.data.planets.size(); i++) {
			g.drawImage(planet, (int) game.data.planets.get(i).location.x
					- (int) game.data.planets.get(i).size/2,
					(int) game.data.planets.get(i).location.y
							- (int) game.data.planets.get(i).size/2, null);
		}

		paintplanet(g, game.planets);
		paintstar(g, game.starList);
		paintRocks(g, game.rockList);
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

			double alpha = 100;

			if (starList.get(i).style.equals("Super")) {
				SuperStar superStar = (SuperStar) starList.get(i);
				alpha = superStar.leftTime * 50;
				if (alpha < 0)
					alpha = 0;
			}
			try {
				g.setColor(new Color(0, 255, 0, (int) alpha));
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
		g.setColor(Color.green);

		for (int i = 0; i < planets.size(); i++) {
			Planet planet = planets.get(i);
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

	// 观察Game的动态
	public void update(Observable o, Object arg0) {
		repaint();
	}

	public class RotateThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			// TODO Auto-generated method stub
			while (true) {
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

}
