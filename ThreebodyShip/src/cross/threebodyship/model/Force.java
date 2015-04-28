package cross.threebodyship.model;

public class Force {
	public double f;
	public double theta;
	
	public Force joinForce(Force f2){
		double fx = f*Math.cos(theta)+f2.f*Math.cos(f2.theta);
		double fy = f*Math.sin(theta)+f2.f*Math.sin(f2.theta);
		
		double thetaNew = Math.atan(fy/fx);
		
		if(fx<0) thetaNew+=Math.PI;
		else{
			if((fx>0)&&(fy<0)) thetaNew+=Math.PI*2;
		}
		
		Force fNew = new Force();
		
		fNew.f = Math.sqrt(fx*fx+fy*fy);
		fNew.theta = thetaNew;
		
		return fNew;
	}
}
