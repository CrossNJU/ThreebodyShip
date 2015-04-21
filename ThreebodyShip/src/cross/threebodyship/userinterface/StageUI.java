package cross.threebodyship.userinterface;

import java.awt.Color;
import java.awt.Component;
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

import cross.threebodyship.listener.EnterStageButtonListener;
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
	JPanel afterPanel;

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
		setBackground(Color.BLUE);//////////////////////
		setVisible(true);

		// Game部分
		initGamePanel(this);

		// Game之前，显示章节内容（图片）
		initBeforePanel(this);

		// Game之后，显示（图片）
		initAfterPanel(this);

		// stage.startStage();
		add(currentPane);

	}

	public void initBeforePanel(StageUI stageUI) {
		beforePanel = new JPanel();
		beforePanel.setLayout(null);
		beforePanel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		beforePanel.setBackground(Color.WHITE);

		JLabel stageTitle = new JLabel(stage.title);
		stageTitle.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		stageTitle.setIcon(new ImageIcon("img/GameBackground/cover-chap01-stage01-before.png"));
		stageTitle.setVisible(true);
		stageTitle.addMouseListener(new StageStartButtonListener(stageUI,
				gamePanel));
		beforePanel.add(stageTitle);
		currentPane = beforePanel;
	}///这里要改
	//cover改成stage名。。?
	//
	//

	public void initGamePanel(StageUI stageUI) {
		GameController gameController = new GameController(stage.game);
		gamePanel = new GameUI(stage.game, MainUI.WIDTH, MainUI.HEIGHT);
		stage.game.addObserver(gamePanel);
		gamePanel.setSize(MainUI.WIDTH, MainUI.HEIGHT);
		gamePanel.setLocation(0, 0);
	}

	public void initAfterPanel(StageUI stageUI) {
		afterPanel = new JPanel();
		afterPanel.setLayout(null);
		afterPanel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		//afterPanel.setBackground(Color.WHITE);
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon("img/GameBackground/cover-chap01-stage01-after.png"));
		backLabel.setBounds(0, 0,  MainUI.WIDTH, MainUI.HEIGHT);
		backLabel.setVisible(true);
		
		//
		
		nextStageButton = new JButton("Next Stage >");
		nextStageButton.setBounds((int) (MainUI.WIDTH * 0.8),
				(int) (MainUI.HEIGHT * 0.45), 142, 142);
		nextStageButton.setIcon(new ImageIcon("img/Button/btn-nextstage-normal.png"));
		nextStageButton.setRolloverIcon(new ImageIcon("img/Button/btn-nextstage-hover.png"));
		nextStageButton.setContentAreaFilled(false);
		nextStageButton.setBorderPainted(false);
		nextStageButton.setFocusPainted(false);
		nextStageButton.addMouseListener(new EnterStageButtonListener(mainUI,
				stage.nextStage));
		
		
		afterPanel.add(nextStageButton);
		afterPanel.add(backLabel);
	}

	@Override
	public void update(Observable o, Object arg) {
		String msg = (String) arg;
		// WinGame之后
		if (msg.equals("win")) {
			System.out.println("To Next in Starter");
			Stage stage = (Stage) o;
			DisplayPanel.stageDisplay(this, afterPanel);
		}
	}
}
