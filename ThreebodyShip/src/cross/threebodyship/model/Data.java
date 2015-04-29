package cross.threebodyship.model;

import java.util.ArrayList;

public class Data {
	public ArrayList<Star> starList;
	public Ship ship;
	
	public Data(int gameNumber){
		starList = new ArrayList<Star>();
		ship = new Ship();
		
		switch(gameNumber){
		case 0:setGame0();break;
		case 1:
		}
	}
	
	public void setGame0(){
		Star star = new Star();
		
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		
		//初始化星球
		star.setLocation(512, 518);
		star.setSize(366);
		star.setGravityScope(710);
		
		starList.add(star);
	}
	
}
