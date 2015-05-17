//<<<<<<< HEAD

package cross.threebodyship.model;

import java.util.ArrayList;

public class Data {
//	private static final String IAFStar = null;
	public ArrayList<Star> starList;
	public Ship ship;
	public ArrayList<Planet> planets;
	public ArrayList<Rock> rocks;
	
	public Data(int gameNumber){
		starList = new ArrayList<Star>();
		planets = new ArrayList<Planet>();
		rocks = new ArrayList<Rock>();
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
	public void setGame15(){
		BlackHole blackhole = new BlackHole();
		SuperStar superOne = new SuperStar();
		SuperStar superTwo = new SuperStar();
		Star star = new Star();
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(60);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		blackhole.deadR = 101;
		blackhole.FaddRate = 1.1;
		blackhole.style = "BlackHole";
		blackhole.setLocation(220, 808);
		blackhole.setSize(410);
		blackhole.setGravityScope(642);
		
		superOne.setLocation(709, 180);
		superOne.style = "Super";
		superOne.leftTime = 5;
		superOne.setSize(180);
		superOne.setGravityScope(366);
		
		superTwo.setLocation(517, 384);
		superTwo.style = "Super";
		superTwo.leftTime = 5;
		superTwo.setSize(184);
		superTwo.setGravityScope(394);
		
		star.setLocation(801, 430);
		star.setSize(142);
		star.setGravityScope(342);
		
		starList.add(superOne);
		starList.add(superTwo);
		starList.add(blackhole);
		starList.add(star);
		
		
	}
	public void setGame16(){
		Star starOne = new Star();
		SuperStar superStar = new SuperStar();
		Rock rock = new Rock();
		Planet planetOne = new Planet();
		Planet planetTwo = new Planet();
		
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(60);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		
		superStar.setLocation(204, 180);
		superStar.setSize(200);
		superStar.setGravityScope(408);
		superStar.leftTime = 5;
		superStar.style = "Super";
		
		rock.location.x = 233;
		rock.location.y = 536;
		rock.size = 106;
		
		starOne.setLocation(648, 385);
		starOne.setSize(260);
		starOne.setGravityScope(590);
		
		planetOne.location.x = 782;
		planetOne.location.y = 212;
		planetOne.size = 88;
		planetOne.roundR = 219;
		planetOne.roundStar = starOne;
		planetOne.speed = 20;
		
		planetTwo.location.x = 519;
		planetTwo.location.y = 562;
		planetTwo.size = 88;
		planetTwo.roundR = 219;
		planetTwo.roundStar = starOne;
		planetTwo.speed = 20;
		
		starList.add(superStar);
		starList.add(starOne);
		
		planets.add(planetOne);
		planets.add(planetTwo);
		rocks.add(rock);
		
	}
	public void setGame17(){
		Star starOne = new Star();
		IAFStar ice = new IAFStar();
		IAFStar fire = new IAFStar();
		Planet planet = new Planet();
		Rock rockOne = new Rock();
		Rock rockTwo = new Rock();	
		Rock rockThree = new Rock();	
		Rock rockFour = new Rock();
		
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(50);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		//初始化星球
		starOne.setSize(184);
		starOne.setLocation(290, 472);
		starOne.setGravityScope(364);
		
		ice.style = "IAF";
		ice.SpeedChangeRate = 0.7;
		ice.setLocation(496, 187);
		ice.setSize(194);
		ice.setGravityScope(384);
		
		fire.style = "IAF";
		fire.SpeedChangeRate = 1.4;
		fire.setLocation(754, 534);
		fire.setSize(164);
		fire.setGravityScope(356);
		
		planet.location.x = 862;
		planet.location.y = 470;
		planet.roundR = 125;
		planet.roundStar = fire;
		planet.size = 70;
		planet.speed = 20;
		
		rockOne.location.x = 760;
		rockOne.location.y = 179;
		rockOne.size = 76;
		
		rockTwo.location.x = 541;
		rockTwo.location.y = 422;
		rockTwo.size = 76;
		
		rockThree.location.x = 522;
		rockThree.location.y = 675;
		rockThree.size = 76;
		
		rockFour.location.x = 62;
		rockFour.location.y = 498;
		rockFour.size = 40;
		
		starList.add(fire);
		starList.add(ice);
		starList.add(starOne);
		
		planets.add(planet);
		
		rocks.add(rockThree);
		rocks.add(rockOne);
		rocks.add(rockTwo);
		rocks.add(rockFour);
	}
	
	public void setGame18(){}
	
}
//>>>>>>> origin/master



