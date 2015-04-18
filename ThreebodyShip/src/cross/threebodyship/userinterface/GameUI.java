package cross.threebodyship.userinterface;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
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
		
		JPanel text = new JPanel();
		speedLabel = new JLabel();
		degreeLabel = new JLabel();
		
		//可以去掉。。。
		text.add(speedLabel);
		text.add(degreeLabel);
		
		this.add(text,BorderLayout.NORTH);
		this.add(mainCanvas,BorderLayout.CENTER);
		this.setLocation(100,100);
		
		this.addKeyListener(controller);
	}
	
	//主画板
	public void repaintMain(){
		//mainCanvas.repaint();
		Graphics g = mainCanvas.getGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0,0,mainCanvas.getWidth(),mainCanvas.getHeight());
			
		//System.out.println(1);
		speedLabel.setText("speed:"+Double.toString(game.ship.getSpeed()));
		degreeLabel.setText("degreeToEast:"+Double.toString(Math.toDegrees(game.ship.getDegreeToEast())));

		paintWinArea(g);
		paintStartArea(g);
		paintStar(g,game.star);
		paintShip(g,game.ship);
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
