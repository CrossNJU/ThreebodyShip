package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.MediaTracker;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import javax.imageio.ImageIO;
import javax.sound.midi.Track;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.ViewportLayout;
import javax.xml.bind.attachment.AttachmentMarshaller;

import org.omg.CORBA.ULongLongSeqHelper;

import cross.threebodyship.listener.ModeButtonListener;
import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.ScrollListener;
import cross.threebodyship.model.Mode;
import cross.threebodyship.model.Selector;
import cross.threebodyship.model.Stage;
import cross.threebodyship.util.RotateImage;

public class SelectorUI extends ThreebodyPanel {
	int frameWidth;
	int frameHeight;
	Selector selector = null;
	MainPanel mainPanel = null;
	ArrayList<JButton> modeButton = new ArrayList<JButton>();
	ArrayList<Component> modePane = new ArrayList<Component>();
	public Component currentPane = null;// 存放当前的PANEL
	
	int degree = 0;
	
	Image[] shine = new Image[100];
	int currentShine = 0;
	boolean isSetup = false;
	MediaTracker tracker = null;
	int bgX = 0;
	
	ShineAnimeThread sat = null;
	
	BufferedImage ship;

	public SelectorUI(Selector selector, MainPanel mainPanel) {
		this.frameHeight = MainUI.HEIGHT;
		this.frameWidth = MainUI.WIDTH;
		this.selector = selector;
		this.mainPanel = mainPanel;
		
		init();
	}

	// 生成新的选择界面
	public void init() {
		alpha = 0f;
//		delay = 10;
		// 选择界面初始化
		setSize(frameWidth, frameHeight);
		setLayout(null);
		setVisible(true);
		setBackground(null);
		setOpaque(false);
		
		// 将Selector中的按钮与模式添加到UI中
		setModeButton();
		setModePanel();
		
		// 加入模式按钮
		for (int i = 0; i < modeButton.size(); i++) {
			modeButton.get(i).setBounds((int) (frameWidth * 0.05),
					(int) (frameHeight * 0.2 * (i + 1)), 276, 67);
			modeButton.get(i).setVisible(true);
			modeButton.get(i).addMouseListener(
					new ModeButtonListener(this, modePane.get(i)));
			add(modeButton.get(i));
		}
		
		// 加入模式界面
		for (int i = 0; i < modePane.size(); i++) {
			modePane.get(i).setLocation((int) (frameWidth * 0.3), 0);
			modePane.get(i).setVisible(true);
			if (i == 0) {
				currentPane = modePane.get(i);
				add(currentPane);
			}
		}
		
		sat = new ShineAnimeThread();
		setupShineImg();
		sat.execute();

	}
	
	// 设置模式按钮
	public void setModeButton() {
		for (Mode mode : selector.mode) {
			JButton modeButton = new JButton(mode.modeName);
			switch (mode.modeType) {
			case 1:
				modeButton.setIcon(new ImageIcon(
						"img/Selector/btn-mode-story-normal.png"));
				modeButton.setRolloverIcon(new ImageIcon(
						"img/Selector/btn-mode-story-hover.png"));
				break;
			case 2:
				modeButton.setIcon(new ImageIcon(
						"img/Selector/btn-mode-challenges-normal.png"));
				modeButton.setRolloverIcon(new ImageIcon(
						"img/Selector/btn-mode-challenges-hover.png"));
				break;
			case 3:
				modeButton.setIcon(new ImageIcon(
						"img/Selector/btn-mode-achievements-normal.png"));
				modeButton.setRolloverIcon(new ImageIcon(
						"img/Selector/btn-mode-achievements-hover.png"));
				break;
			case 4:
				modeButton.setIcon(new ImageIcon(
						"img/Selector/btn-mode-settings-normal.png"));
				modeButton.setRolloverIcon(new ImageIcon(
						"img/Selector/btn-mode-settings-hover.png"));
				break;
			default:
				break;
			}
			modeButton.setContentAreaFilled(false);
			modeButton.setBorderPainted(false);
			modeButton.setFocusPainted(false);
			this.modeButton.add(modeButton);
		}
	}
	
	// 设置模式界面
	public void setModePanel() {
		modePane.add(new StoryUI(this));
		modePane.add(new ChallengeUI(this));
		modePane.add(new AchievementUI(this));
		modePane.add(new SettingUI(this));
	}
	
	//载入闪烁的图片
	public void setupShineImg(){
		tracker = new MediaTracker(this);
		Toolkit toolkit = getToolkit();
		for(int i = 0; i < 50; i++){
			shine[i] = toolkit.getImage("img/Selector/shine/bg-selector-shine-" + (i+38) + ".png");
		}
		for(int i = 50 ; i<100; i++){
			shine[i] = toolkit.getImage("img/Selector/shine/bg-selector-shine-" + (138-i) + ".png");
		}
		
		for(int i = 0; i<shine.length;i++){
			tracker.addImage(shine[i], 0);
		}
	}

	public void paintComponent(Graphics g) {
		//绘制透明度
		Graphics2D g2d = (Graphics2D) g;  
        g2d.setComposite(AlphaComposite.getInstance(  
                AlphaComposite.SRC_OVER, alpha));  
//        
//		Image B_img = new ImageIcon("img/GameBackground/bg.jpg").getImage();
//		g.drawImage(B_img, 0, 0, MainUI.WIDTH, MainUI.HEIGHT, 0+bgX, 0, 1024+bgX, 768, null);
		
		Image shineFirst = new ImageIcon("img/Selector/shine/bg-selector-shine-64.png").getImage();
		g.drawImage(shineFirst, 0, 0, null);
		
		g.drawImage(shine[currentShine], 0, 0, null);
		
		Image star = new ImageIcon("img/Selector/menu.png").getImage();
		g.drawImage(star, 0,0,337,768,null);
		
		g2d.drawImage(ship, 0, 0, 100,100,null);

	}

	
	
	//闪烁的动画线程
	class ShineAnimeThread extends SwingWorker<Boolean, Boolean>{
		@Override
		protected Boolean doInBackground() throws Exception {
			// TODO Auto-generated method stub
			try {
				tracker.waitForID(0);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			while(true){
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						repaint();						
					}
				});
				
				try {
					Thread.sleep(60);
				} catch (Exception e) {
					// TODO: handle exception
				}		
				currentShine++;
				bgX++;
				currentShine%=shine.length;
				bgX%=1669-1024;	
//				System.out.println(SwingUtilities.isEventDispatchThread());
			}
//			return null;
		}

	}
	

	
	
}
