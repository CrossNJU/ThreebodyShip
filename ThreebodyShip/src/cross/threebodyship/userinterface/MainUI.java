package cross.threebodyship.userinterface;

import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cross.threebodyship.listener.MainChangeListener;
import cross.threebodyship.model.Selector;
import cross.threebodyship.model.Stage;
//import cross.threebodyship.userinterface.MainUIPre.NextStageButtonListener;

public class MainUI extends JFrame {
	public Component currentPane;
	public StarterUI starterPanel;
	public SelectorUI selectorPanel;
	public StageUI stagePanel;
	public final static int WIDTH = 1024-17;
	public final static int HEIGHT = 768-48;
	
	public void mainrun(){
		Selector selector = new Selector();
		
		setSize(1024,768);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		//初始化开始界面
		starterPanel = new StarterUI(this);
		//初始化选择界面
		selectorPanel = new SelectorUI(selector, this);
		
		
		starterPanel.startGameButton.addMouseListener(new MainChangeListener(this, selectorPanel));
		currentPane = starterPanel;
		
		//添加当前界面
		add(currentPane);
		repaint();
	}

//	@Override
//	public void update(Observable o, Object arg) {
//		String msg = (String) arg;
//        //WinGame之后
//		if (msg.equals("win")) {
//			System.out.println("To Next in Starter");
//			Stage stage = (Stage) o;
//			stagePanel.nextStageButton.addMouseListener(new MainChangeListener(this,stagePanel.afterPanel));
//		}
//	}
	
}