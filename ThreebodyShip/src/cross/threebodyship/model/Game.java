package cross.threebodyship.model;

import java.util.ArrayList;
import java.util.Observable;

public class Game extends Observable implements Runnable{
	public static double maxDistance = 10000;
	
	private boolean isRunning = false;
	public boolean isStarting = false;
	public boolean inGame = false;
	public boolean isFailed = false;
	public boolean isWin = false;
	public boolean isInScope = false;
	
	private long refreshInterval = 50;
	
	public Ship ship;
	public ArrayList<Star> starList;
	public ArrayList<Planet> planets;
	public Data data;
	public ArrayList<Rock> rockList;
	
	public double speedChangeRate = 1.15;
	public static double FchangeRate = 12;
	
	public Point border;
	public Point startingPoint;
	public Point winPoint;
	public Point mousePoint;
	
	public double StartingAreaR;
	public double winAreaR;
	public int rectwidth = 0;
	public int rectheight = 0;
	
	public int gameNumber = 0;
	
	public Game(){
		border = new Point();
		startingPoint = new Point();
		mousePoint = new Point();
		winPoint = new Point();
		starList = new ArrayList<Star>();
		planets = new ArrayList<Planet>();
		rockList = new ArrayList<Rock>();
		ship = new Ship();
		
		border.x = 1024;
		border.y = 768;
		startingPoint.x = -220;
		startingPoint.y = border.y/2;
		winPoint.x = 1244;
		winPoint.y = border.y/2;
		winAreaR = 262;
		StartingAreaR = 262;
		
//		reset();
	}
	
	//飞行轨迹计算
	public void update(){
//		
//		System.out.println("d to e:"+Math.toDegrees(ship.getDegreeToEast()));
//		System.out.println("d to w:"+Math.toDegrees(ship.degreeToWest));
//		System.out.println();
		isInScope = false;
		
		//正常情况下飞船轨迹
		double nowX = ship.getLocation().x;
		double nowY = ship.getLocation().y;
		double vx = ship.getSpeed()*Math.cos(ship.getDegreeToEast());
		double vy = ship.getSpeed()*Math.sin(ship.getDegreeToEast());
		double t = (double)this.refreshInterval/100;
		
		//初始化万有引力
		Force f = new Force();
		f.f = 0;
		
		//考虑多星球
		for(int i=0; i<starList.size(); i++){
			
			//设置当前考虑的星球
			Star nowStar;
			
			if(starList.get(i).style.equals("special3") && !starList.get(i).isExisted) {
				SpecialThree specialThree = (SpecialThree) starList.get(i);
				specialThree.lefttime -= (double)refreshInterval/1000;
				if (specialThree.lefttime <= 0) {
					specialThree.isExisted = true;
				}
			}
			
			if(starList.get(i).isExisted) nowStar = starList.get(i);
			else continue;
			
			//计算飞船与当前星球距离
			ship.distanceToNowStar = Math.sqrt((ship.getLocation().x-nowStar.getLocation().x)*
				(ship.getLocation().x-nowStar.getLocation().x)+
				(ship.getLocation().y-nowStar.getLocation().y)*
				(ship.getLocation().y-nowStar.getLocation().y)
				);
			
			//刷新超新星时间
			if(nowStar.style.equals("Super")){
				SuperStar superStar = (SuperStar)starList.get(i);
				if(superStar.leftTime>0) superStar.leftTime -= (double)refreshInterval/1000;
				else {
					superStar.isExisted = false;
					if(ship.distanceToNowStar<superStar.getGravityScope()/2){
						ship.setState(false);
						isFailed = true;
					}
				}
			}
			
			//判定是否撞上星球
			if(ship.distanceToNowStar-ship.getSize()/2<starList.get(i).getSize()/2){
				if(nowStar.style.equals("BlackHole")){
					BlackHole blackHole = (BlackHole)starList.get(i);
					
					if(ship.distanceToNowStar - ship.getSize()/2<blackHole.deadR) {
						ship.setState(false);
						isFailed = true;
					}
					else{
						//修改distance
					ship.distanceToNowStar = maxDistance;
					ship.setSpeed(2);
					
					//修改vx，vy
					double alpher = Math.atan((ship.getLocation().y-blackHole.getLocation().y)
							/(ship.getLocation().x-blackHole.getLocation().x));
					if(ship.getLocation().x>blackHole.getLocation().x) alpher+=Math.PI;
					if((ship.getLocation().x<blackHole.getLocation().x)
							&&(ship.getLocation().y>blackHole.getLocation().y)) alpher+=Math.PI*2;
					
					vx = ship.getSpeed()*Math.cos(alpher);
					vy = ship.getSpeed()*Math.sin(alpher);
					}
					
				}else{
				this.isFailed = true;
				ship.setState(false);
				}
			}
			
			//判定是否进入引力范围
			if(ship.distanceToNowStar<starList.get(i).getGravityScope()/2) {
				isInScope = true;
				
				if(starList.get(i).style.equals("BlackHole")){
					BlackHole blackHole = (BlackHole)starList.get(i);
					FchangeRate = FchangeRate*blackHole.FaddRate;
				}
				
				if(starList.get(i).style.equals("IAF")){
					IAFStar star = (IAFStar)starList.get(i);
					if(star.changed == false){
						vx*=star.SpeedChangeRate;
						vy*=star.SpeedChangeRate;
						star.changed = true;
					}
				}
//				if(starList.get(i).style.equals("Super")){
//					SuperStar superStar = (SuperStar)starList.get(i);
//					if(superStar.leftTime <= 0) {
//						ship.setState(false);
//						superStar
//					}
//				}
			
				//计算星球飞船连线与正西方向顺时针的夹角
				ship.degreeToWest = Math.atan((double)(starList.get(i).getLocation().y-
						ship.getLocation().y)/(starList.get(i).getLocation().x-
						ship.getLocation().x));
				if((ship.getLocation().x<starList.get(i).getLocation().x)&&
						ship.getLocation().y>starList.get(i).getLocation().y) ship.degreeToWest += 2*Math.PI;
				else{
					if(ship.getLocation().x>starList.get(i).getLocation().x)
						ship.degreeToWest += Math.PI;
				}

				//挑战1
				if(starList.get(i).style.equals("special1")){
					SpecialStarOne specialStarOne = (SpecialStarOne)starList.get(i);
					
					if(specialStarOne.enter == 0){
						if((ship.getLocation().y<specialStarOne.getLocation().y && 
								(ship.getDegreeToEast() - ship.degreeToWest > 0 && ship.getDegreeToEast() - ship.degreeToWest < Math.PI)) || 
						   (ship.getLocation().y>specialStarOne.getLocation().y && 
								(ship.degreeToWest - ship.getDegreeToEast() < 0 || ship.degreeToWest - ship.getDegreeToEast() > Math.PI)))
							ship.roundDirection = 1;
						else {
							ship.roundDirection = -1;
						}
						
						ship.degreeToWest += ship.roundDirection*Math.PI/2;
						if (ship.degreeToWest>Math.PI*2) {
							ship.degreeToWest -= Math.PI*2;
						}
						
						nowX = specialStarOne.getLocation().x + ship.distanceToNowStar*Math.cos(ship.degreeToWest);
						nowY = specialStarOne.getLocation().y + ship.distanceToNowStar*Math.sin(ship.degreeToWest);
					
						isInScope = false;
//						
//						if((ship.getLocation().y<specialStarOne.getLocation().y && 
//								(ship.getDegreeToEast() - ship.degreeToWest > 0 && ship.getDegreeToEast() - ship.degreeToWest < Math.PI)) || 
//						   (ship.getLocation().y>specialStarOne.getLocation().y && 
//								(ship.degreeToWest - ship.getDegreeToEast() < 0 || ship.degreeToWest - ship.getDegreeToEast() > Math.PI)))
//							ship.roundDirection = 1;
//						else {
//							ship.roundDirection = -1;
//						}
						if(ship.roundDirection==1){
						if(nowX - specialStarOne.getLocation().x<0 && nowY - specialStarOne.getLocation().y<0)
							ship.setDegreeToEast(ship.degreeToWest + Math.PI*3/2);
						else ship.setDegreeToEast(ship.degreeToWest - Math.PI/2);
						}else{
						if(nowX - specialStarOne.getLocation().x<0 && nowY - specialStarOne.getLocation().y>0)
							ship.setDegreeToEast(ship.degreeToWest - Math.PI*3/2);
						else ship.setDegreeToEast(ship.degreeToWest + Math.PI/2);
						}
						
						specialStarOne.enter = 1;
					}
				}
				
				//挑战2
				if(starList.get(i).style.equals("special2")){
					SpecialTwo specialTwo = (SpecialTwo) starList.get(i);
					if(specialTwo.enter == 0){
						int ran = (int)(Math.random()*3);
						specialTwo.connectedStars.get(ran).isExisted = true;
//						specialTwo.conectedPlanets.get(2).isExisted = true;
//						Thread t2 = new Thread(specialTwo.conectedPlanets.get(2));
//						t2.start();
						
						if(ran == 0){
							for (int j = 0; j < specialTwo.conectedPlanets.size(); j++) {
//								System.out.println("enter:"+j);
								specialTwo.conectedPlanets.get(j).isExisted = true;
								Thread t1 = new Thread(specialTwo.conectedPlanets.get(j));
								t1.start();
							}
						}
						
						specialTwo.isExisted = false;
						isInScope = false;
					}
				}
				
				//可环绕性
				if(!ship.isRound && nowStar.canBeRound){
					ship.roundStar = nowStar;
					
					if((ship.getLocation().y<ship.roundStar.getLocation().y && 
							(ship.getDegreeToEast() - ship.degreeToWest > 0 && ship.getDegreeToEast() - ship.degreeToWest < Math.PI)) || 
					   (ship.getLocation().y>ship.roundStar.getLocation().y && 
							(ship.degreeToWest - ship.getDegreeToEast() < 0 || ship.degreeToWest - ship.getDegreeToEast() > Math.PI)))
						ship.roundDirection = -1;
					else {
						ship.roundDirection = 1;
					}
					
					ship.roundDegree = ship.degreeToWest;
					ship.roundDistance = Math.sqrt((ship.getLocation().x-ship.roundStar.getLocation().x)*
							(ship.getLocation().x-ship.roundStar.getLocation().x)+
							(ship.getLocation().y-ship.roundStar.getLocation().y)*
							(ship.getLocation().y-ship.roundStar.getLocation().y)
							);
				}else 
				if(nowStar.canBeRound){
					if(ship.roundStar.equals(nowStar)) ship.roundDegree = ship.degreeToWest;
				}
				
				
				double a = FchangeRate*Star.G*starList.get(i).getMass()/
						(starList.get(i).getSize()*starList.get(i).getSize()/4);
			
				//合成力
				Force f2 = new Force();
				f2.f = a;
				f2.theta = ship.degreeToWest;
			
				f = f.joinForce(f2);
			}
		}
		
		//计算是否撞到行星
		for(int i =0;i< planets.size(); i++){
			if(!planets.get(i).isExisted) continue;
			double distance = Math.sqrt((ship.getLocation().x-planets.get(i).location.x)*
					(ship.getLocation().x-planets.get(i).location.x)+
					(ship.getLocation().y-planets.get(i).location.y)*
					(ship.getLocation().y-planets.get(i).location.y));
			
			if(distance-ship.getSize()/2<planets.get(i).size/2) {
				this.isFailed = true;
				ship.setState(false);
				break;
			}
		}
		
		//计算是否撞到陨石
		for (int i = 0; i < rockList.size(); i++) {
			double distance = Math.sqrt((ship.getLocation().x-rockList.get(i).location.x)*
					(ship.getLocation().x-rockList.get(i).location.x)+
					(ship.getLocation().y-rockList.get(i).location.y)*
					(ship.getLocation().y-rockList.get(i).location.y));
			if(distance - ship.getSize()/2<rockList.get(i).size/2){
				this.isFailed = true;
				ship.setState(false);
				break;
			}
		}
//		
//		System.out.println("ship is round:"+ship.isRound);
//		System.out.println("ship is in scope:"+isInScope);
		
		//如果进入引力区
		if((isInScope)&&(!ship.isRound)){
			//计算速度，加速度，位移
			double ax = f.f*Math.cos(f.theta);
			double ay = f.f*Math.sin(f.theta);
			vx += ax*t;
			vy += ay*t;
			double sx = vx*t + (ax*t*t)/2;
			double sy = vy*t + (ay*t*t)/2;
			
			nowX += sx;
			nowY += sy;
			
			double vNew = Math.sqrt(vx*vx+vy*vy);
			
			ship.setSpeed(vNew);
			
			double theta2 = Math.atan(vy/vx);
	
			//修改theta2
//			System.out.println(ship.getDegreeToEast());
			if(ship.getDegreeToEast()<=Math.PI/2){
//				System.out.println(1);
//				System.out.println("thetaold:"+Math.toDegrees(theta2));
				if(theta2<0) {
					if(vx<0) theta2 += Math.PI;
					else theta2+=Math.PI*2;
				}
				ship.setDegreeToEast(theta2);
			}
			else if(ship.getDegreeToEast()<Math.PI){
//				System.out.println(2);
				if(vx<0) theta2+=Math.PI;
				ship.setDegreeToEast(theta2);
			}
			else if(ship.getDegreeToEast()<Math.PI*3/2){
//				System.out.println(3);
				if(vx>0) theta2+=Math.PI*2;
				else theta2+=Math.PI;
				ship.setDegreeToEast(theta2);
			}
			else {
//				System.out.println(4);
				if(theta2>0){
					if(vx<0) theta2+=Math.PI; 
				}
				else theta2+=Math.PI*2;
//				System.out.println("thetaold:"+Math.toDegrees(ship.getDegreeToEast()));
				ship.setDegreeToEast(theta2);
			}
//			System.out.println("theta:"+Math.toDegrees(theta2));
			
		}else{
			if(!ship.isRound){
//				System.out.println(1);
				ship.roundStar = null;
				
				nowX += vx*t;
				nowY += vy*t;
			}
			else{
//				ship.setDegreeToEast(f.theta+Math.PI*3/2);
				
//				System.out.println("dtheat:"+ship.roundDtheta);
				
				nowX = ship.roundStar.getLocation().x + ship.roundDistance*
						Math.cos(ship.roundDegree+Math.PI+ship.roundDirection*ship.roundDtheta);
				nowY = ship.roundStar.getLocation().y + ship.roundDistance*
						Math.sin(ship.roundDegree+Math.PI+ship.roundDirection*ship.roundDtheta);
				
				if(ship.roundDirection == 1){
					if(nowX - ship.roundStar.getLocation().x<0 && nowY - ship.roundStar.getLocation().y<0)
						ship.setDegreeToEast(ship.roundDegree + Math.PI*3/2);
					else ship.setDegreeToEast(ship.roundDegree - Math.PI/2);
				}else {
					if(nowX - ship.roundStar.getLocation().x<0 && nowY - ship.roundStar.getLocation().y>0)
						ship.setDegreeToEast(ship.roundDegree - Math.PI*3/2);
					else ship.setDegreeToEast(ship.roundDegree + Math.PI/2);
				}
			}
		}
		
		ship.setLocation(nowX, nowY);
	}
	
	//重置参数
	public void reset(){
		this.isRunning = true;
		this.isStarting = true;
		this.inGame = false;
		this.isFailed = false;
		this.isWin = false;
		this.isInScope = false;
		
		//初始化
		data = new Data(gameNumber);
		
		ship = data.ship;
		ship.setLocation(-ship.getSize()*2, -ship.getSize()*2);
		starList = data.starList;
		planets = data.planets;
		
//		System.out.println("planets number:"+planets.size());
		rockList = data.rocks;
		
		//设置技能
		if (gameNumber >= 7) ship.skill1 = 1; else ship.skill1 = 0;
		if (gameNumber >= 13) ship.skill2 = true; else ship.skill2 = false;
		
		//启动planets线程
		for(int i = 0; i<planets.size(); i++){
			if(!planets.get(i).isExisted) continue;
//			System.out.println("enter:"+i);
			Thread t = new Thread(planets.get(i));
			t.start();
		}
		
		
		FchangeRate = 12;
		
	}
	
	//出界判定
	public void checkOutOfBorder(){
		
		if((ship.getLocation().x+ship.getSize()/2<0)||
				(ship.getLocation().x+ship.getSize()/2>border.x)||
				(ship.getLocation().y-ship.getSize()/2<0)||
				(ship.getLocation().y+ship.getSize()/2>border.y)
				) ship.outOfBorder = true;
		
		if(ship.outOfBorder){
			isFailed = true;
		}	
	}
	
	//获胜判定
	public boolean checkWin(){
		
		double dis = Math.sqrt((ship.getLocation().x-winPoint.x)*(ship.getLocation().x-winPoint.x)
				+(ship.getLocation().y-winPoint.y)*(ship.getLocation().y-winPoint.y));
		
		if(dis - ship.getSize()/2<winAreaR) return true;
		else return false;
	}
	
	public void setState(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	public boolean getState(){
		return this.isRunning;
	}
	
	public void setRI(long interval){
		this.refreshInterval = interval;
	}
	
	public long getRI(){
		return this.refreshInterval;
	}
	
	//主要过程
	@Override
	public void run() {
		reset();
		
		while(this.getState()){
			try{
				Thread.sleep(this.getRI());
			}catch(Exception e){}
			
			if(this.isStarting){
				this.setChanged();
				this.notifyObservers();
			}
			
			if((this.inGame)&&(ship.getState())){
				update();
				checkOutOfBorder();
				isWin = checkWin();
				this.setChanged();
				this.notifyObservers();
			}
//			if (!ship.getState()) {
//				System.out.println("isn't alive");
//			}
		}
		
		for (int i = 0; i < planets.size(); i++) {
			planets.get(i).stop = true;
		}
		
		this.setState(false);
	}

}
