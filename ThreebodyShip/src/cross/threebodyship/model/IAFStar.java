package cross.threebodyship.model;

import java.awt.Color;

public class IAFStar extends Star{
	
	public double SpeedChangeRate;
	public boolean changed = false;
	
	public IAFStar(){
		style = "IAF";
		color = Color.GREEN;
	}
}
