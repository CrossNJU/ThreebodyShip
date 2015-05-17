package cross.threebodyship.model;

import java.util.Observable;

public class Stage extends Observable implements Runnable {

	public String title;
	public boolean isLocked = false;
	boolean isComplished;
	boolean isFailed;
	volatile boolean isBack;
	String achievement = null;
	public int num;
	
	public Stage nextStage;
	
	public Game game = new Game();
	
	Thread stageThread;
	
	public Stage(String title) {
		this.title = title;
		this.isComplished = false;
		this.isFailed = false;
		this.isBack = false;
//		this.game = game;
	}
	
	public void startStage() {
		Thread gameThread = new Thread(game);
		gameThread.start();
		stageThread = new Thread(this);
		stageThread.start();
	}
	
	public void win() {
		checkAchievement();
		System.out.println("Win");
		this.nextStage.isLocked = false;
		setChanged();
		notifyObservers("win");
	}
	
	public void restart() {
		System.out.println("Restart");
		setChanged();
		notifyObservers("fail");
	}
	
	public void checkAchievement() {
		
	}
	
	public void leave() {
		isBack = true;
		game.setState(false);
		//game = null;
		//stageThread = null;
	}
	
	@Override
	public void run() {
		try {
			while (!isBack) {
				if(game.inGame){
				if (game.isWin) {
					win();
					game.inGame = false;
					break;
				}
				if (game.isFailed) {
					restart();
					game.inGame = false;
					break;
				}
				}
				else 
				if (!game.isStarting) {
					System.out.println(1);
					game.setState(false);
				}
				//System.out.println("Check if complished or else");
				Thread.sleep(game.getRI());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
