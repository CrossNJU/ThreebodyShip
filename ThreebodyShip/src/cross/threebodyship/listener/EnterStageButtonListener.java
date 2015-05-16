package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.synth.SynthSpinnerUI;

import cross.threebodyship.model.Game;
import cross.threebodyship.model.Stage;
import cross.threebodyship.userinterface.MainUI;
import cross.threebodyship.userinterface.SelectorUI;
import cross.threebodyship.userinterface.StageUI;
import cross.threebodyship.userinterface.ThreebodyPanel;
import cross.threebodyship.util.DisplayPanel;

public class EnterStageButtonListener implements MouseListener {
	Stage stage = null;
	MainUI mainUI = null;
	ThreebodyPanel mainPanel;
	
	public EnterStageButtonListener(MainUI mainUI, Stage stage) {
		// TODO Auto-generated constructor stub
		this.mainUI = mainUI;
		this.stage = stage;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (stage.isLocked) System.out.println("you can't goto this stage!");
		else{
		stage.game = new Game();
		stage.game.gameNumber = stage.num;
		mainUI.stagePanel = new StageUI(mainUI, stage);
		DisplayPanel.mainDisplay(mainUI, mainUI.stagePanel);
		mainUI.stagePanel.aat.execute();
		stage.game.reset();
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

	public void displayPanel(JPanel panel) {
		mainUI.removeAll();
		mainUI.add(panel);
		mainUI.revalidate();
		mainUI.repaint();
	}
}
