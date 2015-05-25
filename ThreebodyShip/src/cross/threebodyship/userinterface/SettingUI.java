package cross.threebodyship.userinterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SettingUI extends ThreebodyPanel{

	public SettingUI(SelectorUI selectorUI) {
		setSize(MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);
		setBackground(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img = new ImageIcon("img/Component/settings.png").getImage();
		g.drawImage(img, 100, 280, null);
	}
}
