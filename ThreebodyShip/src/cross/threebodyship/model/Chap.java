package cross.threebodyship.model;

import java.util.ArrayList;

public class Chap {
	public String chapName;
	public int chapNum;
	public ArrayList<Stage> stage = new ArrayList<Stage>();
	
	
	public Chap(String chapName,int chapNum){
		this.chapNum = chapNum;
		this.chapName = chapName;
		Stage stage1 = new Stage("一而生二", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png");
		addStage(stage1);
		Stage stage2 = new Stage("二而生三", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png");
		addStage(stage2);
		Stage stage3 = new Stage("三而生四", "Ch1-Stage1-Before.png", "Ch1-Stage1-After.png");
		addStage(stage3);
	}
	
	public void addStage(Stage newStage){
		this.stage.add(newStage);
	}
	
}