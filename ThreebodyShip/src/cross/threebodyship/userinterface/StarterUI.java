package cross.threebodyship.userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StarterUI extends JPanel {
	public JButton startGameButton = new JButton();
	int i = 0;
	int j = 50;
	Thread anime;

	public StarterUI(MainUI mainUI) {
		initStarterUI();
	}
	
	public void initStarterUI(){
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		
		
		startGameButton.setBounds((int) (MainUI.WIDTH * 0.412),
				(int) (MainUI.HEIGHT * 0.43),188,188);
		//startGameButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		startGameButton.setIcon(new ImageIcon("img/Button/btn-start.png"));
		startGameButton.setFocusable(false);
		startGameButton.setContentAreaFilled(false);
		startGameButton.setBorderPainted(false);
		add(startGameButton);

	}
	
	
	public void paintComponent(Graphics g){
		Image img = new ImageIcon("img/Starter/bg-starter-mid.png").getImage();
		g.drawImage(img, 0, 0, null);
		
	}
	
}
