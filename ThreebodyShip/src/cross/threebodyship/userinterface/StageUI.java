package cross.threebodyship.userinterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.MainChangeListener;
import cross.threebodyship.listener.StageButtonListener;
import cross.threebodyship.listener.StageStartButtonListener;
import cross.threebodyship.model.Stage;
import cross.threebodyship.transaction.GameController;
import cross.threebodyship.util.DisplayPanel;

public class StageUI extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component currentPane;
	JPanel beforePanel;
	JPanel winPanel;
	JPanel failPanel;
	JPanel pausePanel;
	 StopUI stopPanel = new StopUI();
	// FailUI failPane;

	JButton backButton;
	JButton startStageButton;
	JButton nextStageButton;
	public GameUI gamePanel;
	MainUI mainUI;

	public Stage stage;

	public StageUI(MainUI mainUI, Stage stage) {
		this.stage = stage;
		this.mainUI = mainUI;
		stage.addObserver(this);

		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setBackground(Color.BLUE);// ////////////////////
		setVisible(true);

		// Game部分
		initGamePanel(this);

		// Game之前，显示章节内容（图片）
		initBeforePanel(this);

		// Game之后，显示（图片）
		initWinPanel(this);

		initFailPanel(this);
		
		initPausePanel(this);

		add(currentPane);

	}

	public void initBeforePanel(StageUI stageUI) {
		beforePanel = new JPanel();
		beforePanel.setLayout(null);
		beforePanel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		beforePanel.setBackground(Color.WHITE);

		JLabel stageTitle = new JLabel(stage.title);
		stageTitle.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		stageTitle.setIcon(new ImageIcon(
				"img/GameBackground/bg-stage1-before.png"));
		stageTitle.setVisible(true);
		stageTitle.addMouseListener(new StageStartButtonListener(stageUI,
				gamePanel));
		beforePanel.add(stageTitle);
		currentPane = beforePanel;
	}// /这里要改
		// cover改成stage名。。?
		//
		//

	public void initGamePanel(StageUI stageUI) {
		GameController gameController = new GameController(stage.game);
		gamePanel = new GameUI(stage.game, MainUI.WIDTH, MainUI.HEIGHT);
		stage.game.addObserver(gamePanel);
		gamePanel.setSize(MainUI.WIDTH, MainUI.HEIGHT);
		gamePanel.setLocation(0, 0);
	}

	public void initWinPanel(StageUI stageUI) {
		winPanel = new JPanel();
		winPanel.setLayout(null);
		winPanel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		// afterPanel.setBackground(Color.WHITE);
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(
				"img/GameBackground/bg-stage"+stage.num+"-after.png"));
		backLabel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		backLabel.setVisible(true);
		//

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
		nextStageButton.addMouseListener(new EnterStageButtonListener(mainUI,
				stage.nextStage));

		winPanel.add(nextStageButton);
		winPanel.add(backLabel);
	}

	public void initFailPanel(StageUI stageUI) {
		// 界面背景的初始化
		failPanel = new JPanel();
		failPanel.setLayout(null);
		failPanel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		failPanel.setOpaque(false);
		failPanel.setBackground(null);
		
		
		JLabel failLabel = new JLabel();
		failLabel.setIcon(new ImageIcon("img/GameBackground/cover-40.png"));
		failLabel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		failLabel.setVisible(true);
		failLabel.setOpaque(false);
		failLabel.setBackground(null);
		failPanel.add(failLabel);

		// 菜单按钮和重新按钮的初始化
		JButton menuButton = new JButton();
		JButton restartButton = new JButton();

		setButton(menuButton, "menu");
		menuButton.setBounds((int) (MainUI.WIDTH * 0.532),
				(int) (MainUI.HEIGHT * 0.437), 99, 99);
		menuButton.addMouseListener(new MainChangeListener(mainUI, mainUI.selectorPanel));
		
		setButton(restartButton, "restart");
		restartButton.setBounds((int) (MainUI.WIDTH - 339),
				(int) (MainUI.HEIGHT * 0.437), 99, 99);
		restartButton.addMouseListener(new EnterStageButtonListener(mainUI, stage));

		failPanel.add(menuButton);
		failPanel.add(restartButton);
	}

	public void initPausePanel(StageUI stageUI) {
		// 界面背景的初始化
		pausePanel = new JPanel();
		pausePanel.setLayout(null);
		pausePanel.setVisible(true);
		pausePanel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);

		JLabel pauseLabel = new JLabel();
		pauseLabel.setIcon(new ImageIcon("img/GameBackground/cover-40.png"));
		pauseLabel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		pauseLabel.setVisible(true);
		pausePanel.add(pauseLabel);

		// 菜单按钮和重新按钮的初始化
		JButton menuButton = new JButton();
		JButton restartButton = new JButton();
		JButton resumeButton = new JButton();
		
		setButton(menuButton, "menu");
		menuButton.setBounds((int)(MainUI.WIDTH*0.532),(int)(MainUI.HEIGHT*0.437) , 99, 99);
		menuButton.addMouseListener(new MainChangeListener(mainUI, mainUI.selectorPanel));
		
		setButton(resumeButton,"resume");
		resumeButton.setBounds((int)(MainUI.WIDTH*0.5-95),(int)(MainUI.HEIGHT*0.5-95),190,190);
		
		setButton(restartButton, "restart");
		restartButton.setBounds(MainUI.WIDTH-339, (int)(MainUI.HEIGHT*0.437), 99, 99);
		restartButton.addMouseListener(new EnterStageButtonListener(mainUI, stage));
		
		pausePanel.add(menuButton);
		pausePanel.add(resumeButton);
		pausePanel.add(restartButton);
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

	@Override
	public void update(Observable o, Object arg) {
		String msg = (String) arg;
		// WinGame之后
		if (msg.equals("win")) {
			System.out.println("To Next in Starter");
			Stage stage = (Stage) o;
			DisplayPanel.stageDisplay(this, winPanel);
		}

		if (msg.equals("fail")) {
			mainUI.repaint();
			gamePanel.repaintMain();
		}
	}
}
