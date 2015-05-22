package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class CoverPanel extends ThreebodyPanel {
	
	public CoverPanel() {
		alpha = 1;
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setBackground(null);
		setOpaque(false);
	}
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;  
        g2d.setComposite(AlphaComposite.getInstance(  
                AlphaComposite.SRC_OVER, alpha));  
        
        Image cover = new ImageIcon("img/GameBackground/cover-65.png").getImage();
        g.drawImage(cover, 0, 0, null);
	};
}
