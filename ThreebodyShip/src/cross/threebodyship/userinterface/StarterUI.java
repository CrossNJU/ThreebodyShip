package cross.threebodyship.userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StarterUI extends JPanel {
	int frameHeight;
	int frameWidth;
	public JButton startGameButton = new JButton("开始游戏");

	public StarterUI(MainUI mainUI) {
		this.frameHeight = mainUI.getHeight()-48;
		this.frameWidth = mainUI.getWidth()-17;
		

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
		setBackground(Color.white);
		add(startGameButton);
		add(title);
	}

}
