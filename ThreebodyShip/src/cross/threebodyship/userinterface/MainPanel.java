package cross.threebodyship.userinterface;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import cross.threebodyship.listener.OpaqueDisplayListener;
import cross.threebodyship.model.Selector;

public class MainPanel extends ThreebodyPanel {
	public String style = "main";
	public MainUI mainUI;
	public ThreebodyPanel currentPane;
	public StarterUI starterUI;
	public SelectorUI selectorUI;
	public StageUI stageUI;
	public StartUI startUI;
	public Music music;
	public int num;

	int bgX = 0;
	BackgroundAnimeThread bat = new BackgroundAnimeThread();

	public MainPanel(MainUI mainUI) {
		// TODO Auto-generated constructor stubScanner fileScanner = null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File("data.txt")));
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
		
		this.mainUI = mainUI;
		init();
	}

	public void init() {
		Selector selector = new Selector();
		music = new Music();
		music.play(0);
		// 初始化开始界面
		starterUI = new StarterUI(mainUI);
		// 初始化选择界面
		selectorUI = new SelectorUI(selector, this);

		starterUI.startGameButton.addMouseListener(new OpaqueDisplayListener(
				this, selectorUI));

		startUI = new StartUI(this);
		add(startUI);
		
		currentPane = starterUI;
		starterUI.setVisible(false);
		add(currentPane);
		
		bat = new BackgroundAnimeThread();
		bat.start();
		
		startUI.at.start();
	}

	public void paintComponent(Graphics g) {
		Image B_img = new ImageIcon("img/GameBackground/bg.jpg").getImage();
		g.drawImage(B_img, 0, 0, MainUI.WIDTH, MainUI.HEIGHT, 0 + bgX, 0,
				1024 + bgX, 768, null);
	}
	
	public String getStyle(){
		return style;
	}

	class BackgroundAnimeThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();

			while (true) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						repaint();
					}
				});

				try {
					Thread.sleep(60);
				} catch (Exception e) {
					// TODO: handle exception
				}
				bgX++;
				bgX %= 1669 - 1024;
				// System.out.println(SwingUtilities.isEventDispatchThread());
			}
		}
	}
}
