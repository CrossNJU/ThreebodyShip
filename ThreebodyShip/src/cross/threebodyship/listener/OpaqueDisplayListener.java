package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import cross.threebodyship.userinterface.MainPanel;
import cross.threebodyship.userinterface.MainUI;
import cross.threebodyship.userinterface.SelectorUI;
import cross.threebodyship.userinterface.ThreebodyPanel;

public class OpaqueDisplayListener implements MouseListener {
	MainUI mainUI;
	MainPanel mainPanel;
	ThreebodyPanel newpanel;
	JudgeThread jt = new JudgeThread();

	public OpaqueDisplayListener(MainPanel mainPanel, ThreebodyPanel newPanel) {
		// TODO Auto-generated constructor stub
		this.newpanel = newPanel;
		this.mainUI = mainUI;
		this.mainPanel = mainPanel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		if((newpanel.getStyle().equals("selector"))||(newpanel.getStyle().equals("starter"))){
//			if(mainPanel.currentPane.getStyle().equals("stage")){
//				mainPanel.music.stop(mainPanel.music.currentMusic);
//				mainPanel.music.play(0);
//			}
//		}
//		
		if(newpanel.getStyle().equals("selector")){
			newpanel.reset();
		}
		mainPanel.add(newpanel);
		mainPanel.currentPane.repaint();
		mainPanel.remove(mainPanel.currentPane);
		mainPanel.currentPane = newpanel;
		mainPanel.validate();
		mainPanel.repaint();
		newpanel.aat.execute();
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
	
	
	class JudgeThread extends SwingWorker<Boolean, Boolean>{
		
		@Override
		protected Boolean doInBackground() throws Exception {
			// TODO Auto-generated method stub
			while(true){
				if(newpanel.isFinish){
					SwingUtilities.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							mainPanel.remove(mainPanel.currentPane);
							mainPanel.currentPane = newpanel;
							mainPanel.revalidate();
							mainPanel.repaint();
							// TODO Auto-generated method stub
							
						}
					});
					break;
				}
			}
			
			return null;
		}
		
	}

}
