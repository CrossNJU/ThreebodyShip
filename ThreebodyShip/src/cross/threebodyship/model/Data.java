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
		case 12:setGame12();break;
		case 13:setGame13();break;
		case 14:setGame14();break;
		case 15:setGame15();break;
		case 16:setGame16();break;
		case 17:setGame17();break;
		case 18:setGame18();break;
		}
	}
	
	public void setGame1(){
		Star star = new Star();
		
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(60);
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
		ship.setSize(60);
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
		ship.setSize(60);
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
		ship.setSize(60);
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
		ship.setSize(60);
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
		ship.setSize(60);
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
		ship.setSize(60);
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
		ship.setSize(60);
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
		ship.setSize(60);
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
		ship.setSize(60);
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
		starTwo.speed = 20;
		
		
		starList.add(starOne);
		planets.add(starTwo);
	}
	
	public void setGame11(){
		IAFStar starOne = new IAFStar();
		Star starTwo = new Star();
		Planet starThree = new Planet();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(60);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		starOne.style = "IAFStar";
		starOne.SpeedChangeRate = 0.7;
		starOne.setLocation(233, 512);
		starOne.setSize(154);
		starOne.setGravityScope(364);
		
		starTwo.setLocation(634, 255);
		starTwo.setSize(252);
		starTwo.setGravityScope(586);
		
		starThree.location.x = 808;
		starThree.location.y = 384;
		starThree.roundR = 216;
		starThree.roundStar = starTwo;
		starThree.size = 44;
		starThree.speed = 20;
		
		
		starList.add(starOne);
		starList.add(starTwo);
		planets.add(starThree);
	}
	
	public void setGame12(){
		Star starOne = new Star();
		IAFStar starTwo = new IAFStar();
		BlackHole starThree = new BlackHole();
		Planet starFour = new Planet();
		Planet starFive = new Planet();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(60);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		starOne.setLocation(339, 401);
		starOne.setSize(228);
		starOne.setGravityScope(526);
		
		starTwo.style = "IAFStar";
		starTwo.SpeedChangeRate = 0.5;
		starTwo.setLocation(768, 368);
		starTwo.setSize(140);
		starTwo.setGravityScope(328);
		
		
		starThree.deadR = 25;
		starThree.FaddRate = 1.1;
		starThree.style = "BlackHole";
		starThree.setLocation(697, 738);
		starThree.setSize(192);
		starThree.setGravityScope(426);
		
//		starFour.location.x = 459;
//		starFour.location.y = 254;
		starFour.Theta = Math.toRadians(45);
		starFour.roundR = 192;
		starFour.roundStar = starOne;
		starFour.size = 60;
		starFour.speed = 5;
		
//		starFive.location.x = 222;
//		starFive.location.y = 551;
		starFive.Theta = Math.toRadians(225);
		starFive.roundR = 192;
		starFive.roundStar = starOne;
		starFive.size = 60;
		starFive.speed = 5;
		
		starList.add(starOne);
		starList.add(starTwo);
		starList.add(starThree);
		
		planets.add(starFour);
		planets.add(starFive);
	}
	public void setGame13(){
		Star starOne = new Star();
		SuperStar starTwo = new SuperStar();
		
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(60);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		starOne.setLocation(253, 216);
		starOne.setSize(150);
		starOne.setGravityScope(348);
		
		starTwo.setLocation(651, 461);
		starTwo.setSize(290);
		starTwo.setGravityScope(600);
		starTwo.leftTime = 5;
		starTwo.style = "Super";
		
		starList.add(starOne);
		starList.add(starTwo);
		
	}
	public void setGame14(){
		SuperStar starOne = new SuperStar();
		IAFStar starTwo = new IAFStar();
		BlackHole starThree = new BlackHole();
		
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(60);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		
		starOne.style = "Super";
		starOne.leftTime = 5;
		starOne.setLocation(369, 384);
		starOne.setSize(204);
		starOne.setGravityScope(478);
		
		starTwo.style = "IAF";
		starTwo.SpeedChangeRate = 0.5;
		starTwo.setLocation(656, 166);
		starTwo.setSize(134);
		starTwo.setGravityScope(294);
		
		starThree.style = "BlackHole";
		starThree.deadR = 29;
		starThree.FaddRate = 1.1;
		starThree.setLocation(769, 564);
		starThree.setSize(214);
		starThree.setGravityScope(402);
		
		starList.add(starOne);
		starList.add(starTwo);
		starList.add(starThree);
		
	}
	public void setGame15(){}
	public void setGame16(){}
	public void setGame17(){}
	public void setGame18(){}
	
}
//>>>>>>> origin/master



