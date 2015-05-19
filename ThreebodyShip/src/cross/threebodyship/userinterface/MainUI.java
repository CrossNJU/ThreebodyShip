package cross.threebodyship.userinterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.SwingWorker;

import cross.threebodyship.listener.DragMainUIListener;
import cross.threebodyship.listener.MainChangeListener;
import cross.threebodyship.listener.OpaqueDisplayListener;
import cross.threebodyship.model.Selector;
import cross.threebodyship.model.Stage;


//import cross.threebodyship.userinterface.MainUIPre.NextStageButtonListener;

public class MainUI extends JFrame {
	public MainPanel mainPanel;
	public Component currentPane;
	public StageUI stagePanel;
	public final static int WIDTH = 1024;
	public final static int HEIGHT = 768;
	
//	Container contentPane;
	
	public int oldX;
	public int oldY;
	public DragMainUIListener drag;

	public void mainrun() {
		drag = new DragMainUIListener(this);
		

		setSize(1024, 768);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		setBackground(null);

		
		//实现窗口拖拽
		addMouseListener(drag);
		addMouseMotionListener(drag);
		
		//添加鼠标
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image cur = new ImageIcon("img/Component/mouse@2x.png").getImage();
		Cursor cu = kit.createCustomCursor(cur, new Point(0,0),"stick");
		setCursor(cu);
		
		//窗口居中显示
		Toolkit kit2 = Toolkit.getDefaultToolkit(); // 定义工具包 
		Dimension screenSize = kit2.getScreenSize(); // 获取屏幕的尺寸 
		int screenWidth = screenSize.width/2; // 获取屏幕的宽
		int screenHeight = screenSize.height/2; // 获取屏幕的高
		int height = this.getHeight(); 
		int width = this.getWidth(); 
		setLocation(screenWidth-width/2, screenHeight-height/2);
		
		mainPanel = new MainPanel(this);
		mainPanel.setBounds(0,0,MainUI.WIDTH,MainUI.HEIGHT);
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		
		currentPane = mainPanel;
		
		MusicPlayer mainMusic = new MusicPlayer("music/The Crisis.wav");
		mainMusic.start();
		// 添加当前界面
		add(mainPanel);
		repaint();
	}

}