package cross.threebodyship.listener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cross.threebodyship.userinterface.SelectorUI;
import cross.threebodyship.userinterface.StageUI;
import cross.threebodyship.util.DisplayPanel;

public class StageButtonListener implements MouseListener {
	StageUI stageUI = null;
	Component newPane = null;
	
	public StageButtonListener(StageUI stageUI,Component newPane) {
		// TODO Auto-generated constructor stub
		this.stageUI = stageUI;
		this.newPane = newPane;
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		DisplayPanel.stageDisplay(stageUI, newPane);
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
