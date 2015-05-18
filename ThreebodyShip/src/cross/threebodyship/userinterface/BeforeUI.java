package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.listener.StageStartButtonListener;

public class BeforeUI extends ThreebodyPanel {
	JLabel stageTitle = new JLabel();
	StageUI stageUI = null;
	GameUI gameUI;
	
	
	public BeforeUI(StageUI stageUI){
//		this.gameUI = gameUI;
		this.stageUI = stageUI;
		initBeforeUI();
	}
	
	public void initBeforeUI(){
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setBackground(null);
		setOpaque(false);
		Graphics g = getGraphics();
		
		stageTitle.setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		stageTitle.setIcon(new ImageIcon(
				"img/Before/cover-before-stage" + stageUI.stage.num + ".png"));
		stageTitle.setVisible(true);
		stageTitle.addMouseListener(new StageStartButtonListener(stageUI,this));
		
		add(stageTitle);
//		stageUI.currentPane = this;
	}
}
