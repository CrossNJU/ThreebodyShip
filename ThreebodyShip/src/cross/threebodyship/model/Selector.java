package cross.threebodyship.model;

import java.util.ArrayList;

import javax.swing.JButton;

public class Selector {
	public ArrayList<Mode> mode = new ArrayList<Mode>();
	
	public Selector(){
		//加入模式
		addMode("故事模式");
		addMode("挑战模式");
		addMode("成就");
		addMode("设置");
		
	}
	
	//添加模式
	public void addMode(String modeName){
		Mode mode = new Mode(modeName);
		this.mode.add(mode);
	}
	
}

