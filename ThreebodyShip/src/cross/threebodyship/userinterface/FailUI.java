package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.MainChangeListener;
import cross.threebodyship.listener.OpaqueDisplayListener;

public class FailUI extends ThreebodyPanel{
	JButton menuButton = new JButton();
	JButton restartButton = new JButton();
	StageUI stageUI = null;
	
	public FailUI(StageUI stageUI){
		this.stageUI = stageUI;
		initFailUI();
	}
	
	public void initFailUI(){
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setBackground(null);
		setOpaque(false);

		
		setButton(menuButton, "menu");
		menuButton.setBounds(369,341,90,90);
		menuButton.addMouseListener(new OpaqueDisplayListener(stageUI.mainPanel, stageUI.mainPanel.selectorUI));
		
		setButton(restartButton, "again");
		restartButton.setBounds(487,291,183,183);
		restartButton.addMouseListener(new EnterStageButtonListener(stageUI.mainPanel, stageUI.stage));
		
		add(menuButton);
		add(restartButton);
		repaint();

	}
	
	public void paintComponent(Graphics g){
//		Image img1 = new ImageIcon("img/GameBackground/Background.png").getImage();
//		g.drawImage(img1,0,0,null);
		Graphics2D g2d = (Graphics2D) g;  
        g2d.setComposite(AlphaComposite.getInstance(  
                AlphaComposite.SRC_OVER, alpha));  
        
		Image img = new ImageIcon("img/GameBackground/cover-40.png").getImage();
		g.drawImage(img, 0, 0, null);
	}
	
	public void setButton(JButton button, String btnName) {
		button.setIcon(new ImageIcon("img/Button/btn-" + btnName
				+ "-normal.png"));
		button.setRolloverIcon(new ImageIcon("img/Button/btn-" + btnName
				+ "-hover.png"));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
	}
}
