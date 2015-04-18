package cross.threebodyship.model;

import java.util.ArrayList;

import javax.swing.JButton;

public class Selector {
	public ArrayList<Mode> mode = new ArrayList<Mode>();
	public ArrayList<Chap> chap = new ArrayList<Chap>();
	
	public Selector(){
		//加入模式
		addMode("故事模式");
		addMode("挑战模式");
		addMode("成就");
		addMode("设置");
		
		//加入章节
		addChap("实验",0);
		addChap("启程",1);
		addChap("黑洞", 2);
		addChap("阻拦", 3);
		addChap("入侵", 4);
	}
	
	//添加模式
	public void addMode(String modeName){
		Mode mode = new Mode(modeName);
		this.mode.add(mode);
	}
	
	//添加章节
	public void addChap(String chapName,int chapNum){
		Chap newChap = new Chap(chapName,chapNum);
		this.chap.add(newChap);
	}
}

