package cross.threebodyship.userinterface;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class ThreebodyPanel extends JPanel{
	float alpha;
	public AlphaAnimeThread aat = null;
	
	public ThreebodyPanel(){
		aat = new AlphaAnimeThread();
		alpha = 0f;
	}
	
	public void init(){
		
	}
	
	public void stop(){
		
	}
	
	public class AlphaAnimeThread extends SwingWorker<Boolean, Boolean>{
		@Override
		protected Boolean doInBackground() throws Exception {
			// TODO Auto-generated method stub
			alpha = 0;
			while((alpha<1)&&alpha>=0){
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						repaint();
					}
				});
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if(alpha<0.99){
					alpha = alpha + 0.01f;
				}
				else {
					alpha = 1f;
				}
			}
			return null;
		
		}
		
		public void done(){
			repaint();
			aat = new AlphaAnimeThread();
		}
	}
}
