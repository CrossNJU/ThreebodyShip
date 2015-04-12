package cross.threebodyship.userinterface;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.jar.Attributes.Name;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.model.Game;
import cross.threebodyship.model.Stage;
import cross.threebodyship.transaction.GameController;

public class StageUI extends JPanel implements Observer {
	
	JButton backButton;
	JButton nextButton;
	GameUI gamePanel;
	
    Stage stage;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StageUI(Stage stage) {
		this.stage = stage;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel("This is a Stage" + stage.title);
		add(label);

        backButton = new JButton("Back to Selector");
        add(backButton);
        
		GameController gameController = new GameController(stage.game);
        gamePanel = new GameUI(stage.game, gameController);
        stage.game.addObserver(gamePanel);
		
        add(gamePanel);
		//(new Thread(stage.game)).start();
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("To Next");
	}
}
