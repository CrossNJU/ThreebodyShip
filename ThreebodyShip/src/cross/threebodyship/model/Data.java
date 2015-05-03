//<<<<<<< HEAD

package cross.threebodyship.model;

import java.util.ArrayList;

public class Data {
	public ArrayList<Star> starList;
	public Ship ship;
	
	public Data(int gameNumber){
		starList = new ArrayList<Star>();
		ship = new Ship();
		
		switch(gameNumber){
		case 1:setGame1();break;
		case 2:setGame2();break;
		case 3:setGame3();break;
		}
	}
	
	public void setGame1(){
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
	
	public void setGame2(){
		Star starOne = new Star();
		Star starTwo = new Star();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		
		starOne.setLocation(412,87);
		starOne.setSize(360);
		starOne.setGravityScope(706);
		
		starTwo.setLocation(673,666);
		starTwo.setSize(360);
		starTwo.setGravityScope(706);
		
		starList.add(starOne);
		starList.add(starTwo);
		
	}
	public void setGame3(){
		Star starOne = new Star();
		Star starTwo = new Star();
		Star starThree = new Star();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		
		starOne.setLocation(447,170);
		starOne.setSize(330);
		starOne.setGravityScope(576);
		
		starTwo.setLocation(300,698);
		starTwo.setSize(288);
		starTwo.setGravityScope(480);
		
		starThree.setLocation(765,527);
		starThree.setSize(288);
		starThree.setGravityScope(480);
		
		starList.add(starOne);
		starList.add(starTwo);
		starList.add(starThree);
		
	}
	
}
//>>>>>>> origin/master
