package cross.threebodyship.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;

import cross.threebodyship.userinterface.StopUI;


public class Game extends Observable implements Runnable{
	public static double maxDistance = 10000;
	
	private boolean isRunning = false;
	public boolean isStarting = false;
	public boolean inGame = false;
	
	private long refreshInterval = 100;
	
	public Ship ship;
//	public Star star;
	public ArrayList<Star> starList;
	public Data data;
	
	public double speedChangeRate = 1.1;
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
		ship = new Ship();
		
		border.x = 1024;
		border.y = 768;
		startingPoint.x = -640;
		startingPoint.y = border.y/2;
		winPoint.x = 1670;
		winPoint.y = border.y/2;
		winAreaR = 690;
		StartingAreaR = 690;
		
//		reset();
	}
	
	//飞行轨迹计算
	public void update(){
		//正常情况下飞船轨迹
		double nowX = ship.getLocation().x;
		double nowY = ship.getLocation().y;
		double vx = ship.getSpeed()*Math.cos(ship.getDegreeToEast());
		double vy = ship.getSpeed()*Math.sin(ship.getDegreeToEast());
		double t = this.refreshInterval/100;
		
		//引力加大参数
//		FchangeRate = ship.getSpeed();
		
		//判定是否进入某一星球引力区
		boolean isInScope = false;
//		count = 0;
		//初始化万有引力
		Force f = new Force();
		f.f = 0;
//		Star starI = new IAFStar();
//		System.out.println(starList.size());
		//考虑多星球
		for(int i=0; i<starList.size(); i++){
		
			double distance = Math.sqrt((ship.getLocation().x-starList.get(i).getLocation().x)*
				(ship.getLocation().x-starList.get(i).getLocation().x)+
				(ship.getLocation().y-starList.get(i).getLocation().y)*
				(ship.getLocation().y-starList.get(i).getLocation().y)
				);

			if(distance<starList.get(i).getSize()/2){
				if(starList.get(i).style.equals("BlackHole")){
					//修改distance
					distance = maxDistance;
					
					BlackHole blackHole = (BlackHole)starList.get(i);
					
					//修改vx，vy
					double alpher = Math.atan((ship.getLocation().y-blackHole.getLocation().y)
							/(ship.getLocation().x-blackHole.getLocation().x));
					if(ship.getLocation().x>blackHole.getLocation().x) alpher+=Math.PI;
					if((ship.getLocation().x<blackHole.getLocation().x)
							&&(ship.getLocation().y>blackHole.getLocation().y)) alpher+=Math.PI*2;
					
					vx = ship.getSpeed()*Math.cos(alpher);
					vy = ship.getSpeed()*Math.sin(alpher);
					
				}else
				ship.setState(false);
			}
			
			if(distance<starList.get(i).getGravityScope()/2) {
				isInScope = true;
				if(starList.get(i).style.equals("BlackHole")){
					BlackHole blackHole = (BlackHole)starList.get(i);
					FchangeRate *= blackHole.FaddRate;
				}
				
				if(starList.get(i).style.equals("IAF")){
					IAFStar star = (IAFStar)starList.get(i);
					if(star.changed == false){
						vx*=star.SpeedChangeRate;
						vy*=star.SpeedChangeRate;
						star.changed = true;
					}
				}
			
				//计算星球飞船连线与正西方向顺时针的夹角
				double theta1 = Math.atan((double)(starList.get(i).getLocation().y-
						ship.getLocation().y)/(starList.get(i).getLocation().x-
						ship.getLocation().x));
				if((ship.getLocation().x<starList.get(i).getLocation().x)&&
						ship.getLocation().y>starList.get(i).getLocation().y) theta1 += 2*Math.PI;
				else{
					if(ship.getLocation().x>starList.get(i).getLocation().x)
						theta1 += Math.PI;
				}

				double a = FchangeRate*Star.G*starList.get(i).getMass()/
						(starList.get(i).getSize()*starList.get(i).getSize()/4);
			
				//合成力
				Force f2 = new Force();
				f2.f = a;
				f2.theta = theta1;
			
				f = f.joinForce(f2);
			}
//			System.out.println(f.f+" "+f.theta);
		}
		
		//如果进入引力区
		if((isInScope)&&(!ship.isRound)){
//			System.out.println(1);
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
//			System.out.println(1);
			
			//修改theta2
			if(ship.getDegreeToEast()<Math.PI/2){
				if(theta2<0) theta2+=Math.PI*2;
				ship.setDegreeToEast(theta2);
			}
			else if(ship.getDegreeToEast()<Math.PI){
				if(vx<0) theta2+=Math.PI;
				ship.setDegreeToEast(theta2);
			}
			else if(ship.getDegreeToEast()<Math.PI*3/2){
				if(vx>0) theta2+=Math.PI*2;
				else theta2+=Math.PI;
				ship.setDegreeToEast(theta2);
			}
			else {
				if(theta2>0){
					if(vx<0) theta2+=Math.PI; 
				}
				else theta2+=Math.PI*2;
				ship.setDegreeToEast(theta2);
			}
			
		}else{
			if(!ship.isRound){
				nowX += vx*t;
				nowY += vy*t;
			}
			else{
//				double dTheta = ship.getSpeed()*t/distance;
//				System.out.println(Math.toDegrees(dTheta));
////				if(count == 0) {
////					dTheta += theta1-ship.getDegreeToEast();
////					count ++;
////				}else count ++;
//				ship.setDegreeToEast(f.theta+Math.PI*3/2);
//				
//				nowX = star.getLocation().x + distance*Math.cos(theta1+Math.PI+dTheta);
//				nowY = star.getLocation().y + distance*Math.sin(theta1+Math.PI+dTheta);
			}
		}

//		System.out.println("oldtheta:"+Math.toDegrees(ship.getDegreeToEast()));
		
		ship.setLocation(nowX, nowY);
		//System.out.println(ship.getLocation().x);
		
	}
	
	//重置参数
	public void reset(){
		this.isRunning = true;
		this.isStarting = true;
		this.inGame = false;
		
		//初始化
		data = new Data(gameNumber);
		
		ship = data.ship;
		starList = data.starList;
		
//		this.FchangeRate = ship.getSpeed();
	}
	
	//结束判定
	public boolean checkFail(){
		//判断是否出界
		//JFrame result = new JFrame();
		//JLabel state = new JLabel();
		Boolean isFailed = false;
		
		if((ship.getLocation().x<0)||
				(ship.getLocation().x+ship.getSize()>border.x)||
				(ship.getLocation().y<0)||
				(ship.getLocation().y+ship.getSize()>border.y)
				) ship.outOfBorder = true;
		
		if(ship.outOfBorder){
			isFailed = true;
			//gameEnd = true;
		}	
//		
//		if(distance<star.getSize()/2){
//			ship.setState(false);
//			System.out.println("you lose!");
//			isFailed = true;
//			//state.setText("you lose!");
//			//gameEnd = true;
//		}
		
		return isFailed;
		
	}
	
	//获胜判定
	public boolean checkWin(){
		
		double dis = Math.sqrt((ship.getLocation().x-winPoint.x)*(ship.getLocation().x-winPoint.x)
				+(ship.getLocation().y-winPoint.y)*(ship.getLocation().y-winPoint.y));
		System.out.println("dis:"+dis);
		if(dis<winAreaR) return true;
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
				this.setChanged();
				this.notifyObservers();
			}
			
		}
		
		this.setState(false);
	}

}
