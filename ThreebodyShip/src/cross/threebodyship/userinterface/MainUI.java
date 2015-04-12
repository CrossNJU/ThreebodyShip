package cross.threebodyship.userinterface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.model.Game;
import cross.threebodyship.model.Stage;

public class MainUI implements Observer {
	Stage currentStage;
	
	JFrame mainFrame;
	JPanel mainPanel;
	JPanel currentPanel;
	
	JPanel starterPanel;
	SelectorUI selectorPanel;
	StageUI stagePanel;
	
	public MainUI() {
		init();
	}
	
	public void init() {
        mainFrame = new JFrame("Threebody Ship");
        mainPanel = new JPanel();
        
        selectorPanel = new SelectorUI();
		selectorPanel.stageButton.addActionListener(new StageListener());
		selectorPanel.backButton.addActionListener(new BackToStarterListener());
        
        starterPanel = new JPanel();
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartListener());
        starterPanel.add(BorderLayout.CENTER, startButton);
        mainPanel.add(starterPanel, BorderLayout.NORTH);
        
        mainFrame.add(mainPanel);
        //currentPanel = starterPanel;
        
        //mainFrame.addKeyListener(starterController);
        mainFrame.pack();
        mainFrame.setSize(1024, 768);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
	}
	
	private class StartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			displayPanel(selectorPanel);
		}
	}
	private class StageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//后期移到Selector的run()里
			//game和stage从selector里取
	        Game game = new Game(720,480);
			Stage stage = new Stage("一而生二", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png", game);
			currentStage = stage;
			displayStage(stage);
		}
	}
	private class BackToStarterListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			displayPanel(starterPanel);
		}
	}
	private class BackToSelectorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			currentStage.leave();
			displayPanel(selectorPanel);
		}
	}
	private class NextListener implements ActionListener {
		Stage stage;
		public NextListener(Stage stage) {
			this.stage = stage;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
	        Game game = new Game(720,480);
	        //Stage nextStage = stage.nextStage;
	        //or currentStage = currentStage.nextStage;
			Stage nextStage = new Stage("二而生三", "Ch1-Stage2-Before.png", "Ch1-Stage2-After.png", game);
			currentStage = stage;
			
			displayStage(nextStage);
		}
	}
	
	public void displayStage(Stage stage) {
		
		stagePanel = new StageUI(stage);
		stagePanel.backButton.addActionListener(new BackToSelectorListener());
		stage.addObserver(stagePanel);
		stage.addObserver(this);
		displayPanel(stagePanel);
	}
	public void displayPanel(JPanel panel) {
		mainPanel.removeAll();
		mainPanel.add(panel);
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Stage stage = (Stage) o;

		System.out.println("To Next in Starter");
		stagePanel.nextButton = new JButton("Next Stage >");
		stagePanel.add(stagePanel.nextButton);
		stagePanel.nextButton.addActionListener(new NextListener(stage));
		stagePanel.revalidate();
		stagePanel.repaint();
	}
}