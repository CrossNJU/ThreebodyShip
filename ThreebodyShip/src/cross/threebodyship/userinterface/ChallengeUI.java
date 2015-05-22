package cross.threebodyship.userinterface;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.ScrollListener;

public class ChallengeUI extends ThreebodyPanel {
	int panelWidth;
	int panelHeight;

	public ChallengeUI(SelectorUI selectorUI) {
		panelWidth = (int) (MainUI.WIDTH * 0.7);
		panelHeight = MainUI.HEIGHT;
		setSize(panelWidth, panelHeight);
		setOpaque(false);
		setBackground(null);
		setLayout(null);
		
		
		// num表示的是关卡数，i表示的是章节数，j表示每个章节的第几关
		int num = 0;
		for (int i = 0; i < selectorUI.selector.mode.get(1).chap.length; i++) {
			JLabel chapLabel = new JLabel();
			chapLabel.setBounds((int) (panelWidth * 0.2) - 75,
					(int) (panelHeight * 0.3) * (i + 1)-30 , 240, 50);
			chapLabel.setIcon(new ImageIcon("img/Selector/challenge_name.png"));
			chapLabel.setForeground(Color.BLACK);
			chapLabel.setVisible(true);
			add(chapLabel);

			for (int j = 0; j < 3; j++) {
				if (num == selectorUI.selector.mode.get(1).stages.size()) {
					break;
				}
				JButton stageButton = new JButton();

				stageButton.setBounds((int) (panelWidth * 0.3) * (j + 1) - 175,
						(int) (panelHeight * 0.3) * (i + 1) +50, 230, 230);
				stageButton.setVisible(true);
				stageButton.addMouseListener(new EnterStageButtonListener(
						selectorUI.mainPanel,
						selectorUI.selector.mode.get(1).stages.get(num)));

				String imageString = "img/Button/stagebtn/challenge_button"
						+ (num + 1) + ".png";
				String imageHoverString = "img/Button/stagebtn/btn-challenge"
						+ (num + 1) + "-hover.png";
				ImageIcon image = new ImageIcon(imageString);
//				ImageIcon imageHover = new ImageIcon(imageHoverString);

				stageButton.setIcon(image);
//				stageButton.setRolloverIcon(imageHover);
				stageButton.setContentAreaFilled(false);
				stageButton.setBorderPainted(false);
				stageButton.setFocusPainted(false);

				add(stageButton);
				num++;
			}
		}
		addMouseWheelListener(new ScrollListener(this));
	}
}
