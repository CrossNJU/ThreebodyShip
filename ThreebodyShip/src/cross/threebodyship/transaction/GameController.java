package cross.threebodyship.transaction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import cross.threebodyship.model.Game;
import cross.threebodyship.model.Rect;
import cross.threebodyship.model.Ship;

public class GameController implements KeyListener,MouseMotionListener,MouseListener{
	Game game;
	Thread t;
	Rect r;
	private int count = 0;
	
	public GameController(Game game) {
		this.game = game;
//		r = new Rect(game);
//		t = new Thread(r);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		int keycode = arg0.getKeyCode();
		
		//开始阶段用户设置相应参数
		if(game.isStarting)
			switch(keycode){
				case KeyEvent.VK_U:{
					game.ship.setDegreeToEast(
						game.ship.getDegreeToEast()+Math.toRadians(3));
					break;
				}
				case KeyEvent.VK_S:{
					game.ship.setSpeed(
						game.ship.getSpeed()+0.5);
					break;
				}
				case KeyEvent.VK_O:{
					game.isStarting = false;
					game.inGame = true;
					break;
				}
				case KeyEvent.VK_UP:{
					game.ship.setLocation(game.ship.getLocation().x, 
							game.ship.getLocation().y-3);
					break;
				}
				case KeyEvent.VK_DOWN:{
					game.ship.setLocation(game.ship.getLocation().x,
							game.ship.getLocation().y+3);
					break;
				}
		}
			
		//游戏阶段用户操作
		if(game.inGame)
			switch(keycode){
				case KeyEvent.VK_SPACE:{
					if(count == 1){
						this.game.ship.setState(true);
						count = 0;
					}
					else{
						count++;
						this.game.ship.setState(false);
					}
					break;
				}
				case KeyEvent.VK_UP:{
					Ship temp = this.game.ship;
					temp.setSpeed(this.game.speedChangeRate*temp.getSpeed());
					break;
				}
				case KeyEvent.VK_DOWN:{
					Ship temp = this.game.ship;
					temp.setSpeed(temp.getSpeed()/this.game.speedChangeRate);
					break;
				}
				case KeyEvent.VK_H:{
					Ship temp = this.game.ship;
					if(game.isInScope && temp.roundStar!=null){
						temp.isRound = true;
						temp.roundDtheta = temp.getSpeed()*(double)game.getRI()/100/temp.roundDistance;
						break;
					}
				}
				case KeyEvent.VK_Q:{
					Ship temp = this.game.ship;
					temp.isRound = false;
					temp.roundStar = null;
//					double d = temp.degreeToWest + Math.PI;
//					if(d>=Math.PI*2) d-= Math.PI*2;
//					temp.setDegreeToEast(d);
					break;
				}
			}
		
		if(keycode == KeyEvent.VK_ENTER) this.game.reset();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(game.isStarting){
			game.mousePoint.x = e.getX();
			game.mousePoint.y = e.getY();
			
			double theta = Math.atan((e.getY() - game.startingPoint.y)/
					(e.getX() - game.startingPoint.x));
			
			double x = game.startingPoint.x + game.StartingAreaR*Math.cos(theta);
			double y = game.startingPoint.y + game.StartingAreaR*Math.sin(theta);
			
			game.ship.setLocation(x, y);
			
			if(theta<0) theta += Math.PI*2;
			
			game.ship.setDegreeToEast(theta);
//			System.out.println("theta:"+Math.toDegrees(theta));
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		game.breakPress = true;
	}
	@Override
	public void mousePressed(MouseEvent e) {
//		r.stop2 = false;
		r = new Rect(this.game);
		t = new Thread(r);
		t.start();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//t.interrupt();
		r.stop2 = true;
		game.isStarting = false;
		game.inGame = true;
		//System.out.println("hi");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	}
