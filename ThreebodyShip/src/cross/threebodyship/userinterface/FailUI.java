package cross.threebodyship.userinterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FailUI extends JPanel{
	
	int panelWidth;
	int panelHeight;
	
	JButton menu;
	JButton restart;
	
	public FailUI(){
		this.panelWidth = MainUI.WIDTH;
		this.panelHeight = MainUI.HEIGHT;
		
		this.setSize(panelWidth,panelHeight);
		this.setLayout(null);
		this.setVisible(true);
		
	}
	
	public void paintComonent(Graphics g){
		Image cover_img = new ImageIcon("img/GameBackground/cover-40.png").getImage();
		g.drawImage(cover_img, 0, 0, panelWidth, panelHeight, 0, 0, 1024, 768, null);
	}

}
