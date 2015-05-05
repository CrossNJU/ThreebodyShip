package cross.threebodyship.userinterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.MainChangeListener;

public class FailUI extends JPanel{
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
		setOpaque(false);
		setBackground(null);
		
		setButton(menuButton, "menu");
		menuButton.setBounds((int) (MainUI.WIDTH * 0.532),
				(int) (MainUI.HEIGHT * 0.437), 99, 99);
		menuButton.addMouseListener(new MainChangeListener(stageUI.mainUI, stageUI.mainUI.selectorPanel));
		
		setButton(restartButton, "restart");
		restartButton.setBounds((int) (MainUI.WIDTH - 339),
				(int) (MainUI.HEIGHT * 0.437), 99, 99);
		restartButton.addMouseListener(new EnterStageButtonListener(stageUI.mainUI, stageUI.stage));
		
		add(menuButton);
		add(restartButton);

	}
	
	public void paintComponent(Graphics g){
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
