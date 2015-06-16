package cross.threebodyship.userinterface;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.ScrollListener;

public class ChallengeUI extends ThreebodyPanel {
	int panelWidth;
	int panelHeight;
	ArrayList<JButton> stagebtn = new ArrayList<>();
	SelectorUI selectorUI;

	public ChallengeUI(SelectorUI selectorUI) {
		panelWidth = (int) (MainUI.WIDTH * 0.7);
		panelHeight = MainUI.HEIGHT;
		setSize(panelWidth, panelHeight);
		setOpaque(false);
		setBackground(null);
		setLayout(null);
		this.selectorUI = selectorUI;
		
		
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
				stagebtn.add(stageButton);
				
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
				String imageDisableString = "img/Button/stagebtn/challenge_button"
						+ (num + 1) + "-disable.png";
				
				ImageIcon image = new ImageIcon(imageString);
				ImageIcon imageDisable = new ImageIcon(imageDisableString);

				if(!selectorUI.selector.mode.get(1).stages.get(num).isLocked){
					stageButton.setIcon(image);
				}else{
					stageButton.setIcon(imageDisable);
				}
				stageButton.setContentAreaFilled(false);
				stageButton.setBorderPainted(false);
				stageButton.setFocusPainted(false);

				add(stageButton);
				num++;
			}
		}
		addMouseWheelListener(new ScrollListener(this));
	}
	
	@Override
	public void reset() {
		
		for(int num = 0 ;num<3;num++){
			String imageString = "img/Button/stagebtn/challenge_button"
					+ (num + 1) + ".png";
			String imageHoverString = "img/Button/stagebtn/btn-challenge"
					+ (num + 1) + "-hover.png";
			String imageDisableString = "img/Button/stagebtn/challenge_button"
					+ (num + 1) + "-disable.png";
			
			ImageIcon image = new ImageIcon(imageString);
			ImageIcon imageDisable = new ImageIcon(imageDisableString);

			if(!selectorUI.selector.mode.get(1).stages.get(num).isLocked){
				stagebtn.get(num).setIcon(image);
			}else{
				stagebtn.get(num).setIcon(imageDisable);
			}
			stagebtn.get(num).repaint();
		}
		
	}
}
