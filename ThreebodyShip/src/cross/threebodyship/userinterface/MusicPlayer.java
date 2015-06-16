package cross.threebodyship.userinterface;

import java.io.*;

import javax.sound.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class MusicPlayer {
	private AudioStream as; // 单次播放声音用
	ContinuousAudioDataStream cas;// 循环播放声音
	public String name;
	
	// 构造函数
	public MusicPlayer(String filename) {
		name = filename;
		try {
			// 打开一个声音文件流作为输入
			InputStream in = new FileInputStream(filename);
			as = new AudioStream(in);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 一次播放 开始
	public void start() {
		if (as == null) {
			System.out.println("AudioStream object is not created!");
			return;
		} else {
			AudioPlayer.player.start(as);
		}
	}

	// 一次播放 停止
	public void stop() {
		if (as == null) {
			System.out.println("AudioStream object is not created!");
			return;
		} else {
			AudioPlayer.player.stop(as);
		}
	}

	// 循环播放 开始
	public void continuousStart() {
		// Create AudioData source.
		AudioData data = null;
		try {
			data = as.getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Create ContinuousAudioDataStream.
		cas = new ContinuousAudioDataStream(data);
		// Play audio.
		AudioPlayer.player.start(cas);
	}

	// 循环播放 停止
	public void continuousStop() {
		if (cas != null) {
			AudioPlayer.player.stop(cas);
		}
	}
}
