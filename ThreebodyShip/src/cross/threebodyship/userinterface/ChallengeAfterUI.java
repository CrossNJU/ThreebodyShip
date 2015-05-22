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

public class ChallengeAfterUI extends ThreebodyPanel {
	WinUI winUI;
	int stageNum;
	public AlphaDisappearThread adt = null;
	public AlphaAnimeThread aat = null;

	public ChallengeAfterUI(WinUI winUI) {
		// TODO Auto-generated constructor stub
		this.winUI = winUI;
		stageNum = winUI.stageUI.stage.num;
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

		Image img1 = new ImageIcon("img/Win/challenge/after_challenge_1.png")
				.getImage();
		Image img2 = new ImageIcon("img/Win/challenge/after_challenge_2.png")
				.getImage();
		Image img3 = new ImageIcon("img/Win/challenge/after_challenge_3.png")
				.getImage();
		if (stageNum == 9) {
			g.drawImage(img1, 0, 0, null);
		} else if (stageNum == 12) {
			g.drawImage(img2, 0, 0, null);
		} else {
			g.drawImage(img3, 0, 0, null);
		}
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
				Thread.sleep(2000);
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
			winUI.cat.execute();
			adt = new AlphaDisappearThread();
		}
	}
}
