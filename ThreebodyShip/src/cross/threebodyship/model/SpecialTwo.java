package cross.threebodyship.model;

import java.util.ArrayList;

public class SpecialTwo extends Star{
	
	public ArrayList<Star> connectedStars;
	public ArrayList<Planet> conectedPlanets;
	public int enter = 0;
	
	public SpecialTwo(){
		connectedStars = new ArrayList<Star>();
		conectedPlanets = new ArrayList<Planet>();
		
		style = "special2";
//		isExisted = false;
	}
}
