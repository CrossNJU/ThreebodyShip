package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import cross.threebodyship.userinterface.ThreebodyPanel.AlphaAnimeThread;
import cross.threebodyship.userinterface.ThreebodyPanel.AlphaDisappearThread;

public class EndUI extends ThreebodyPanel{
	AlphaAnimeThread aat;
	StageUI stageUI;
	EndWordsUI endWordsUI;
	
	public EndUI(StageUI stageUI) {
		// TODO Auto-generated constructor stub
		this.stageUI = stageUI;
		init();
	}
	
	public void init(){
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);
		delay = 7;
		
		aat = new AlphaAnimeThread();
		endWordsUI = new EndWordsUI(stageUI);
		endWordsUI.setVisible(false);
		add(endWordsUI);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));
		
		Image endCover = new ImageIcon("img/End/ending.png").getImage();
		g.drawImage(endCover, 0, 0, null);
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
			
			Thread.sleep(1000);
			
			return null;
		
		}
		
		public void done(){
			repaint();
			isFinish = true;
			endWordsUI.setVisible(true);
			endWordsUI.aat.execute();
			aat = new AlphaAnimeThread();
		}
	}
	

}
