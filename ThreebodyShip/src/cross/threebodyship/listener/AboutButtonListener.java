package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cross.threebodyship.userinterface.StarterUI;

public class AboutButtonListener implements MouseListener{
	StarterUI starterUI;
	
	public AboutButtonListener(StarterUI starterUI) {
		// TODO Auto-generated constructor stub
		this.starterUI = starterUI;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		starterUI.aboutUI.setVisible(true);
		starterUI.aboutUI.aat.execute();
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
