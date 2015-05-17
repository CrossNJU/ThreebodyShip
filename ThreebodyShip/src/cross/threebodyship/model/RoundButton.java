package cross.threebodyship.model;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class RoundButton extends JButton implements Runnable{
	
	public Point location;
	public double size;
	public Point roundPoint;
	
	public double dtheta;
	public double nowtheta = 0;
	public double speed;
	public double refreshTime;
	public double r;
	
	public boolean isRound = false;
	
	public RoundButton(){
		location = new Point();
		roundPoint = new Point();
		
	}
	
	public void setData(Point p1, Point p2, double size, double theta){
		isRound = true;
		location.x = p1.x + size/2;
		location.y = p1.y + size/2;
		roundPoint.x = p2.x;
		roundPoint.y = p2.y;
		r = Math.sqrt((location.x-roundPoint.x)*
				(location.x-roundPoint.x)+
				(location.y-roundPoint.y)*
				(location.y-roundPoint.y));
		this.size = size;
		speed = 5;
		refreshTime = 10;
		nowtheta = theta;
	}
	
	public void run() {
		dtheta = speed*refreshTime/r/100;
		while(isRound){
			try {
				Thread.sleep((long)refreshTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			double nowX = roundPoint.x + r*Math.cos(nowtheta + dtheta);
			double nowY = roundPoint.y + r*Math.sin(nowtheta + dtheta);
			
			nowtheta += dtheta;
			
			this.setBounds((int)(nowX - size/2), (int)(nowY - size/2), (int)size, (int)size);
		}
	}
}
