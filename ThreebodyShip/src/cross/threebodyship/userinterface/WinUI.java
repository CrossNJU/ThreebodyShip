package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.plaf.synth.SynthSpinnerUI;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.OpaqueDisplayListener;
import cross.threebodyship.userinterface.ThreebodyPanel.AlphaAnimeThread;
import cross.threebodyship.util.RotateImage;

public class WinUI extends ThreebodyPanel {
	JButton nextStageButton;
	JButton restartButton;
	JButton menuButton;
	StageUI stageUI = null;
	public AchieveAfterUI achieveAfterUI;
	public SkillUI skillUI;
	public ChallengeAfterUI challengeAfterUI;
	CoverPanel coverPanel;

	WinAlphaAnimeThread waat;
	CompleteAnimeThread cat;

	Image[] completeAnime = new Image[72];
	MediaTracker tracker = null;
	int currentAnime = 0;

	public WinUI(StageUI stageUI) {
		this.stageUI = stageUI;
		initWinUI();
	}

	public void initWinUI() {
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);

		achieveAfterUI = new AchieveAfterUI(this);
		achieveAfterUI.setVisible(false);
		skillUI = new SkillUI(this);
		skillUI.setVisible(false);
		challengeAfterUI = new ChallengeAfterUI(this);
		challengeAfterUI.setVisible(false);
		coverPanel = new CoverPanel();
		if(stageUI.stage.num%3!=0||stageUI.stage.num==21){
			coverPanel.setVisible(false);
		}else {
			coverPanel.alpha=1;
			coverPanel.setVisible(true);
		}

		add(achieveAfterUI);
		add(skillUI);
		add(challengeAfterUI);
		add(coverPanel);

		nextStageButton = new JButton("Next Stage >");
		if(stageUI.stage.num<19){
			nextStageButton.setBounds((int) (MainUI.WIDTH * 0.75),
					(int) (MainUI.HEIGHT * 0.40), 142, 142);
		}else {
			nextStageButton.setBounds((int) (MainUI.WIDTH * 0.75)+75,
					(int) (MainUI.HEIGHT * 0.40), 142, 142);
		}
		nextStageButton.setIcon(new ImageIcon(
				"img/Button/btn-nextstage-normal.png"));
		nextStageButton.setRolloverIcon(new ImageIcon(
				"img/Button/btn-nextstage-hover.png"));
		nextStageButton.setContentAreaFilled(false);
		nextStageButton.setBorderPainted(false);
		nextStageButton.setFocusPainted(false);
		if((stageUI.stage.num!=21)&&(stageUI.stage.num!=18)){
			nextStageButton.addMouseListener(new EnterStageButtonListener(
					stageUI.mainPanel, stageUI.stage.nextStage));
			add(nextStageButton);
		}
		

		restartButton = new JButton();
		restartButton.setBounds(940, 697, 53, 53);
		restartButton.setIcon(new ImageIcon(
				"img/Button/btn-restartS-normal.png"));
		restartButton.setRolloverIcon(new ImageIcon(
				"img/Button/btn-restartS-hover.png"));
		restartButton.setContentAreaFilled(false);
		restartButton.setBorderPainted(false);
		restartButton.setFocusPainted(false);
		restartButton.addMouseListener(new EnterStageButtonListener(
				stageUI.mainPanel, stageUI.stage));
		add(restartButton);

		menuButton = new JButton();
		menuButton.setBounds(883, 697, 53, 53);
		menuButton.setIcon(new ImageIcon("img/Button/btn-menuS-normal.png"));
		menuButton.setRolloverIcon(new ImageIcon(
				"img/Button/btn-menuS-hover.png"));
		menuButton.setContentAreaFilled(false);
		menuButton.setBorderPainted(false);
		menuButton.setFocusPainted(false);
		menuButton.addMouseListener(new OpaqueDisplayListener(
				stageUI.mainPanel, stageUI.mainPanel.selectorUI));
		add(menuButton);

		waat = new WinAlphaAnimeThread();
		cat = new CompleteAnimeThread();
		setup();

		// 更新记录数据
		// System.out.println(stageUI.mainPanel.num);
		if (stageUI.mainPanel.num < stageUI.stage.game.gameNumber)
			stageUI.mainPanel.num = stageUI.stage.game.gameNumber;
		// System.out.println(stageUI.mainPanel.num);

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File("data.txt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.write(String.valueOf(stageUI.mainPanel.num));
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));

		Image cover = new ImageIcon("img/Win/cover-after.png").getImage();
		Image word = new ImageIcon("img/Win/chapAfter/stage"
				+ stageUI.stage.num + "-after.png").getImage();
		Image sentence = new ImageIcon("img/Win/chapAfter/stage"
				+ stageUI.stage.num + "-after-sentence.png").getImage();
		Image challenge = new ImageIcon("img/Win/chapAfter/stage"
				+ stageUI.stage.num + ".png").getImage();

		g.drawImage(cover, 0, 0, null);
		if(stageUI.stage.num<=18){
		g.drawImage(completeAnime[currentAnime], 297, 308, 450, 99, null);
		g.drawImage(word, 409, 281, null);
		g.drawImage(sentence, 325, 410, null);
		}else{
			g.drawImage(challenge, 0, 0, null);
		}
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
			if((stageUI.stage.num%3==0)&&(stageUI.stage.num<19)){
				while((coverPanel.alpha<=1)&&(coverPanel.alpha>0)){
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						coverPanel.repaint();
					}
				});
				try {
					Thread.sleep(coverPanel.delay);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if(coverPanel.alpha>0.01){
					coverPanel.alpha = coverPanel.alpha - 0.01f;
				}
				else {
					coverPanel.alpha = 0f;
				}
			}
			coverPanel.setVisible(false);
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
			if (stageUI.stage.num % 3 == 0) {
				achieveAfterUI.setVisible(true);
				achieveAfterUI.aat.execute();
			} else {
				cat.execute();
			}
			waat = new WinAlphaAnimeThread();
		}
	}

}
