package cross.threebodyship.model;

public class Ship {
	//中心点
	private Point centerPoint;
	//直径
	private int size;
	
	//基本属性
	private double speed;
	private double degreeToEast;
	public double degreeToWest;
	private double mass;
	
	public double distanceToNowStar;
	
	//出界或不存在（superstar）的判定
	private boolean isAlive = false;
	public boolean outOfBorder = false;
	
	//环绕参数
	public boolean isRound = false;
	public double roundDirection = 1;
	public double roundDegree;
	public double roundDistance;
	public double roundDtheta;
	public Star roundStar = null;
	
	//技能锁
	public int skill1 = 0;
	public boolean skill2 = false;
	
	public Ship(){
		centerPoint = new Point();
//		setLocation(-2*getSize(), -2*getSize());
//		roundStar = new S
//		this.mass = 10*Math.PI*4/3*size*size*size;
	}
	
	public Point getLocation(){
		return this.centerPoint;
	}
	
	public void setLocation(double x,double y){
		this.centerPoint.setPoint(x, y);
	}
	
	public int getSize(){
		return this.size;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public double getSpeed(){
		return this.speed;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void changeSpeed(double rate){
		this.speed *= rate;
	}
	
	public double getDegreeToEast(){
		return this.degreeToEast;
	}
	
	public void setDegreeToEast(double degree){
		this.degreeToEast = degree;
	}
//	
//	public double getDegreeToStar(){
//		return this.degreeToStar;
//	}
//	
//	public void setDegreeToStar(double degree){
//		this.degreeToStar = degree;
//	}
	
	public double getMass(){
		return this.mass;
	}
	
	public void setMass(double mass){
		this.mass = mass;
	}
	
	public boolean getState(){
		return this.isAlive;
	}
	
	public void setState(boolean state){
		this.isAlive = state;
	}
}
