package cross.threebodyship.listener;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import org.omg.CORBA.Current;

import cross.threebodyship.userinterface.MainUI;
import cross.threebodyship.util.DisplayPanel;

//该类为各种主页面切换的按钮监听


public class MainChangeListener implements MouseListener {
	MainUI mainUI = null;
	Component newPane = null;
	
	public MainChangeListener(MainUI mainUI, Component newPane ) {
		// TODO Auto-generated constructor stub
		this.mainUI = mainUI;
		this.newPane = newPane;
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		DisplayPanel.mainDisplay(mainUI,newPane);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
