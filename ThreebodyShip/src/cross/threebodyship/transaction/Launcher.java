package cross.threebodyship.transaction;

import cross.threebodyship.model.Game;
import cross.threebodyship.userinterface.GameUI;
import cross.threebodyship.userinterface.MainUI;
import cross.threebodyship.userinterface.MainUIPre;


public class Launcher {
	public static void main(String[] args) {
		MainUI mainUI = new MainUI();
		mainUI.mainrun();

//		starter.addObserver(starterUI);
//		Thread starterThread = new Thread(starter);
//		starterThread.start();
		
//		Game game = new Game(720,480);
//		GameController gameController = new GameController(game);
//		GameUI gameUI = new GameUI(game, gameController);
//		
//		game.addObserver(gameUI);
//		(new Thread(game)).start();
		
		/*
		 * 游戏说明：
		 * 开始前，目前支持增加角度（U），增加速度（S），飞船上/下移（方向上/下键），开始（O）
		 * 开始后，目前支持暂停（Space），重置游戏（Enter），速度增加/减小（方向上/下键）
		 * 
		 */
		
//		//启动游戏
//		Game game = new Game(600,500);
//		GameUI gameUI = new GameUI(game,600,500);
//		
//		game.addObserver(gameUI);
//		Thread gameThread = new Thread(game);
//		
//		gameThread.start();
	}
}
