package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cross.threebodyship.model.Game;
import cross.threebodyship.userinterface.GameUI;
import cross.threebodyship.userinterface.PauseUI;

public class ResumeButtonListener implements MouseListener{
	GameUI gameUI = null;
	PauseUI pauseUI = null;
	
	public ResumeButtonListener(GameUI gameUI , PauseUI pauseUI) {
		// TODO Auto-generated constructor stub
		this.gameUI = gameUI;
		this.pauseUI = pauseUI;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		pauseUI.adt.execute();
//		gameUI.game.setState(true);
		GameUI gameUi = gameUI;
		if (gameUi != null) {
			Game temp = gameUi.game;
			temp.ship.setState(true);
//			gameUi.stageUI.stage.gameThread.resume();
		}else {
			System.out.println(1);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
