package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.plaf.synth.SynthSpinnerUI;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.userinterface.ThreebodyPanel.AlphaAnimeThread;
import cross.threebodyship.util.RotateImage;

public class WinUI extends ThreebodyPanel {
	JButton nextStageButton;
	StageUI stageUI = null;

	WinAlphaAnimeThread waat;

	Image[] completeAnime = new Image[72];
	MediaTracker tracker = null;
	int currentAnime = 0;
	CompleteAnimeThread cat;

	int bgX = 0;
	BackgroundAnimeThread bat = new BackgroundAnimeThread();
	
	public WinUI(StageUI stageUI) {
		this.stageUI = stageUI;
		initWinUI();
	}

	public void initWinUI() {
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);

		nextStageButton = new JButton("Next Stage >");
		nextStageButton.setBounds((int) (MainUI.WIDTH * 0.75),
				(int) (MainUI.HEIGHT * 0.40), 142, 142);
		nextStageButton.setIcon(new ImageIcon(
				"img/Button/btn-nextstage-normal.png"));
		nextStageButton.setRolloverIcon(new ImageIcon(
				"img/Button/btn-nextstage-hover.png"));
		nextStageButton.setContentAreaFilled(false);
		nextStageButton.setBorderPainted(false);
		nextStageButton.setFocusPainted(false);
		nextStageButton.addMouseListener(new EnterStageButtonListener(
				stageUI.mainUI, stageUI.stage.nextStage));
		add(nextStageButton);

		waat = new WinAlphaAnimeThread();

		cat = new CompleteAnimeThread();
		setup();
		
		bat = new BackgroundAnimeThread();
		bat.execute();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));
		//
		// Image img = new
		// ImageIcon("img/GameBackground/bg-stage"+stageUI.stage.num+"-after.png").getImage();
		// g.drawImage(img, 0, 0, null);

		Image B_img = new ImageIcon("img/GameBackground/bg.jpg").getImage();
		g.drawImage(B_img, 0, 0, MainUI.WIDTH, MainUI.HEIGHT, 0 + bgX, 0,
				1024 + bgX, 768, null);

		Image cover = new ImageIcon("img/Win/cover-after.png").getImage();

		g.drawImage(cover, 0, 0, null);
		g.drawImage(completeAnime[currentAnime], 327, 309, 354, 90, null);

	}

	public void setup() {
		tracker = new MediaTracker(this);
		Toolkit toolkit = getToolkit();

		for (int i = 0; i < 72; i++) {
			completeAnime[i] = toolkit.getImage("img/Win/anime/anime-complete-"
					+ i + ".png");
			tracker.addImage(completeAnime[i], 0);
		}
	}

	public class CompleteAnimeThread extends SwingWorker<Boolean, Boolean> {

		@Override
		protected Boolean doInBackground() throws Exception {
			try {
				tracker.waitForID(0);
			} catch (Exception e) {
				// TODO: handle exception
			}

			while ((currentAnime >= 0) && (currentAnime < 71)) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						repaint();
					}
				});
				// System.out.println("do");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
				currentAnime++;
			}

			return null;
		}

	}

	public class WinAlphaAnimeThread extends SwingWorker<Boolean, Boolean> {
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
			return null;

		}

		public void done() {
			repaint();
			isFinish = true;
			cat.execute();
		}
	}

	
	class BackgroundAnimeThread extends SwingWorker<Boolean, Boolean> {
		@Override
		protected Boolean doInBackground() throws Exception {

			while (true) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						repaint();
					}
				});

				try {
					Thread.sleep(60);
				} catch (Exception e) {
					// TODO: handle exception
				}
				bgX++;
				bgX %= 1669 - 1024;
				// System.out.println(SwingUtilities.isEventDispatchThread());
			}
			// return null;
		}

	}
}
