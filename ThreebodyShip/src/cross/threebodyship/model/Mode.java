package cross.threebodyship.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mode {
	public String modeName;
	public String[] chap;
	public ArrayList<Stage> stages = new ArrayList<Stage>();
	public int modeType;

	public int num;

	public Mode(String modeName) {
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

		if (modeType == 1) {
			chap= new String[] { "chap00", "chap01", "chap02",
						"chap03", "chap04", "chap05" };
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
			addStage(new Stage("Game16"));
			addStage(new Stage("Game17"));
			addStage(new Stage("Game18"));
//			System.out.println("stages:"+stages.size());
//			读出数据
			num = 0;
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader((new File("data.txt"))));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				num = Integer.parseInt(reader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// System.out.println(num);
			for (int i = 0; i < num; i++) {
				stages.get(i).isLocked = false;
			}
		} else if (modeType == 2) {
//			挑战模式章节
			chap = new String[]{"challenge1"};
//			加入挑战模式关卡
		}
		
		

	}

	public void addStage(Stage stage) {
		if(modeType==1){
			if (stages.size() > 0) {
				stages.get(stages.size() - 1).nextStage = stage;
			}
			stages.add(stage);
			stage.num = stages.size();
			stage.game.gameNumber = stage.num;
		}else if(modeType==2){
			if (stages.size() > 0) {
				stages.get(stages.size() - 1).nextStage = stage;
			}
			stages.add(stage);
			stage.num = stages.size()+18;
			stage.game.gameNumber = stage.num;
		}
	}

}
