package cross.threebodyship.userinterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StopUI extends JPanel{
	int panelWidth;
	int panelHeight;
	
	JButton menu = new JButton();
	JButton resume = new JButton();
	JButton restart = new JButton();
	
	public StopUI(){
		this.panelWidth = MainUI.WIDTH;
		this.panelHeight = MainUI.HEIGHT;
		
		setSize(panelWidth,panelHeight);
		setLayout(null);
		setVisible(true);
	}
	
	public void paintComonent(Graphics g){
		Image cover_img = new ImageIcon("img/GameBackground/cover-40.png").getImage();
		g.drawImage(cover_img, 0, 0, panelWidth, panelHeight, 0, 0, 1024, 768, null);
	}
	
	public void addButton(JButton button){
		this.setButton(menu, menu.getName());
		menu.setBounds((int)(panelWidth*0.532),(int)(panelHeight*0.437) , 99, 99);
		this.setButton(resume,resume.getName());
		resume.setBounds((int)(panelWidth*0.5-95),(int)(panelHeight*0.5-95),190,190);
		this.setButton(restart, restart.getName());
		restart.setBounds(panelWidth-339, (int)(panelHeight*0.437), 99, 99);
	}
	
	public void setButton(JButton button,String btnName){
		button.setIcon(new ImageIcon("img/Button/btn-"+btnName+"-normal.png"));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
	}

}
