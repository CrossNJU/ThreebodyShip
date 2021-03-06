package cross.threebodyship.model;

import java.util.Observable;

public class Stage extends Observable implements Runnable {

	public String title;
	public boolean isLocked = true;
	boolean isComplished;
	boolean isFailed;
	volatile boolean isBack;
	String achievement = null;
	public int num;

	public Stage nextStage;
	public Stage nextChallengeStage = null;
	public Thread gameThread;

	public Game game = new Game();

	Thread stageThread;

	public Stage(String title) {
		this.title = title;
		this.isComplished = false;
		this.isFailed = false;
		this.isBack = false;
		// this.game = game;
	}

	public void startStage() {
		gameThread = new Thread(game);
		gameThread.start();
		stageThread = new Thread(this);
		stageThread.start();
	}

	public void win() {
		checkAchievement();
		System.out.println("Win");
		if (num != 18 && num != 21)
			this.nextStage.isLocked = false;
		if (num == 9 || num == 12 || num == 15) this.nextChallengeStage.isLocked = false;
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
		// game = null;
		// stageThread = null;
	}

	@Override
	public void run() {
		try {
			while (!isBack) {
				if (game.inGame) {
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
				// else leave();
				// System.out.println("Check if complished or else");
				Thread.sleep(game.getRI());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
