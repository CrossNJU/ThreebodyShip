package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.nio.channels.Pipe;

import javax.swing.JPanel;
import javax.swing.RepaintManager;

import cross.threebodyship.model.Point;

public class ScrollListener implements MouseWheelListener{
	JPanel currentPanel = null;
	java.awt.Point point = null;
	int scrollSpeed = 102;
	
	public ScrollListener(JPanel currentPanel) {
		// TODO Auto-generated constructor stub
		this.currentPanel = currentPanel;
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		point = currentPanel.getLocation();
		if(e.getWheelRotation() == -1){
			if(point.getY()+scrollSpeed<0){
				point.y = point.y+scrollSpeed;
				currentPanel.setLocation(point);
			}
			else {
				point.y = 0;
				currentPanel.setLocation(point);
			}
			currentPanel.repaint();
		}
		
		if(e.getWheelRotation() == 1){
			if(point.getY()-scrollSpeed>768-currentPanel.getHeight()){
				point.y = point.y-scrollSpeed;
				currentPanel.setLocation(point);
			}
			else {
				point.y = 768-currentPanel.getHeight();
				currentPanel.setLocation(point);
			}
			currentPanel.repaint();
		}
	}

}
