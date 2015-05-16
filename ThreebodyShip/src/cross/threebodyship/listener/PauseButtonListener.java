package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cross.threebodyship.userinterface.GameUI;
import cross.threebodyship.userinterface.PauseUI;

public class PauseButtonListener implements MouseListener{
	GameUI gameUI = null;
	PauseUI pauseUI = null;
	
	public PauseButtonListener(GameUI gameUI , PauseUI pauseUI) {
		// TODO Auto-generated constructor stub
		this.gameUI = gameUI;
		this.pauseUI = pauseUI;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		gameUI.game.setState(false);
		
//		pauseUI.setVisible(true);
//		gameUI.add(pauseUI,0);
//		gameUI.validate();
		
		gameUI.pauseUI.setVisible(true);
		gameUI.repaint();
		pauseUI.aat.execute();
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
