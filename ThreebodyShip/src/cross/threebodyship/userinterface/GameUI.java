package cross.threebodyship.userinterface;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.model.Game;
import cross.threebodyship.model.Planet;
import cross.threebodyship.model.Ship;
import cross.threebodyship.model.Star;
import cross.threebodyship.transaction.GameController;

public class GameUI extends JPanel implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StageUI stageUI;
	PauseUI pauseUI;
	GameController controller;
	public Game game;
	JLabel speedLabel;
	JLabel degreeLabel;
	public int num;
	JButton pauseButton;
	
	
	
	public GameUI(Game game,StageUI stageUI){
		this.stageUI = stageUI;
		this.game = game;
		
		init();
	}
	
	public void init(){
		setLayout(null);
		setSize(MainUI.WIDTH,MainUI.HEIGHT);
		
		pauseUI = new PauseUI(stageUI);
		
		controller = new GameController(this.game);
		
		addKeyListener(controller);
		addMouseListener(controller);
		addMouseMotionListener(controller);
		
		pauseButton = new JButton();
		pauseButton.setBounds(924, 0, 100, 100);
		pauseButton.setIcon(new ImageIcon("img/Button/btn-menu-normal.png"));
		pauseButton.setRolloverIcon(new ImageIcon("img/Button/btn-menu-hover.png"));
		pauseButton.setContentAreaFilled(false);
		pauseButton.setBorderPainted(false);
		pauseButton.setFocusPainted(false);
		add(pauseButton);
	}
	
	public void paintComponent(Graphics g){
		g.fillRect(0,0,MainUI.WIDTH,MainUI.HEIGHT);
		Image GB_IMG = new ImageIcon("img/GameBackground/bg-stage"+game.gameNumber+".png").getImage();
		g.drawImage(GB_IMG, 0, 0,MainUI.WIDTH,MainUI.HEIGHT,0,0,1024,768,null);


//		paintWinArea(g);
//		paintstarList.get(i)tArea(g);
//		paintstar(g,game.starList);
		paintplanet(g,game.planets);
		paintShip(g,game.ship);
		if(game.isStarting) {
			paintLine(g);
//			paintRect(g);
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
	
	//画开始方向线
	public void paintLine(Graphics g){
		g.setColor(Color.RED);
		g.drawLine((int)game.startingPoint.x, (int)game.startingPoint.y, 
				(int)game.mousePoint.x, (int)game.mousePoint.y);
	}
	
	//画获胜区域
	public void paintWinArea(Graphics g){
		g.setColor(Color.yellow);
		
//		int height = mainCanvas.getHeight();
//		double r = 690;
		int locationx = (int)(game.winPoint.x - game.winAreaR);
		int locationy = (int)(game.winPoint.y -  game.winAreaR) ;
		
		g.fillOval(locationx, locationy, (int)game.winAreaR*2, (int)game.winAreaR*2);
	}
	
	//画开始的发射台
	public void paintstartArea(Graphics g){
		g.setColor(Color.yellow);
		
		int height = MainUI.HEIGHT;
		double r = 690;
		int locationx = -1330;
		int locationy = (int)(height/2 - r);
		
		g.fillOval(locationx, locationy, (int)r*2, (int)r*2);
	}
	
	//画星球
	public void paintstar(Graphics g, ArrayList<Star> starList){
		
		
		for(int i=0;i<starList.size();i++){
			
			g.setColor(new Color(0,255,0,100));
		g.fillOval((int)(starList.get(i).getLocation().x-starList.get(i).getGravityScope()/2), 
				(int)(starList.get(i).getLocation().y-starList.get(i).getGravityScope()/2),
				starList.get(i).getGravityScope(),
				starList.get(i).getGravityScope());
			
		g.setColor(new Color(0, 0, 0, 100));
			
		g.fillOval((int)(starList.get(i).getLocation().x-starList.get(i).getSize()/2),
				(int)(starList.get(i).getLocation().y-starList.get(i).getSize()/2),
				starList.get(i).getSize(),
				starList.get(i).getSize());
		}
	}
	
	public void paintplanet(Graphics g,ArrayList<Planet> planets){
		g.setColor(Color.green);
		
		for(int i = 0; i< planets.size(); i++){
			Planet planet = planets.get(i);
			g.fillOval((int)(planet.location.x-planet.size/2),(int)(planet.location.y-planet.size/2)
					, planet.size, planet.size);
		}
		
	}
		
	//画飞船
	public void paintShip(Graphics g, Ship ship){
//		
//		g.setColor(Color.red);
//			
//		g.fillOval((int)(ship.getLocation().x-ship.getSize()/2),
//				(int)(ship.getLocation().y-ship.getSize()/2),
//				ship.getSize(),
//				ship.getSize());
//		
		Image ship_img = new ImageIcon("img/Ship/ship.png").getImage();
		g.drawImage(ship_img, (int)(ship.getLocation().x-ship.getSize()/2),
				(int)(ship.getLocation().y-ship.getSize()/2),(int)(ship.getLocation().x-ship.getSize()/2)+ship.getSize()*3,
		(int)(ship.getLocation().y-ship.getSize()/2)+ship.getSize()*3,0,0,425,431,null);
	}
	
	//观察Game的动态
	public void update(Observable o, Object arg0) {
		repaint();
	}

}
