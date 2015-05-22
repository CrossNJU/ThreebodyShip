package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import cross.threebodyship.userinterface.SkillUI.AlphaAnimeThread;
import cross.threebodyship.userinterface.SkillUI.AlphaDisappearThread;

public class ChapUI extends ThreebodyPanel {
	StageUI stageUI;
	int stageNum;
	public AlphaDisappearThread adt = null;
	public AlphaAnimeThread aat = null;

	public ChapUI(StageUI stageUI) {
		// TODO Auto-generated constructor stub
		this.stageUI = stageUI;
		stageNum = stageUI.stage.num;
		init();
	}

	public void init() {
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);
		aat = new AlphaAnimeThread();
		adt = new AlphaDisappearThread();
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));

		Image img = new ImageIcon("img/Before/chap/chap" + (stageNum / 3 + 1)
				+ ".png").getImage();
		g.drawImage(img, 0, 0, null);
	}

	public class AlphaAnimeThread extends SwingWorker<Boolean, Boolean> {
		@Override
		protected Boolean doInBackground() throws Exception {
			// TODO Auto-generated method stub
			alpha = 0;
			isFinish = false;
			while ((alpha < 1) && alpha >= 0) {
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
				if (alpha < 0.99) {
					alpha = alpha + 0.01f;
				} else {
					alpha = 1f;
				}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}

		public void done() {
			repaint();
			isFinish = true;
			
			adt.execute();
			aat = new AlphaAnimeThread();
		}
	}

	public class AlphaDisappearThread extends SwingWorker<Boolean, Boolean> {
		@Override
		protected Boolean doInBackground() throws Exception {
			// TODO Auto-generated method stub
			alpha = 1;
			isFinish = false;
			while ((alpha <= 1) && alpha > 0) {
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
				if (alpha > 0.01) {
					alpha = alpha - 0.01f;
				} else {
					alpha = 0f;
				}
			}
			return null;

		}

		public void done() {
			repaint();
			isFinish = true;
			setVisible(false);
			stageUI.beforeUI.setVisible(true);
			stageUI.beforeUI.aat.execute();
			adt = new AlphaDisappearThread();
		}
	}
}
