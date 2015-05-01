package cross.threebodyship.userinterface;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cross.threebodyship.listener.DragMainUIListener;
import cross.threebodyship.listener.MainChangeListener;
import cross.threebodyship.model.Selector;
import cross.threebodyship.model.Stage;

//import cross.threebodyship.userinterface.MainUIPre.NextStageButtonListener;

public class MainUI extends JFrame {
	public Component currentPane;
	public StarterUI starterPanel;
	public SelectorUI selectorPanel;
	public StageUI stagePanel;
	public final static int WIDTH = 1024;
	public final static int HEIGHT = 768;
	
	public int oldX;
	public int oldY;
	public DragMainUIListener drag;

	public void mainrun() {
		Selector selector = new Selector();
		drag = new DragMainUIListener(this);

		setSize(1024, 768);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);

		//实现窗口拖拽
		addMouseListener(drag);
		addMouseMotionListener(drag);
		
		//添加鼠标
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image cur = new ImageIcon("img/Component/mouse@2x.png").getImage();
		Cursor cu = kit.createCustomCursor(cur, new Point(0,0),"stick");
		setCursor(cu);
		
		
		// 初始化开始界面
		starterPanel = new StarterUI(this);
		// 初始化选择界面
		selectorPanel = new SelectorUI(selector, this);

		starterPanel.startGameButton.addMouseListener(new MainChangeListener(
				this, selectorPanel));
		currentPane = starterPanel;

		// 添加当前界面
		add(currentPane);
		repaint();
	}

}