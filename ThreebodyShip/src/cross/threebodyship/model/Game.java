package cross.threebodyship.model;

import java.util.Observable;

import javax.swing.JOptionPane;

/*
 * Game主要包含运动算法和输赢判断逻辑
 * 运动算法可能需要简化
 */

public class Game extends Observable implements Runnable {
    public int maxX;
    public int maxY;
    public boolean running = false;
    public boolean isComplished = false;
    public volatile boolean isInterrupted = false;
    
    public Ship ship;
    public Star star;
    
    public final static double G = 0.00000000006672;
    public final static double PI = Math.PI;

    public Game(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;

        reset();
    }

    public void reset(){
        //初始化Ship
    	ship = new Ship();
    	ship.x =  50;
        ship.y = maxY / 4;
        ship.direction = 0.0;

        //初始化Star
        star = new Star();
        star.x = maxX / 2;
        star.y = maxY / 2;
    }
   
    public boolean moveOn() {
    	double x = ship.x;
    	double y = ship.y;
		System.out.println("Direction = " + ship.direction);

        if ((0 <= x && x < maxX) && (0 <= y && y < maxY)) {
			//运动算法，有bug
    		double distance = Math.sqrt((x - star.x) * (x - star.x) + (y - star.y) * (y - star.y));
    		System.out.println("distance = " + distance);
        	if (distance < star.range) {
        		double a = G * star.mass / (distance * distance);
        		double thetaV = ship.direction;
        		double thetaA = Math.atan((star.y - y) / (star.x - x));
        		//修正thetaA
        		if (x > star.x) {
					thetaA += PI;
				}
        		double thetaAV = Math.abs(thetaA - thetaV);
        		//double thetaNormal = thetaV;
        		double thetaTangent = thetaV + PI / 2;
        		//修正thetaTangent
        		if (y > star.y) {
					thetaTangent -= PI;
				}
        		
        		double aNormal = a * Math.cos(thetaAV);
        		double vNormal = ship.v + aNormal * ship.timeInterval;
        		double sNormal = (ship.v + vNormal) / 2 * ship.timeInterval;
        		double xNormal = sNormal * Math.cos(thetaV);
        		double yNormal = sNormal * Math.sin(thetaV);
        		
        		double aTangent = a * Math.sin(thetaAV);
        		double sTangent = aTangent * ship.timeInterval * ship.timeInterval / 2;
        		double xTangent = sTangent * Math.cos(thetaTangent);
        		double yTangent = sTangent * Math.sin(thetaTangent);
        		
        		double deltaX = xNormal + xTangent;
        		double deltaY = yNormal + yTangent;
        		
        		double x2 = x + deltaX;
        		double y2 = y + deltaY;
        		ship.direction = Math.atan(deltaY / deltaX);
        		//修正direction
        		if (deltaX < 0) {
					ship.direction += PI;
				}
        		ship.v = vNormal / Math.abs(Math.cos(ship.direction - thetaV));
        		//ship.x = x2;
        		//ship.y = y2;
        		
        		ship.move(new Point(x2, y2));
        		return true;
            } else {
                ship.move(ship.step());
                return true;
            }
        }
        //碰到边界
        return false;
    }

	@Override
    public void run() {
        running = true;
        while (running) {
            try {
                Thread.sleep((long) ship.getTimeInterval());
            } catch (Exception e) {
                break;
            }
            if (isInterrupted) {
				break;
			}

            if (!ship.paused) {
                if (moveOn()) {
                	//Game通知GameUI更新
                    setChanged();
                    notifyObservers();
                } else {
                    //JOptionPane.showMessageDialog(null, "Opps:-(", "Opps", JOptionPane.INFORMATION_MESSAGE);
                    //reset();
                	isComplished = true;
                    break;
                }
            }
        }
        running = false;
    }

}

