package cross.threebodyship.model;

import java.util.ArrayList;

public class Mode {
	public String modeName;
	public String[] chap = new String[]{"chap00","chap01","chap02","chap03","chap04","chap05"};
	public ArrayList<Stage> stages = new ArrayList<Stage>();
	public int modeType;
	
	public Mode(String modeName){
		this.modeName = modeName;
		switch (modeName) {
		case "故事模式":
			modeType = 1;
			break;
		case "挑战模式":
			modeType = 2;
			break;
		case "成就":
			modeType = 3;
			break;
		case "设置":
			modeType = 4;
			break;
				
		default:
			break;
		}
			
		if(modeType == 1){
			addStage(new Stage("从一开始"));
			addStage(new Stage("一而生二"));
			addStage(new Stage("二而生三"));
			addStage(new Stage("三相跌生"));
			addStage(new Stage("黄金三角"));
			addStage(new Stage("魔鬼三角"));
			addStage(new Stage("魔鬼三角"));
			addStage(new Stage("魔鬼三角"));
			addStage(new Stage("魔鬼三角"));
			addStage(new Stage("cr"));
			addStage(new Stage("crr"));
			addStage(new Stage("crrr"));
			addStage(new Stage("cr"));
			addStage(new Stage("crr"));
			addStage(new Stage("crrr"));
			addStage(new Stage("Game13"));
			addStage(new Stage("Game14"));
			addStage(new Stage("Game15"));
			addStage(new Stage("Game16"));
			addStage(new Stage("Game17"));
			addStage(new Stage("Game18"));
		}
	}
	
	public void addStage(Stage stage){
		if(stages.size()>0){
			stages.get(stages.size()-1).nextStage = stage;
		}
		stages.add(stage);
		stage.num = stages.size();
		stage.game.gameNumber = stage.num;
//		stage.game.data = new Data(stage.game.gameNumber);
	}
	
	
}
