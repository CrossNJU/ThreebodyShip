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

	public StageUI(MainUI mainUI,Stage stage) {
		this.stage = stage;
		this.mainUI = mainUI;
		stage.addObserver(this);
		
		setLayout(null);
        setBounds(0, 0, 1024, 768);
		setBackground(Color.RED);
		setVisible(true);
		JLabel label = new JLabel("This is a Stage" + stage.title);
		label.setBounds(0, 0, 300, 30);
		add(label);

        //Game部分
		GameController gameController = new GameController(stage.game);
        gamePanel = new GameUI(stage.game, 600,500);
        stage.game.addObserver(gamePanel);
        gamePanel.setSize(MainUI.WIDTH, MainUI.HEIGHT);
		gamePanel.setLocation(0, 0);
//        add(gamePanel);
        
        //Game之前，显示章节内容（图片）
        beforePanel = new JPanel();
        beforePanel.setLayout(null);
        beforePanel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
        beforePanel.setBackground(Color.MAGENTA);
        
        startStageButton = new JButton("Start Stage");
		startStageButton.setBounds(0, 0, 100, 100);
		startStageButton.addMouseListener(new StageStartButtonListener(this, gamePanel));
		beforePanel.add(startStageButton);
		currentPane = beforePanel;
		

        //按得了，但是显示不出来= =
        backButton = new JButton("Back to Selector");
        backButton.setBounds(0, 0, 100, 100);
        
        //Game之后，显示（图片）
        afterPanel = new JPanel();
        afterPanel.setLayout(null);
        afterPanel.setBounds(0, 0, MainUIPre.WIDTH, MainUIPre.HEIGHT);
        afterPanel.setBackground(Color.MAGENTA);
		nextStageButton = new JButton("Next Stage >");
		nextStageButton.setBounds(0, 0, 100, 100);
		nextStageButton.addMouseListener(new EnterStageButtonListener(mainUI, stage));
		afterPanel.add(nextStageButton);
		
		//stage.startStage();
		add(currentPane);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		String msg = (String) arg;
        //WinGame之后
		if (msg.equals("win")) {
			System.out.println("To Next in Starter");
			Stage stage = (Stage) o;
			DisplayPanel.stageDisplay(this, afterPanel);
		}
	}
}
