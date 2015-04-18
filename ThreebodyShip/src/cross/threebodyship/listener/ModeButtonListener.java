package cross.threebodyship.listener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Comparator;

import javax.swing.JPanel;

import cross.threebodyship.userinterface.SelectorUI;
import cross.threebodyship.util.DisplayPanel;

public class ModeButtonListener implements MouseListener {
	SelectorUI selectorUI = null;
	Component newPane = null;
	
	public ModeButtonListener(SelectorUI selectorUI,Component newPane) {
		// TODO Auto-generated constructor stub
		this.selectorUI = selectorUI;
		this.newPane = newPane;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		selectorUI.remove(selectorUI.currentPane);
		selectorUI.currentPane = newPane;
		selectorUI.add(selectorUI.currentPane);
		selectorUI.currentPane.setVisible(true);
		selectorUI.repaint();
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
