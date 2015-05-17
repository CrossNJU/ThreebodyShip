package cross.threebodyship.userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import cross.threebodyship.listener.ExitButtonListener;
import cross.threebodyship.model.Point;
import cross.threebodyship.model.RoundButton;

public class StarterUI extends ThreebodyPanel {
	public JButton startGameButton = new JButton();
	public RoundButton exitButton = new RoundButton();
	public RoundButton aboutButton = new RoundButton();
	MainUI mainUI = null;
	int i = 0;
	int j = 50;
	Thread anime;
	int bgX = 0;
	BackgroundAnimeThread bat;

	public StarterUI(MainUI mainUI) {
		this.mainUI = mainUI;
		init();
	}

	public void init() {
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);

		startGameButton.setBounds(663, 327, 188, 188);
		
		startGameButton.setIcon(new ImageIcon("img/Button/btn-start-normal.png"));
		startGameButton.setRolloverIcon(new ImageIcon("img/Button/btn-start-hover.png"));
		startGameButton.setFocusable(false);
		startGameButton.setContentAreaFilled(false);
		startGameButton.setBorderPainted(false);
		
//		exitButton.setBounds(820, 550, 75, 75);
		exitButton.setIcon(new ImageIcon("img/Button/btn-quit-normal.png"));
		exitButton.setRolloverIcon(new ImageIcon("img/Button/btn-quit-hover.png"));
		exitButton.setFocusable(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.addMouseListener(new ExitButtonListener(mainUI));
		
//		aboutButton.setBounds(529, 427, 92, 92);
		aboutButton.setIcon(new ImageIcon("img/Button/btn-about-normal.png"));
		aboutButton.setRolloverIcon(new ImageIcon("img/Button/btn-about-hover.png"));
		aboutButton.setFocusable(false);
		aboutButton.setContentAreaFilled(false);
		aboutButton.setBorderPainted(false);
		
		
		add(startGameButton);
		add(exitButton);
		add(aboutButton);
		bat = new BackgroundAnimeThread();
		
		Thread exitButtonThread = new Thread(exitButton);
		Thread aboutButtonThread = new Thread(aboutButton);
		exitButton.setData(new Point(820,550), new Point(757, 421), 75, 0);
		aboutButton.setData(new Point(529,427), new Point(757, 421), 92, Math.PI);
		
		
		exitButtonThread.start();
		aboutButtonThread.start();
//		bat.execute();
	}

	public void paintComponent(Graphics g) {
		// Image img = new
		// ImageIcon("img/Starter/bg-starter-mid.png").getImage();
		// g.drawImage(img, 0, 0, null);

//		Image B_img = new ImageIcon("img/GameBackground/bg.jpg").getImage();
//		g.drawImage(B_img, 0, 0, MainUI.WIDTH, MainUI.HEIGHT, 0 + bgX, 0,
//				1024 + bgX, 768, null);
		
		Image cover = new ImageIcon("img/Starter/cover-starter-85.png")
				.getImage();
		g.drawImage(cover, 0, 0, null);

		Image star = new ImageIcon("img/Starter/content-starter.png")
				.getImage();
		g.drawImage(star, 0, 0, null);

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
		}
	}

}
