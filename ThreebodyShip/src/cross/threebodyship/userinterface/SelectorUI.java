package cross.threebodyship.userinterface;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ViewportLayout;

import cross.threebodyship.listener.ModeButtonListener;
import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.model.Mode;
import cross.threebodyship.model.Selector;
import cross.threebodyship.model.Stage;

public class SelectorUI extends JPanel {
	int frameWidth;
	int frameHeight;
	Selector selector = null;
	MainUI mainUI = null;
	ArrayList<JButton> modeButton = new ArrayList<JButton>();
	ArrayList<Component> modePane = new ArrayList<Component>();
	public Component currentPane = null;// 存放当前的PANEL

	public SelectorUI(Selector selector, MainUI mainUI) {
		this.mainUI = mainUI;
		this.frameHeight = MainUI.HEIGHT;
		this.frameWidth = mainUI.WIDTH;
		this.selector = selector;

		// 选择界面初始化
		setSize(frameWidth, frameHeight);
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);
		newSelectorUI();
	}
	
	public void paintComponent(Graphics g) {
		Image SB_img = new ImageIcon("img/GameBackground/bg-selector.png").getImage();
		g.drawImage(SB_img,0,0,MainUI.WIDTH,MainUI.HEIGHT,0,0,1024,768,null);
	}

	// 生成新的选择界面
	public void newSelectorUI() {
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

	}

	// 设置模式按钮
	public void setModeButton() {
		for (Mode mode : selector.mode) {
			JButton modeButton = new JButton(mode.modeName);
			switch (mode.modeType) {
			case 1:
				modeButton.setIcon(new ImageIcon("img/Selector/btn-mode-story-normal.png"));
				modeButton.setRolloverIcon(new ImageIcon("img/Selector/btn-mode-story-hover.png"));
				break;
			case 2:
				modeButton.setIcon(new ImageIcon("img/Selector/btn-mode-challenges-normal.png"));
				modeButton.setRolloverIcon(new ImageIcon("img/Selector/btn-mode-challenges-hover.png"));
				break;
			case 3:
				modeButton.setIcon(new ImageIcon("img/Selector/btn-mode-achievements-normal.png"));
				modeButton.setRolloverIcon(new ImageIcon("img/Selector/btn-mode-achievements-hover.png"));
				break;
			case 4:
				modeButton.setIcon(new ImageIcon("img/Selector/btn-mode-settings-normal.png"));
				modeButton.setRolloverIcon(new ImageIcon("img/Selector/btn-mode-settings-hover.png"));
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
		modePane.add(new StoryPane(selector.mode.get(0)));
		modePane.add(new ChallengePanel(frameWidth, frameHeight));
		modePane.add(new AchievementPanel(frameWidth, frameHeight));
		modePane.add(new SettingPanel(frameWidth, frameHeight));
	}

	// 模式界面设计
	// 故事界面
	class StoryPane extends JScrollPane {
		int panelWidth;
		int panelHeight;

		public StoryPane(Mode mode) {
			panelWidth = (int) (frameWidth * 0.7);
			panelHeight = frameHeight;
			setSize(panelWidth, panelHeight);
			setOpaque(false);
			setBackground(null);
			getViewport().setOpaque(false);
			getViewport().setBackground(null);
		
			
			//
			JPanel StoryPanel = new JPanel();
			StoryPanel.setPreferredSize(new Dimension(getViewport().getWidth(),
					panelHeight * 3));
			StoryPanel.setLayout(null);
			StoryPanel.setBackground(null);
			StoryPanel.setOpaque(false);
			

			// 添加章节文本与关卡按钮
			// int i = 1;
			// int j = 1;
			// for (Chap chap : selector.chap) {
			// c
			// for (Stage stage : chap.stage) {
			// JButton stageButton = new JButton(stage.title);
			//
			// stageButton.setBounds((int) (panelWidth * 0.2) * j,
			// (int) (panelHeight * 0.2) * i + 60, 100, 40);
			// stageButton.setVisible(true);
			// stageButton
			// .addMouseListener(new EnterStageButtonListener(mainUI,stage));
			//
			// StoryPanel.add(stageButton);
			//
			// j++;
			// }
			//
			// i++;
			// j = 1;
			// }

			//num表示的是关卡数，i表示的是章节数，j表示每个章节的第几关
			int num = 0;
			for (int i = 0; i < mode.chap.length; i++) {
				JLabel chapLabel = new JLabel(mode.chap[i]);

				chapLabel.setBounds((int) (panelWidth * 0.2),
						(int) (panelHeight * 0.3) * (i+1), 100, 40);
				chapLabel.setForeground(Color.BLACK);
				chapLabel.setVisible(true);
				StoryPanel.add(chapLabel);

				for (int j = 0; j < 3; j++) {
					if (i == mode.stages.size()) {
						break;
					}
					JButton stageButton = new JButton(
							mode.stages.get(num).title);

					stageButton.setBounds((int) (panelWidth * 0.2) * (j+1),
							(int) (panelHeight * 0.3) * (i+1) + 60, 154, 154);
					stageButton.setVisible(true);
					stageButton.addMouseListener(new EnterStageButtonListener(
							mainUI, mode.stages.get(num)));
					
					String imageString = "img/Button/btn-chap01"  + "-stage0" + (num+1) + "-normal.png";
					String imageHoverString = "img/Button/btn-chap01"  + "-stage0" + (num+1) + "-hover.png";
					ImageIcon image = new ImageIcon(imageString);
					ImageIcon imageHover = new ImageIcon(imageHoverString);
					
					stageButton.setIcon(image);
					stageButton.setRolloverIcon(imageHover);
					stageButton.setContentAreaFilled(false);
					stageButton.setBorderPainted(false);
					stageButton.setFocusPainted(false);
					

					StoryPanel.add(stageButton);
					num++;
				}
			}

			getViewport().add(StoryPanel);
		}
	}

	class ChallengePanel extends JPanel {
		int panelWidth;
		int panelHeight;

		public ChallengePanel(int frameWidth, int frameHeight) {
			panelWidth = (int) (frameWidth * 0.7);
			panelHeight = frameHeight;
			setSize(panelWidth, panelHeight);
			setOpaque(false);
			setBackground(null);		}
	}

	class AchievementPanel extends JPanel {
		int panelWidth;
		int panelHeight;

		public AchievementPanel(int frameWidth, int frameHeight) {
			panelWidth = (int) (frameWidth * 0.7);
			panelHeight = frameHeight;
			setSize(panelWidth, panelHeight);
			setOpaque(false);
			setBackground(null);		}
	}

	class SettingPanel extends JPanel {
		int panelWidth;
		int panelHeight;

		public SettingPanel(int frameWidth, int frameHeight) {
			panelWidth = (int) (frameWidth * 0.7);
			panelHeight = frameHeight;
			setSize(panelWidth, panelHeight);
			setOpaque(false);
			setBackground(null);		}
	}
}
