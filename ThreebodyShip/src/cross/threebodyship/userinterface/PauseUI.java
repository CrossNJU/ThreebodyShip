package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.PanelUI;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.MainChangeListener;
import cross.threebodyship.listener.OpaqueDisplayListener;
import cross.threebodyship.listener.ResumeButtonListener;

public class PauseUI extends ThreebodyPanel {
	JButton restartButton = new JButton();
	JButton resumeButton = new JButton();
	JButton menuButton = new JButton();

	StageUI stageUI = null;

	public PauseUI(StageUI stageUI) {
		this.stageUI = stageUI;
		initPauseUI();
	}

	public void initPauseUI() {
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);
		setBackground(null);

		setButton(menuButton, "menu");
		menuButton.setBounds(289, 322, 99, 99);
		menuButton.addMouseListener(new OpaqueDisplayListener(stageUI.mainPanel,
				stageUI.mainPanel.selectorUI));

		setButton(resumeButton, "resume");
		resumeButton.setBounds(403, 277, 190, 190);
		resumeButton.addMouseListener(new ResumeButtonListener(stageUI.gamePanel, this));

		setButton(restartButton, "restart");
		restartButton.setBounds(600, 322, 99, 99);
		restartButton.addMouseListener(new EnterStageButtonListener(
				stageUI.mainPanel, stageUI.stage));

		add(resumeButton);
		add(restartButton);
		add(menuButton);

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));

		Image img = new ImageIcon("img/GameBackground/cover-40.png").getImage();

		g.drawImage(img, 0, 0, null);
	}

	public void setButton(JButton button, String btnName) {
		button.setIcon(new ImageIcon("img/Button/btn-" + btnName
				+ "-normal.png"));
		button.setRolloverIcon(new ImageIcon("img/Button/btn-" + btnName
				+ "-hover.png"));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
	}
}
