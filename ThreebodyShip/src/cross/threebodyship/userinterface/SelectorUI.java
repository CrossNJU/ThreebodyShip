package cross.threebodyship.userinterface;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ViewportLayout;

import cross.threebodyship.listener.ModeButtonListener;
import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.model.Chap;
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
		
		//选择界面初始化
		setSize(frameWidth, frameHeight);
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);
		newSelectorUI();
	}

	// 生成新的选择界面
	public void newSelectorUI() {
		//将Selector中的按钮与模式添加到UI中
		setModeButton();
		setModePanel();

		// 加入模式按钮
		for (int i = 0; i < modeButton.size(); i++) {
			modeButton.get(i).setBounds((int) (frameWidth * 0.1),
					(int) (frameHeight * 0.2 * (i + 1)), 100, 50);
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
			this.modeButton.add(modeButton);
		}
	}

	// 设置模式界面
	public void setModePanel() {
		modePane.add(new StoryPane());
		modePane.add(new ChallengePanel(frameWidth, frameHeight));
		modePane.add(new AchievementPanel(frameWidth, frameHeight));
		modePane.add(new SettingPanel(frameWidth, frameHeight));
	}

	// 模式界面设计
	class StoryPane extends JScrollPane {
		int panelWidth;
		int panelHeight;

		public StoryPane() {
			panelWidth = (int) (frameWidth * 0.7);
			panelHeight = frameHeight;
			setSize(panelWidth, panelHeight);
			
			//
			JPanel StoryPanel = new JPanel();
			StoryPanel.setPreferredSize(new Dimension(getViewport().getWidth(),
					panelHeight * 3));
			StoryPanel.setLayout(null);
			StoryPanel.setBackground(Color.white);

			//添加章节文本与关卡按钮
			int i = 1;
			int j = 1;
			for (Chap chap : selector.chap) {
				JLabel chapLabel = new JLabel("CHAP  " + chap.chapNum + " : "
						+ chap.chapName);

				chapLabel.setBounds((int) (panelWidth * 0.2),
						(int) (panelHeight * 0.2) * i, 100, 40);
				chapLabel.setForeground(Color.BLACK);
				chapLabel.setVisible(true);
				StoryPanel.add(chapLabel);
				for (Stage stage : chap.stage) {
					JButton stageButton = new JButton(stage.title);

					stageButton.setBounds((int) (panelWidth * 0.2) * j,
							(int) (panelHeight * 0.2) * i + 60, 100, 40);
					stageButton.setVisible(true);
					stageButton
							.addMouseListener(new EnterStageButtonListener(mainUI,stage));

					StoryPanel.add(stageButton);

					j++;
				}

				i++;
				j = 1;
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
			setBackground(Color.blue);
		}
	}

	class AchievementPanel extends JPanel {
		int panelWidth;
		int panelHeight;

		public AchievementPanel(int frameWidth, int frameHeight) {
			panelWidth = (int) (frameWidth * 0.7);
			panelHeight = frameHeight;
			setSize(panelWidth, panelHeight);
			setBackground(Color.red);
		}
	}

	class SettingPanel extends JPanel {
		int panelWidth;
		int panelHeight;

		public SettingPanel(int frameWidth, int frameHeight) {
			panelWidth = (int) (frameWidth * 0.7);
			panelHeight = frameHeight;
			setSize(panelWidth, panelHeight);
			setBackground(Color.yellow);
		}
	}
}
