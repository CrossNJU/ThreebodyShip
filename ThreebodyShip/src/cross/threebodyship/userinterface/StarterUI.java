package cross.threebodyship.userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StarterUI extends JPanel {
	int frameHeight;
	int frameWidth;
	public JButton startGameButton = new JButton("开始游戏");
	//Image Start_img = new ImageIcon("img/Start/bg-starter-mid.png").getImage();

	public StarterUI(MainUI mainUI) {
		this.frameHeight = MainUI.HEIGHT;
		this.frameWidth = MainUI.WIDTH;
		
		//
		
		//
		
		startGameButton.setBounds((int) (frameWidth * 0.40),
				(int) (frameHeight * 0.6), (int) (frameWidth * 0.2), 60);
		startGameButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel title = new JLabel("ThreebodyShip",JLabel.CENTER);
		title.setBounds((int) (frameWidth * 0.3),
				(int) (frameHeight * 0.3), (int) (frameWidth * 0.4), 60);
		title.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		title.setVisible(true);
		
		setSize(frameWidth, frameHeight);
		setLayout(null);
		//setBackground(Color.white);
		add(startGameButton);
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon("img/Starter/bg-starter-mid.png"));
		backLabel.setBounds(0, 0, 1024, 768);
		backLabel.setVisible(true);
		add(backLabel);
		add(title);
		//repaint();
	}
	//public void paint(Graphics g){
		//g.drawImage(Start_img,0,0,MainUI.WIDTH,MainUI.HEIGHT,0,0,1024,768,null);
	//}
}
