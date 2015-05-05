package cross.threebodyship.userinterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cross.threebodyship.listener.EnterStageButtonListener;

public class WinUI extends JPanel{
	JButton nextStageButton;
	StageUI stageUI = null;
	
	public WinUI(StageUI stageUI){
		this.stageUI = stageUI;
		initWinUI();
	}
	
	public void initWinUI(){
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		
		nextStageButton = new JButton("Next Stage >");
		nextStageButton.setBounds((int) (MainUI.WIDTH * 0.75),
				(int) (MainUI.HEIGHT * 0.40), 142, 142);
		nextStageButton.setIcon(new ImageIcon(
				"img/Button/btn-nextstage-normal.png"));
		nextStageButton.setRolloverIcon(new ImageIcon(
				"img/Button/btn-nextstage-hover.png"));
		nextStageButton.setContentAreaFilled(false);
		nextStageButton.setBorderPainted(false);
		nextStageButton.setFocusPainted(false);
		nextStageButton.addMouseListener(new EnterStageButtonListener(stageUI.mainUI,
				stageUI.stage.nextStage));

		add(nextStageButton);
	}
	
	public void paintComponent(Graphics g){
		Image img = new ImageIcon("img/GameBackground/bg-stage"+stageUI.stage.num+"-after.png").getImage();
		g.drawImage(img, 0, 0, null);
	}
}
