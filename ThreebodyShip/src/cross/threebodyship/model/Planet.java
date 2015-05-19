package cross.threebodyship.model;

import java.awt.Color;

public class Planet implements Runnable {
	
	public Star roundStar;
	public double roundR;
	public int size;
	public double speed;
	public double Theta = 0;
	public Point location;
	public static long time = 1;
	
	public boolean stop = false;
	public boolean isExisted = true;
	
	public Color color = Color.BLUE;
	
	public Planet(){
		location = new Point();
//		start
	}
	
	public void setStartLocation(){
		location.x = roundStar.getLocation().x - roundR;
		location.y = roundStar.getLocation().y;
	}
	
	public void run() {
		while (!stop){ 
		try {
			Theta += speed*time/roundR;
			
			if(Theta>=Math.PI*2) Theta-=Math.PI*2;
			
			location.x = roundStar.getLocation().x + roundR*Math.cos(Theta);
			location.y = roundStar.getLocation().y + roundR*Math.sin(Theta);
			
			Thread.sleep(time*100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	}
}
