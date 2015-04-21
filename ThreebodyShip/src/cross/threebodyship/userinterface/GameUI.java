package cross.threebodyship.userinterface;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.model.Game;
import cross.threebodyship.model.Ship;
import cross.threebodyship.model.Star;
import cross.threebodyship.transaction.GameController;

public class GameUI extends JPanel implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Canvas mainCanvas;
	GameController controller;
	Game game;
	JLabel speedLabel;
	JLabel degreeLabel;
	
	public GameUI(Game game,int width,int height){
		this.game = game;
		mainCanvas = new Canvas();
		mainCanvas.setSize(width, height);
		controller = new GameController(this.game);
		
		//System.out.println(mainCanvas.getHeight());
		
		JPanel text = new JPanel();
		speedLabel = new JLabel();
		degreeLabel = new JLabel();
		
		//可以去掉。。。
		text.add(speedLabel);
		text.add(degreeLabel);
		
		this.add(text,BorderLayout.NORTH);
		this.add(mainCanvas,BorderLayout.CENTER);
		this.setLocation(100,100);
		
		//this.requestFocus();
		mainCanvas.addKeyListener(controller);
		mainCanvas.addMouseListener(controller);
		mainCanvas.addMouseMotionListener(controller);
	}
	
	//主画板
	public void repaintMain(){
		//mainCanvas.repaint();
		Graphics g = mainCanvas.getGraphics();
//		g.setColor(Color.GRAY);
//		g.fillRect(0,0,mainCanvas.getWidth(),mainCanvas.getHeight());
		Image GB_IMG = new ImageIcon("img/GameBackground/bg-chap00-stage01.png").getImage();
		g.drawImage(GB_IMG, 0, 0,mainCanvas.getWidth(),mainCanvas.getHeight(),0,0,1024,768,null);
		//System.out.println(1);
		speedLabel.setText("speed:"+Double.toString(game.ship.getSpeed()));
		degreeLabel.setText("degreeToEast:"+Double.toString(Math.toDegrees(game.ship.getDegreeToEast())));

		paintWinArea(g);
		paintStartArea(g);
		paintStar(g,game.star);
		paintShip(g,game.ship);
		if(game.isStarting) {
			paintLine(g);
			paintRect(g);
		}
	}
		
	//画开始的速度条
	public void paintRect(Graphics g){
		//System.out.println(game.rectheight);
		g.setColor(Color.blue);
		g.fillRect((int)game.mousePoint.x,(int)game.mousePoint.y, game.rectwidth, game.rectheight);
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
		
		int height = mainCanvas.getHeight();
		int width = mainCanvas.getWidth();
		double r = height/4;
		int locationx = width + (int)r/2 - (int)r ;
		int locationy = (int)height/2 - (int)r ;
		
		g.fillOval(locationx, locationy, (int)r*2, (int)r*2);
	}
	
	//画开始的发射台
	public void paintStartArea(Graphics g){
		g.setColor(Color.yellow);
		
		int height = mainCanvas.getHeight();
		double r = height/4;
		int locationx = -(int)r*3/2;
		int locationy = (int)height/2 - (int)r;
		
		g.fillOval(locationx, locationy, (int)r*2, (int)r*2);
	}
	
	//画星球
	public void paintStar(Graphics g, Star star){
		
		g.setColor(Color.pink);
			
		g.fillOval((int)(star.getLocation().x-star.getGravityScope()/2), 
				(int)(star.getLocation().y-star.getGravityScope()/2),
				star.getGravityScope(),
				star.getGravityScope());
			
		g.setColor(Color.BLUE);
			
		g.fillOval((int)(star.getLocation().x-star.getSize()/2),
				(int)(star.getLocation().y-star.getSize()/2),
				star.getSize(),
				star.getSize());
	}
		
	//画飞船
	public void paintShip(Graphics g, Ship ship){
		
		g.setColor(Color.red);
			
		g.fillOval((int)(ship.getLocation().x-ship.getSize()/2),
				(int)(ship.getLocation().y-ship.getSize()/2),
				ship.getSize(),
				ship.getSize());
	}
	
	//观察Game的动态
	public void update(Observable o, Object arg0) {
		repaintMain();
	}

}
