package cross.threebodyship.userinterface;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class AchievementUI extends ThreebodyPanel {
	Image[] achievement = new Image[6];
	int lockNum=18;
	SelectorUI selectorUI;
	
	public AchievementUI(SelectorUI selectorUI) {
		setSize(MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);
		setBackground(null);
		setLayout(null);
		this.selectorUI = selectorUI;
		setup();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(selectorUI.mainPanel.num<=18){
			lockNum = selectorUI.mainPanel.num;
		}
		for(int i = 0 ; i<lockNum/3;i++){
			if(i<3){
				g.drawImage(achievement[i], 75+i*176, 166, null);
			}else{
				g.drawImage(achievement[i], 75+(i-3)*176, 397, null);
			}
		}
	}

	public void setup() {
		for (int i = 0; i < 6; i++) {
			Toolkit toolkit = getToolkit();
			achievement[i] = toolkit.getImage("img/Achievement/achievement_"
					+ (i + 1) + ".png");
		}
	}
}
