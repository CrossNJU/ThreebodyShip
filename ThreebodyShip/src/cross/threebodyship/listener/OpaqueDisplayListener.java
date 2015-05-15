package cross.threebodyship.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingWorker;

import cross.threebodyship.userinterface.MainUI;
import cross.threebodyship.userinterface.SelectorUI;
import cross.threebodyship.userinterface.ThreebodyPanel;

public class OpaqueDisplayListener implements MouseListener {
	MainUI mainUI;
	ThreebodyPanel mainPanel;
	ThreebodyPanel newpanel;
//	JudgeThread jt = new JudgeThread();

	public OpaqueDisplayListener(ThreebodyPanel mainPanel, ThreebodyPanel newPanel) {
		// TODO Auto-generated constructor stub
		this.newpanel = newPanel;
		this.mainUI = mainUI;
		this.mainPanel = mainPanel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mainPanel.add(newpanel);
		mainPanel.remove(mainPanel.currentPane);
		mainPanel.currentPane = newpanel;
		mainPanel.validate();
		newpanel.aat.execute();
//		jt.execute();
		
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
	
	
//	class JudgeThread extends SwingWorker<Boolean, Boolean>{
//		
//		@Override
//		protected Boolean doInBackground() throws Exception {
//			// TODO Auto-generated method stub
//			while(true){
//				if(newpanel.isFinish){
//					mainUI.remove(mainUI.currentPane);
//					mainUI.currentPane = newpanel;
//					mainUI.revalidate();
//					break;
//				}
//			}
//			
//			return null;
//		}
//		
//	}

}
