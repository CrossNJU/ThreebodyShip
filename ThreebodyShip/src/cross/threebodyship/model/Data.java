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
		
		//初始化飞船
		ship.setMass(1000);
		ship.setSize(60);
		ship.setSpeed(4);
		ship.setState(true);
		ship.outOfBorder = false;
		
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
		case 19:setGame19();break;
		case 20:setGame20();break;
		case 21:setGame21();break;
		}
	}
	
	public void setGame1(){
		Star star = new Star();
		
		//初始化星球
		star.setLocation(512, 518);
		star.setSize(366);
		star.setGravityScope(710);
		
		starList.add(star);
	}
	
	public void setGame2(){
		Star starOne = new Star();
		Star starTwo = new Star();

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
	
		//初始化星球
		
		starOne.style = "IAF";
		starOne.SpeedChangeRate = 0.7;
		starOne.setLocation(320,210);
		starOne.setSize(300);
		starOne.setGravityScope(640);
		
		starTwo.style = "IAF";
		starTwo.SpeedChangeRate = 0.7;
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
	
		//初始化星球
		
		starOne.style = "BlackHole";
		starOne.FaddRate = 1.05;
		starOne.setLocation(513,567);
		starOne.setSize(306);
		starOne.setGravityScope(756);
		starOne.deadR = 32;
	
		
		starList.add(starOne);
	}

	public void setGame8(){

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

		//初始化星球
		starOne.style = "IAF";
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

		//初始化星球
		starOne.setLocation(339, 401);
		starOne.setSize(228);
		starOne.setGravityScope(526);
		
		starTwo.style = "IAF";
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
		
		//初始化星球
		starOne.setLocation(253, 216);
		starOne.setSize(150);
		starOne.setGravityScope(348);
		
		starTwo.setLocation(651, 461);
		starTwo.setSize(290);
		starTwo.setGravityScope(600);
		starTwo.leftTime = 4;
		starTwo.style = "Super";
		starTwo.canBeRound = false;
		
		starList.add(starOne);
		starList.add(starTwo);
		
	}

	public void setGame14(){
		SuperStar starOne = new SuperStar();
		IAFStar starTwo = new IAFStar();
		BlackHole starThree = new BlackHole();
		
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
		starTwo.canBeRound = false;
		
		starThree.style = "BlackHole";
		starThree.deadR = 29;
		starThree.FaddRate = 1.1;
		starThree.setLocation(769, 564);
		starThree.setSize(214);
		starThree.setGravityScope(402);
		starThree.canBeRound = false;
		starList.add(starOne);
		starList.add(starTwo);
		starList.add(starThree);
		
	}
	
	public void setGame15(){
		BlackHole blackhole = new BlackHole();
		SuperStar superOne = new SuperStar();
		SuperStar superTwo = new SuperStar();
		Star star = new Star();
	
		//初始化星球
		blackhole.deadR = 101;
		blackhole.FaddRate = 1.1;
		blackhole.style = "BlackHole";
		blackhole.setLocation(220, 808);
		blackhole.setSize(410);
		blackhole.setGravityScope(642);
		
		superOne.setLocation(709, 180);
		superOne.style = "Super";
		superOne.leftTime = 7;
		superOne.setSize(180);
		superOne.setGravityScope(366);
		superOne.canBeRound = true;
		
		superTwo.setLocation(517, 384);
		superTwo.style = "Super";
		superTwo.leftTime = 5;
		superTwo.setSize(184);
		superTwo.setGravityScope(394);
		superTwo.canBeRound = false;
		
		star.setLocation(801, 430);
		star.setSize(142);
		star.setGravityScope(342);
		star.canBeRound = false;
		
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
		
		//初始化星球
		
		superStar.setLocation(204, 180);
		superStar.setSize(200);
		superStar.setGravityScope(408);
		superStar.leftTime = 5;
		superStar.style = "Super";
		superStar.canBeRound = false;
		
		rock.location.x = 233;
		rock.location.y = 536;
		rock.size = 106;
		
		starOne.setLocation(648, 385);
		starOne.setSize(260);
		starOne.setGravityScope(590);
		starOne.canBeRound = false;
		
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
		ship.setSize(50);
	
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
		fire.canBeRound = false;
		
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
	
	public void setGame18(){
		Rock rockOne = new Rock();
		Rock rockTwo = new Rock();
		Rock rockThree = new Rock();
		Rock rockFour = new Rock();
		Star starOne = new Star();
		Star starTwo = new Star();
		Star starThree = new Star();
		Planet planet = new Planet();
		
		//初始化飞船
		ship.setSize(50);

		//初始化星球
		starOne.setLocation(512, 174);
		starOne.setSize(174);
		starOne.setGravityScope(386);
		
		starTwo.setLocation(257, 560);
		starTwo.setSize(170);
		starTwo.setGravityScope(390);
		
		starThree.setLocation(777, 560);
		starThree.setSize(184);
		starThree.setGravityScope(406);
		
		planet.location.x = 420;
		planet.location.y = 269;
		planet.roundR = 132;
		planet.roundStar = starOne;
		planet.size = 66;
		planet.speed = 20;
		
		rockOne.location.x = 225;
		rockOne.location.y = 174;
		rockOne.size = 72;
		
		rockTwo.location.x = 819;
		rockTwo.location.y = 174;
		rockTwo.size = 72;
		
		rockThree.location.x = 512;
		rockThree.location.y = 420;
		rockThree.size = 72;
		
		rockFour.location.x = 512;
		rockFour.location.y = 614;
		rockFour.size = 72;
		
		starList.add(starThree);
		starList.add(starOne);
		starList.add(starTwo);
		planets.add(planet);
		rocks.add(rockThree);
		rocks.add(rockOne);
		rocks.add(rockTwo);
		rocks.add(rockFour);
	}
	
	public void setGame19(){
		BlackHole blackhole = new BlackHole();
		SpecialStarOne starOne = new SpecialStarOne();
		SpecialStarOne starTwo = new SpecialStarOne();
		IAFStar ice = new IAFStar();
		
		ship.setSize(40);
		//初始化星球
		blackhole.style = "BlackHole";
		blackhole.setLocation(189, 658);
		blackhole.setSize(232);
		blackhole.deadR = 51;
		blackhole.FaddRate = 1.1;
		blackhole.setGravityScope(408);
		
		starOne.setLocation(343, 278);
		starOne.setSize(162);
		starOne.setGravityScope(268);
		
		starTwo.setLocation(565, 521);
		starTwo.setSize(152);
		starTwo.setGravityScope(268);
		
		ice.style = "IAF";
		ice.SpeedChangeRate = 0.5;
		ice.setLocation(843, 435);
		ice.setGravityScope(268);
		ice.setSize(134);
		
		starList.add(ice);
		starList.add(starOne);
		starList.add(blackhole);
		starList.add(starTwo);
		
	}
	
	public void setGame20(){
		Star starOne = new Star();
		IAFStar ice = new IAFStar();
		
		IAFStar specialICE = new IAFStar();
		IAFStar specialFIRE = new IAFStar();
		SpecialTwo specialcenter = new SpecialTwo();
		Star specialNor = new Star();
		Planet planetOne = new Planet();
		Planet planetTwo = new Planet();
		Planet planetThree = new Planet();
		
		Rock rockOne = new Rock();
		Rock rockTwo = new Rock();
		
		ship.setSize(40);
		
		//初始化星球
		starOne.setLocation(231, 266);
		starOne.setSize(162);
		starOne.setGravityScope(296);
		
		ice.style = "IAF";
		ice.SpeedChangeRate = 0.7;
		ice.setLocation(790, 520);
		ice.setSize(136);
		ice.setGravityScope(242);
		ice.canBeRound = false;
		
		specialICE.style = "IAF";
		specialICE.setLocation(512, 384);
		specialICE.setSize(218);
		specialICE.setGravityScope(350);
		specialICE.SpeedChangeRate = 0.7;
		specialICE.isExisted = false;
		
		specialFIRE.style = "IAF";
		specialFIRE.setLocation(512, 384);
		specialFIRE.setSize(218);
		specialFIRE.setGravityScope(350);
		specialFIRE.SpeedChangeRate = 1.3;
		specialFIRE.isExisted = false;
		
		specialcenter.setLocation(512, 384);
		specialcenter.setSize(218);
		specialcenter.setGravityScope(350);
		
		specialNor.setLocation(512, 384);
		specialNor.setSize(218);
		specialNor.setGravityScope(350);
		specialNor.isExisted = false;
		
		//planets
		planetOne.Theta = 0;
		planetOne.roundR = 138;
		planetOne.roundStar = specialNor;
		planetOne.size = 38;
		planetOne.speed = 20;
		planetOne.isExisted = false;
		
		planetTwo.Theta = (Math.PI*2)/3;
		planetTwo.roundR = 138;
		planetTwo.roundStar = specialNor;
		planetTwo.size = 38;
		planetTwo.speed = 20;
		planetTwo.isExisted = false;
		
		planetThree.Theta = (Math.PI*4)/3;
		planetThree.roundR = 138;
		planetThree.roundStar = specialNor;
		planetThree.size = 38;
		planetThree.speed = 20;
		planetThree.isExisted = false;
		
		specialcenter.connectedStars.add(specialNor);
		specialcenter.connectedStars.add(specialFIRE);
		specialcenter.connectedStars.add(specialICE);
		specialcenter.conectedPlanets.add(planetOne);
		specialcenter.conectedPlanets.add(planetTwo);
		specialcenter.conectedPlanets.add(planetThree);
		
		rockOne.location.x = 99;
		rockOne.location.y = 384;
		rockOne.size = 48;
		rockTwo.location.x = 907;
		rockTwo.location.y = 384;
		rockTwo.size = 48;
		
		starList.add(specialcenter);
		starList.add(specialNor);
		starList.add(specialFIRE);
		starList.add(specialICE);
		starList.add(ice);
		starList.add(starOne);
		
		planets.add(planetThree);
		planets.add(planetTwo);
		planets.add(planetOne);
		
		rocks.add(rockOne);
		rocks.add(rockTwo);
		
		
	}
	
	public void setGame21(){
		Star starOne = new Star();
		Star starTwo = new Star();
		SpecialThree special = new SpecialThree();
		Planet planetOne = new Planet();
		Planet planetTwo = new Planet();
		
		starOne.setLocation(273, 312);
		starOne.setSize(172);
		starOne.setGravityScope(328);
		starOne.canBeRound = false;
		
		starTwo.setLocation(512, 560);
		starTwo.setGravityScope(330);
		starTwo.setSize(140);
		
		special.setGravityScope(302);
		special.setSize(146);
		special.lefttime = 5;
		special.style = "special3";
		special.place.x = 678;
		special.place.y = 114;
		special.height = 539;
		special.width = 261;
		special.isExisted = false;
		special.canBeRound = false;
		
		planetOne.Theta = 0;
		planetOne.size = 58;
		planetOne.roundR = 119;
		planetOne.roundStar = starTwo;
		planetOne.speed = 20;
		
		planetTwo.Theta = Math.PI;
		planetTwo.size = 58;
		planetTwo.roundR = 119;
		planetTwo.roundStar = starTwo;
		planetTwo.speed = 20;
		
		starList.add(special);
		starList.add(starOne);
		starList.add(starTwo);
		
		planets.add(planetTwo);
		planets.add(planetOne);
	}//Game21 special remain unsettled
}
//>>>>>>> origin/master



