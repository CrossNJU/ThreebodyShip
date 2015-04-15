package cross.threebodyship.userinterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
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

	public final static int WIDTH = 1024;
	public final static int HEIGHT = 768;
	
	public MainUI() {
		init();
	}
	
	public void init() {
        mainFrame = new JFrame("Threebody Ship");
        mainFrame.setLayout(null);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
        mainPanel.setBackground(Color.GREEN);
        
        selectorPanel = new SelectorUI();
		selectorPanel.stageButton.addActionListener(new StageButtonListener());
		selectorPanel.backButton.addActionListener(new BackToStarterButtonListener());
        
        starterPanel = new JPanel();
        starterPanel.setLayout(null);
        starterPanel.setBounds(20, 20, WIDTH, HEIGHT);
        starterPanel.setBackground(Color.ORANGE);
        
        JButton startButton = new JButton("Start");
        startButton.setBounds(10, 10, 200, 200);
        startButton.setBackground(Color.YELLOW);
        
        startButton.addActionListener(new StartButtonListener());
        starterPanel.add(startButton);
        mainPanel.add(starterPanel);
        
        mainFrame.add(mainPanel);
        //currentPanel = starterPanel;
        
        mainFrame.pack();
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
	}

	//切换显示Panel
	public void displayPanel(JPanel panel) {
		mainPanel.removeAll();
		mainPanel.add(panel);
		mainPanel.revalidate();
		mainPanel.repaint();
	}
	
	//显示Stage
	public void displayStage(Stage stage) {
		stagePanel = new StageUI(stage);
		stagePanel.backButton.addActionListener(new BackToSelectorButtonListener());
		stage.addObserver(stagePanel);
		stage.addObserver(this);
		displayPanel(stagePanel.beforePanel);
		stagePanel.startStageButton.addActionListener(new StartStageButtonListener(stage));
	}

	@Override
	public void update(Observable o, Object arg) {
		String msg = (String) arg;
        //WinGame之后
		if (msg.equals("win")) {
			System.out.println("To Next in Starter");
			Stage stage = (Stage) o;
			stagePanel.nextStageButton.addActionListener(new NextStageButtonListener(stage));
	        displayPanel(stagePanel.afterPanel);
		}
//		stagePanel.nextButton = new JButton("Next Stage >");
//		stagePanel.add(stagePanel.nextButton);
//		stagePanel.nextButton.addActionListener(new NextListener(stage));
//		stagePanel.revalidate();
//		stagePanel.repaint();
	}

	//ActionListerners内部类
	//写到独立的类之后，所有的addActionListener可以搬到相应的UI类里
	private class StartButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			displayPanel(selectorPanel);
		}
	}
	private class StageButtonListener implements ActionListener {
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
	private class BackToStarterButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			displayPanel(starterPanel);
		}
	}
	private class BackToSelectorButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			currentStage.leave();
			displayPanel(selectorPanel);
		}
	}
	private class NextStageButtonListener implements ActionListener {
		Stage stage;
		public NextStageButtonListener(Stage stage) {
			this.stage = stage;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
	        //这里需要取到下一个Stage的数据
	        //Stage nextStage = stage.nextStage;
	        //or currentStage = currentStage.nextStage;
	        Game game = new Game(720,480);
			Stage nextStage = new Stage("二而生三", "Ch1-Stage2-Before.png", "Ch1-Stage2-After.png", game);
			currentStage = stage;
			
			displayStage(nextStage);
		}
	}
	private class StartStageButtonListener implements ActionListener {
		Stage stage;
		public StartStageButtonListener(Stage stage) {
			this.stage = stage;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			displayPanel(stagePanel);
	        stagePanel.add(stagePanel.backButton);
			stage.startStage();
		}
	}
}