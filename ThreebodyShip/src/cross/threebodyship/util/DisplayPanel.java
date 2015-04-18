package cross.threebodyship.util;

import java.awt.Component;

import javax.swing.JPanel;

import cross.threebodyship.userinterface.MainUI;
import cross.threebodyship.userinterface.SelectorUI;
import cross.threebodyship.userinterface.StageUI;

public class DisplayPanel {
	public static final void mainDisplay(MainUI mainUI, Component newPane){
		mainUI.remove(mainUI.currentPane);
		mainUI.currentPane = newPane;
		mainUI.add(mainUI.currentPane);
		mainUI.currentPane.setVisible(true);
		mainUI.revalidate();
		mainUI.repaint();
	}
	
	public static final void selectorDisplay(SelectorUI selectorUI, Component newPane){
		selectorUI.remove(selectorUI.currentPane);
		selectorUI.currentPane = newPane;
		selectorUI.add(selectorUI.currentPane);
		selectorUI.currentPane.setVisible(true);
		selectorUI.revalidate();
		selectorUI.repaint();
	}
	
	public static final void stageDisplay(StageUI stageUI, Component newPane){
		stageUI.remove(stageUI.currentPane);
		stageUI.currentPane = newPane;
		stageUI.add(stageUI.currentPane);
		stageUI.currentPane.setVisible(true);
		stageUI.revalidate();
		stageUI.repaint();
	}
}
