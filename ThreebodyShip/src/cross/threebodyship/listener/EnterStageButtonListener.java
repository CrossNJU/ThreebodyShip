package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.synth.SynthSpinnerUI;

import cross.threebodyship.model.Game;
import cross.threebodyship.model.Stage;
import cross.threebodyship.userinterface.MainPanel;
import cross.threebodyship.userinterface.SelectorUI;
import cross.threebodyship.userinterface.StageUI;
import cross.threebodyship.userinterface.ThreebodyPanel;
import cross.threebodyship.util.DisplayPanel;

public class EnterStageButtonListener implements MouseListener {
	Stage stage = null;
	MainPanel mainPanel;

	public EnterStageButtonListener(MainPanel mainPanel, Stage stage) {
		// TODO Auto-generated constructor stub
		this.mainPanel = mainPanel;
		this.stage = stage;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (stage.isLocked)
			System.out.println("you can't goto this stage!");
		else {
			//播放音乐
			if((mainPanel.currentPane.style.equals("selector"))||(mainPanel.currentPane.style.equals("starter"))){
				mainPanel.music.stop(0);
				mainPanel.music.play((stage.num-1/9)+1);
			}else if(mainPanel.music.currentMusic!=((stage.num-1)/3+1)){
				mainPanel.music.stop(mainPanel.music.currentMusic);
				mainPanel.music.play((stage.num-1)/9+1);
			}
			stage.game = new Game();
			stage.game.gameNumber = stage.num;
			mainPanel.remove(mainPanel.currentPane);
			mainPanel.currentPane = null;
			mainPanel.mainUI.stagePanel = new StageUI(mainPanel, stage);
			mainPanel.currentPane = mainPanel.mainUI.stagePanel;
			mainPanel.add(mainPanel.currentPane);
			mainPanel.currentPane.setVisible(true);
			mainPanel.revalidate();
			mainPanel.repaint();
			mainPanel.mainUI.stagePanel.aat.execute();
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
		mainPanel.removeAll();
		mainPanel.add(panel);
		mainPanel.revalidate();
		mainPanel.repaint();
	}
}
