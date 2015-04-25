package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import cross.threebodyship.userinterface.MainUI;

public class DragMainUIListener implements MouseListener,MouseMotionListener{
	MainUI mainUI;
	
	public DragMainUIListener(MainUI mainUI){
		this.mainUI = mainUI;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.mainUI.setLocation(mainUI.getLocation().x+e.getX()-mainUI.oldX,
				mainUI.getLocation().y+e.getY()-mainUI.oldY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mainUI.oldX = e.getX();
		mainUI.oldY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
