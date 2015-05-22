package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.naming.InitialContext;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;

import cross.threebodyship.userinterface.ThreebodyPanel.AlphaDisappearThread;

public class StartUI extends ThreebodyPanel {
	MainPanel mainPanel;
	Image[] animes = new Image[121];
	MediaTracker tracker;
	int currentAnime = 0;
	AnimeThread at;
	AlphaDisappearThread adt;

	public StartUI(MainPanel mainPanel) {
		// TODO Auto-generated constructor stub
		this.mainPanel = mainPanel;
		init();
	}

	public void init() {
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);

		alpha = 1;
		at = new AnimeThread();
		adt = new AlphaDisappearThread();
		setup();
	}

	public void setup() {
		tracker = new MediaTracker(this);
		Toolkit toolkit = getToolkit();
		for (int i = 0; i < animes.length; i++) {
			animes[i] = toolkit.getImage("img/Starter/last-anime/end-3B-"
					+ i + ".jpg");
		}
		for (int i = 0; i < animes.length; i++) {
			tracker.addImage(animes[i], 0);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));
		
		g.drawImage(animes[currentAnime], 0, 0, null);
	}

	public class AnimeThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					repaint();
				}
			});
			try {
				tracker.waitForID(0);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (currentAnime < 120) {
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentAnime++;
			}
			adt.execute();
			mainPanel.starterUI.setVisible(true);
			mainPanel.starterUI.aat.execute();
		}
	}

}
