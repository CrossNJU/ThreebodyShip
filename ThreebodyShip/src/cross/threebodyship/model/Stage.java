package cross.threebodyship.model;

import java.util.Observable;

public class Stage extends Observable implements Runnable {

	public String title;
	boolean isLocked;
	boolean isComplished;
	boolean isFailed;
	volatile boolean isBack;
	String achievement = null;
	String beforeImageName;
	String afterImageName;
	
	public Stage nextStage;
	
	public Game game;
	
	Thread stageThread;
	
	public Stage(String title, String beforeImageName, String afterImageName, Game game) {
		this.title = title;
		this.isComplished = false;
		this.isFailed = false;
		this.isBack = false;
		this.beforeImageName = beforeImageName;
		this.afterImageName = afterImageName;
		this.game = game;
		
		startStage();
		stageThread = new Thread(this);
		stageThread.start();
	}
	
	public void startStage() {
		Thread gameThread = new Thread(game);
		gameThread.start();
	}
	
	public void win() {
		checkAchievement();
		System.out.println("Win");
		setChanged();
		notifyObservers();
	}
	
	public void restart() {
		System.out.println("Restart");
	}
	
	public void checkAchievement() {
		
	}
	
	public void leave() {
		isBack = true;
		game.isInterrupted = true;
		//game = null;
		//stageThread = null;
	}
	
	@Override
	public void run() {
		try {
			while (!isBack) {
				if (game.isComplished) {
					win();
					break;
				}
				if (isFailed) {
					restart();
				}
				System.out.println("Check if complished or else");
				Thread.sleep(300);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
