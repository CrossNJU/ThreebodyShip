package cross.threebodyship.userinterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FailUIPre extends JPanel{
	
	int panelWidth;
	int panelHeight;
	
	JButton menu;
	JButton again;
	
	public FailUIPre(){
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
	
	public void addButton(JButton button){
		this.setButton(menu, menu.getName());
		menu.setBounds((int)(panelWidth*0.532),(int)(panelHeight*0.437) , 99, 99);
		this.setButton(again, again.getName());
		again.setBounds(panelWidth-339, (int)(panelHeight*0.437), 99, 99);
		add(menu);
		add(again);
	}
	
	public void setButton(JButton button,String btnName){
		button.setIcon(new ImageIcon("img/Button/btn-"+btnName+"-normal.png"));
		button.setRolloverIcon(new ImageIcon("img/Button/btn-"+btnName+"-hover.png"));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
	}

}
