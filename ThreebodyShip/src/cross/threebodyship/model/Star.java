package cross.threebodyship.model;

import java.awt.Color;

public class Star {
	public static double G = 0.0000006672;
	private double mass;
	private int size;
	private Point centerPoint;
	private int gravityScope;
	
	public boolean isExisted = true;
	public boolean canBeRound = true;
	
	public String style = "Normal";
	
	public Color color;
	
	public Star(){
		centerPoint = new Point();
		color = Color.YELLOW;
//		this.mass = Math.PI*4/3*size*size*size;
	}
	
	public double getMass(){
		return this.mass;
	}
	
//	public void setMass(double mass){
//		this.mass = mass;
//	}
	
	public int getSize(){
		return this.size;
	}
	
	public void setSize(int size){
		this.size = size;
		this.mass = 10*Math.PI*4/3*size*size*size;
	}
	
	public Point getLocation(){
		return this.centerPoint;
	}
	
	public void setLocation(double x,double y){
		this.centerPoint.setPoint(x, y);
	}
	
	public void setGravityScope(int scope){
		this.gravityScope = scope;
	}
	
	public int getGravityScope(){
		return this.gravityScope;
	}
}
