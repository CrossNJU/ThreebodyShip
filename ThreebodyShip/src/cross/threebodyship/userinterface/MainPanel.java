package cross.threebodyship.userinterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import cross.threebodyship.listener.OpaqueDisplayListener;
import cross.threebodyship.model.Selector;

public class MainPanel extends ThreebodyPanel {
	public MainUI mainUI;
	public ThreebodyPanel currentPane;
	public StarterUI starterUI;
	public SelectorUI selectorUI;
	public StageUI stageUI;

	int bgX = 0;
	BackgroundAnimeThread bat = new BackgroundAnimeThread();

	public MainPanel(MainUI mainUI) {
		// TODO Auto-generated constructor stub
		this.mainUI = mainUI;
		init();
	}

	public void init() {
		Selector selector = new Selector();

		// 初始化开始界面
		starterUI = new StarterUI(mainUI);
		// 初始化选择界面
		selectorUI = new SelectorUI(selector, this);

		starterUI.startGameButton.addMouseListener(new OpaqueDisplayListener(
				this, selectorUI));

		currentPane = starterUI;
		add(currentPane);

		bat = new BackgroundAnimeThread();
		bat.start();
	}

	public void paintComponent(Graphics g) {
		Image B_img = new ImageIcon("img/GameBackground/bg.png").getImage();
		g.drawImage(B_img, 0, 0, MainUI.WIDTH, MainUI.HEIGHT, 0 + bgX, 0,
				1024 + bgX, 768, null);
	}

	class BackgroundAnimeThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();

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
