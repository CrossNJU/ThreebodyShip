package cross.threebodyship.model;

public class Rect implements Runnable{
	Game game;
	double speed;
	public boolean stop2 = false;
	
	public Rect(Game game){
		this.game = game;
		speed = game.ship.getSpeed();
	}
	
	@Override
	public void run() {
		int width = 0;
		int height = 10;
		
		while(!stop2){
			try {
				Thread.sleep(game.getRI());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			width += 5;
			if(width>30) width = 0;
			game.rectwidth = width;
			game.rectheight = height;
			
			double rate = game.speedChangeRate;
			
			for(int i=0; i<=(int)width/5; i++){
				rate *= game.speedChangeRate;
			}
			game.ship.setSpeed(speed*rate);
			
			System.out.println("speed:"+game.ship.getSpeed());
			
		}
		// TODO Auto-generated method stub
		
	}

}
