package cross.threebodyship.userinterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

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
		setBackground(Color.WHITE);
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
		stageTitle.addMouseListener(new StageStartButtonListener(stageUI,
				gamePanel));
		beforePanel.add(stageTitle);
		currentPane = beforePanel;
	}

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
		afterPanel.setBackground(Color.white);

		nextStageButton = new JButton("Next Stage >");
		nextStageButton.setBounds((int) (MainUI.WIDTH * 0.8),
				(int) (MainUI.HEIGHT * 0.45), 100, 100);
		nextStageButton.addMouseListener(new EnterStageButtonListener(mainUI,
				new Stage("二而生三", "Ch1-Stage1-Before.png",
						"Ch1-Stage1-After.png")));

		afterPanel.add(nextStageButton);
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
