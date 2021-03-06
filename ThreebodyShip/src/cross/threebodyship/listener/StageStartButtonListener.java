package cross.threebodyship.listener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cross.threebodyship.userinterface.BeforeUI;
import cross.threebodyship.userinterface.GameUI;
import cross.threebodyship.userinterface.SelectorUI;
import cross.threebodyship.userinterface.StageUI;
import cross.threebodyship.util.DisplayPanel;

public class StageStartButtonListener implements MouseListener {
	GameUI gameUI = null;
	BeforeUI beforeUI = null;
	StageUI stageUI = null;

	public StageStartButtonListener(StageUI stageUI, BeforeUI beforeUI) {
		// TODO Auto-generated constructor stub
		// this.gameUI = gameUI;
		this.beforeUI = beforeUI;
		this.stageUI = stageUI;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// DisplayPanel.stageDisplay(stageUI, newPane);
		beforeUI.adt.execute();
		stageUI.revalidate();
		stageUI.repaint();
		stageUI.stage.startStage();
		stageUI.gamePanel.requestFocus();
		stageUI.gamePanel.rt.start();
		 if ((stageUI.gamePanel.game.gameNumber == 13)
		 || (stageUI.gamePanel.game.gameNumber == 14)||(stageUI.gamePanel.game.gameNumber==16)) {
			stageUI.gamePanel.sat1.start();
		}else if((stageUI.gamePanel.game.gameNumber == 15)){
			stageUI.gamePanel.sat2.start();
			stageUI.gamePanel.sat1.start();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
