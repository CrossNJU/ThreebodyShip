package cross.threebodyship.userinterface;

import java.util.ArrayList;

public class Music {
	ArrayList<MusicPlayer> musicPlayers = new ArrayList<>();
	public int currentMusic = 0;
	public String name;
	public Music(){
		init();
	}
	public void init(){
		musicPlayers.add(new MusicPlayer("music/The Crisis.wav"));
		musicPlayers.add(new MusicPlayer("music/周杰伦 - 斗牛.wav"));
	}
	
	public void play(int num){
		currentMusic = num;
		musicPlayers.get(currentMusic).start();
	}
	
	public void stop(int num){
		musicPlayers.get(num).stop();
		name = musicPlayers.get(num).name;
		musicPlayers.set(num, new MusicPlayer(name));
	}
	public void stopAll(){
		for (MusicPlayer musicPlayer : musicPlayers) {
			musicPlayer.stop();
		}
	}
}
