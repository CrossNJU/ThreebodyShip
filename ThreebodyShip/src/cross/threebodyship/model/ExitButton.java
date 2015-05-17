package cross.threebodyship.model;

import javax.swing.JButton;

public class ExitButton extends JButton implements Runnable{
	
	public Point location;
	public double size;
	public Point roundPoint;
	
	public double dtheta;
	public double nowtheta = 0;
	public double speed;
	public double refreshTime;
	public double r;
	
	public boolean isRound = false;
	
	public ExitButton(){
		location = new Point();
		roundPoint = new Point();
		
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
