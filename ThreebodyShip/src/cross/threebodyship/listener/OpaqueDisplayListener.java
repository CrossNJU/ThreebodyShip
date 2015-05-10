package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cross.threebodyship.userinterface.MainUI;
import cross.threebodyship.userinterface.SelectorUI;
import cross.threebodyship.userinterface.ThreebodyPanel;

public class OpaqueDisplayListener implements MouseListener {
	MainUI mainUI;
	ThreebodyPanel newpanel;

	public OpaqueDisplayListener(MainUI mainUI, ThreebodyPanel newPanel) {
		// TODO Auto-generated constructor stub
		this.newpanel = newPanel;
		this.mainUI = mainUI;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mainUI.add(newpanel);
		mainUI.remove(mainUI.currentPane);
		mainUI.currentPane = newpanel;
		mainUI.validate();
		newpanel.aat.execute();
//		while (selectorUI.aat.isDone()) {
//			if (selectorUI.isOK) {
//				mainUI.currentPane = selectorUI;
//				break;
//			}
//		}
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
