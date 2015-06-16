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
//		addMode("设置");
		
		Mode story = mode.get(0);
		Mode challenge = mode.get(1);
		
		story.stages.get(8).nextChallengeStage = challenge.stages.get(0);
		story.stages.get(11).nextChallengeStage = challenge.stages.get(1);
		story.stages.get(14).nextChallengeStage = challenge.stages.get(2);
//		story.
	}
	
	//添加模式
	public void addMode(String modeName){
		Mode mode = new Mode(modeName);
		this.mode.add(mode);
	}
	
}

