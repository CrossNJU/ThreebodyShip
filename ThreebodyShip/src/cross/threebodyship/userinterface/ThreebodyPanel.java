package cross.threebodyship.userinterface;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class ThreebodyPanel extends JPanel{
	public String style = "";
	public float alpha;
	public AlphaAnimeThread aat = null;
	public AlphaDisappearThread adt = null;
	public int delay = 5;
	public Boolean isFinish = false;
	public JPanel currentPane = null;
	
	public ThreebodyPanel(){
		aat = new AlphaAnimeThread();
		adt = new AlphaDisappearThread();
		alpha = 0f;
	}
	
	public void init(){
		
	}
	
	public void stop(){
		
	}
	
	public String getStyle(){
		return style;
	}
	
	public void reset(){
		
	}
	public class AlphaAnimeThread extends SwingWorker<Boolean, Boolean>{
		@Override
		protected Boolean doInBackground() throws Exception {
			// TODO Auto-generated method stub
			alpha = 0;
			isFinish = false;
			while((alpha<1)&&alpha>=0){
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						repaint();
					}
				});
				try {
					Thread.sleep(delay);
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
			isFinish = true;
			aat = new AlphaAnimeThread();
		}
	}
	
	public class AlphaDisappearThread extends SwingWorker<Boolean, Boolean>{
		@Override
		protected Boolean doInBackground() throws Exception {
			// TODO Auto-generated method stub
			alpha = 1;
			isFinish = false;
			while((alpha<=1)&&alpha>0){
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						repaint();
					}
				});
				try {
					Thread.sleep(delay);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if(alpha>0.01){
					alpha = alpha - 0.01f;
				}
				else {
					alpha = 0f;
				}
			}
			return null;
		
		}
		
		public void done(){
			repaint();
			isFinish = true;
			setVisible(false);
			adt = new AlphaDisappearThread();
		}
	}
}
