package cross.threebodyship.userinterface;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.model.Stage;
import cross.threebodyship.transaction.GameController;

public class StageUI extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel beforePanel;	
	JPanel afterPanel;
	
	JButton backButton;
	JButton startStageButton;
	JButton nextStageButton;
	GameUI gamePanel;
	
    Stage stage;

	public StageUI(Stage stage) {
		this.stage = stage;
		
		setLayout(null);
        setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setBackground(Color.RED);
		
		JLabel label = new JLabel("This is a Stage" + stage.title);
		label.setBounds(0, 0, 300, 30);
		add(label);

        //Game部分
		GameController gameController = new GameController(stage.game);
        gamePanel = new GameUI(stage.game, 600,500);
        stage.game.addObserver(gamePanel);
        gamePanel.setSize(MainUI.WIDTH, MainUI.HEIGHT);
		gamePanel.setLocation(0, 0);
        add(gamePanel);
        
        //Game之前，显示章节内容（图片）
        beforePanel = new JPanel();
        beforePanel.setLayout(null);
        beforePanel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
        beforePanel.setBackground(Color.MAGENTA);
        startStageButton = new JButton("Start Stage");
		startStageButton.setBounds(0, 0, 100, 100);
		beforePanel.add(startStageButton);

        //按得了，但是显示不出来= =
        backButton = new JButton("Back to Selector");
        backButton.setBounds(0, 0, 100, 100);
        
        //Game之后，显示（图片）
        afterPanel = new JPanel();
        afterPanel.setLayout(null);
        afterPanel.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
        afterPanel.setBackground(Color.MAGENTA);
		nextStageButton = new JButton("Next Stage >");
		nextStageButton.setBounds(0, 0, 100, 100);
		afterPanel.add(nextStageButton);
	}

	@Override
	public void update(Observable o, Object arg) {
		//貌似目前不需通知StageUI只需通知MainUI更新即可
//		System.out.println("To Next");
//		String msg = (String) arg;
//		if (msg.equals("win")) {
//			System.out.println("win in StageUI");
//		}
	}
}
