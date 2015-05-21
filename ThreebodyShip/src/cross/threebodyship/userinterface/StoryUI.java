package cross.threebodyship.userinterface;

import java.awt.Color;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.ScrollListener;
import cross.threebodyship.model.Mode;

public class StoryUI extends ThreebodyPanel {
	int panelWidth;
	int panelHeight;
	SelectorUI selectorUI;

	public StoryUI(SelectorUI selectorUI) {
		panelWidth = (int) (MainUI.WIDTH * 0.7);
		panelHeight = MainUI.HEIGHT;
		this.selectorUI = selectorUI;
		init();
	}
	
	public void init(){
		setSize(panelWidth, panelHeight * 3);
		setOpaque(false);
		setBackground(null);
		setLayout(null);

		removeAll();
		// num表示的是关卡数，i表示的是章节数，j表示每个章节的第几关
		int num = 0;
		for (int i = 0; i < selectorUI.selector.mode.get(0).chap.length; i++) {
			JLabel chapLabel = new JLabel();
			chapLabel.setBounds((int) (panelWidth * 0.2)-40,
					(int) (panelHeight * 0.3) * (i + 1)-100, 220, 60);
			chapLabel.setIcon(new ImageIcon("img/Selector/chap0" + i + ".png"));
			chapLabel.setForeground(Color.BLACK);
			chapLabel.setVisible(true);
			add(chapLabel);

			for (int j = 0; j < 3; j++) {
				if (num == selectorUI.selector.mode.get(0).stages.size()) {
					break;
				}
				JButton stageButton = new JButton(
						selectorUI.selector.mode.get(0).stages.get(num).title);

				stageButton.setBounds((int) (panelWidth * 0.25) * (j + 1)-80,
						(int) (panelHeight * 0.3) * (i + 1) -40, 154, 154);
				stageButton.setVisible(true);
				stageButton.addMouseListener(new EnterStageButtonListener(
						selectorUI.mainPanel,
						selectorUI.selector.mode.get(0).stages.get(num)));

				String imageString = "img/Button/stagebtn/btn-stage"
						+ (num + 1) + "-normal.png";
				String imageHoverString = "img/Button/stagebtn/btn-stage"
						+ (num + 1) + "-hover.png";
				String imageLockString  = "img/Button/stagebtn/btn-stage"
						+ (num + 1) + "-disable.png";
				if(num<selectorUI.mainPanel.num){
					ImageIcon image = new ImageIcon(imageString);
					ImageIcon imageHover = new ImageIcon(imageHoverString);
					stageButton.setIcon(image);
					stageButton.setRolloverIcon(imageHover);
				}else {
					ImageIcon imageLock = new ImageIcon(imageLockString);
					stageButton.setIcon(imageLock);
				}

				stageButton.setContentAreaFilled(false);
				stageButton.setBorderPainted(false);
				stageButton.setFocusPainted(false);

				add(stageButton);
				num++;
			}
		}

		addMouseWheelListener(new ScrollListener(this));
		revalidate();
//		System.out.println("init");
		System.out.println(selectorUI.mainPanel.num);
	}
}
