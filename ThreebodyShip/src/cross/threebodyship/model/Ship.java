package cross.threebodyship.model;

public class Ship {
    boolean paused = false;
    double v;
    public double direction = 0.0;
    public double x;
    public double y;
    double timeInterval = 200.0;								//刷新时间，单位时间
    double speedUpRate = 1.5;
    double speedDownRate = 0.75;

    public Ship() {
    	reset();
    }

    public void reset(){
        direction = 0.0;
        v = 0.01;
        paused = false;
    }
    
    public void move(Point nextPoint) {
        x = nextPoint.x;
        y = nextPoint.y;
	}

    public void speedUp() {
        v *= speedUpRate;
    }

    public void speedDown() {
        v *= speedDownRate;
    }

    public void changePauseState() {
        paused = !paused;
    }
    public double getSpeed() {
		return v;
	}
    public long getTimeInterval() {
    	timeInterval = 1 / v;
		return (long) timeInterval;
	}
    public Point step() {
        double vX = v * Math.cos(direction);
        double vY = v * Math.sin(direction);
        
        double x2 = vX * timeInterval;
        double y2 = vY * timeInterval;
		x2 = x + x2;
		y2 = y + y2;
        
        Point nextPoint = new Point(x2, y2);
        return nextPoint;
	}
}
