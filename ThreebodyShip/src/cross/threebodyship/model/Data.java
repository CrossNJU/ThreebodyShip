//<<<<<<< HEAD

package cross.threebodyship.model;

import java.util.ArrayList;

public class Data {
//	private static final String IAFStar = null;
	public ArrayList<Star> starList;
	public Ship ship;
	public ArrayList<Planet> planets;
	
	public Data(int gameNumber){
		starList = new ArrayList<Star>();
		planets = new ArrayList<Planet>();
		ship = new Ship();
		
		switch(gameNumber){
		case 1:setGame1();break;
		case 2:setGame2();break;
		case 3:setGame3();break;
		case 4:setGame4();break;
		case 5:setGame5();break;
		case 6:setGame6();break;
		case 7:setGame7();break;
		case 8:setGame8();break;
		case 9:setGame9();break;
		case 10:setGame10();break;
		case 11:setGame11();break;
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
	public void setGame4(){
		IAFStar starOne = new IAFStar();
		IAFStar starTwo = new IAFStar();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		
		starOne.style = "IAF";
		starOne.SpeedChangeRate = 1.5;
		starOne.setLocation(240,515);
		starOne.setSize(212);
		starOne.setGravityScope(454);
		
		starTwo.style = "IAF";
		starTwo.SpeedChangeRate = 1.5;
		starTwo.setLocation(679,337);
		starTwo.setSize(326);
		starTwo.setGravityScope(628);
		
		starList.add(starOne);
		starList.add(starTwo);
	}
	

	
	public void setGame5(){
		IAFStar starOne = new IAFStar();
		IAFStar starTwo = new IAFStar();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		
		starOne.style = "IAF";
		starOne.SpeedChangeRate = 0.8;
		starOne.setLocation(320,210);
		starOne.setSize(300);
		starOne.setGravityScope(640);
		
		starTwo.style = "IAF";
		starTwo.SpeedChangeRate = 0.8;
		starTwo.setLocation(709,546);
		starTwo.setSize(300);
		starTwo.setGravityScope(640);
		
		starList.add(starOne);
		starList.add(starTwo);
	}
		
	public void setGame6(){
		IAFStar starOne = new IAFStar();
		IAFStar starTwo = new IAFStar();
		Star starThree = new Star();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		
		starOne.style = "IAF";
		starOne.SpeedChangeRate = 0.5;
		starOne.setLocation(324,165);
		starOne.setSize(132);
		starOne.setGravityScope(282);
		
		starTwo.style = "IAF";
		starTwo.SpeedChangeRate = 1.5;
		starTwo.setLocation(688,390);
		starTwo.setSize(246);
		starTwo.setGravityScope(592);
		
		starThree.setLocation(207,500);
		starThree.setSize(234);
		starThree.setGravityScope(414);
		
		starList.add(starOne);
		starList.add(starTwo);
		starList.add(starThree);
	}
	
	public void setGame7(){
		BlackHole starOne = new BlackHole();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		
		starOne.style = "BlackHole";
		starOne.FaddRate = 1.1;
		starOne.setLocation(513,567);
		starOne.setSize(306);
		starOne.setGravityScope(756);
		starOne.deadR = 32;
	
		
		starList.add(starOne);
	}

	public void setGame8(){
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球				
		BlackHole starOne = new BlackHole();
		Star starTwo = new Star();
		
		starOne.style = "BlackHole";
		starOne.FaddRate = 1.1;
		starOne.setLocation(363, 104);
		starOne.setSize(284);
		starOne.setGravityScope(688);
		starOne.deadR = 37;
		
		starTwo.setLocation(736, 609);
		starTwo.setSize(204);
		starTwo.setGravityScope(502);
		
		starList.add(starOne);
		starList.add(starTwo);
	}
	
	public void setGame9(){
		IAFStar starOne = new IAFStar();
		IAFStar starTwo = new IAFStar();
		BlackHole starThree = new BlackHole();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		starOne.style = "IAF";
		starOne.SpeedChangeRate = 0.7;
		starOne.setLocation(414, 226);
		starOne.setSize(182);
		starOne.setGravityScope(426);
		
		starTwo.style = "IAF";
		starTwo.SpeedChangeRate = 1.5;
		starTwo.setLocation(734, 408);
		starTwo.setSize(186);
		starTwo.setGravityScope(470);
		
		starThree.style = "BlackHole";
		starThree.FaddRate = 1.1;
		starThree.setLocation(305, 676);
		starThree.setSize(322);
		starThree.setGravityScope(622);
		starThree.deadR = 52;
		
		starList.add(starOne);
		starList.add(starTwo);
		starList.add(starThree);
	}
	public void setGame10(){
		Star starOne = new Star();
		Planet starTwo = new Planet();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(10);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		starOne.setLocation(513, 590);
		starOne.setSize(316);
		starOne.setGravityScope(726);
		
		starTwo.location.x = 513;
		starTwo.location.y = 311;
		starTwo.roundR = 281;
		starTwo.roundStar = starOne;
		starTwo.size = 128;
		starTwo.speed = 5;
		
		
		starList.add(starOne);
		planets.add(starTwo);
	}
	
	public void setGame11(){}
	
}
//>>>>>>> origin/master
