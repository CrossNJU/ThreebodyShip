package cross.threebodyship.model;

import java.util.ArrayList;

public class Mode {
	public String modeName;
	public String[] chap = new String[]{"chap00","chap01","chap02"};
	public ArrayList<Stage> stages = new ArrayList<Stage>();
	public int modeType;
	
	public Mode(String modeName){
		this.modeName = modeName;
		switch (modeName) {
		case "故事模式":
			modeType = 1;
			break;
		default:
			break;
		}
			
		if(modeType == 1){
			stages.add(new Stage("从一开始", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png"));
			stages.add(new Stage("一而生二", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png"));
			stages.add(new Stage("二而生三", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png"));
			stages.add(new Stage("三相跌生", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png"));
			stages.add(new Stage("黄金三角", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png"));
			stages.add(new Stage("魔鬼三角", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png"));
			stages.add(new Stage("魔鬼三角", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png"));
			stages.add(new Stage("魔鬼三角", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png"));
			stages.add(new Stage("魔鬼三角", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png"));
		}
	}
	
	
}
