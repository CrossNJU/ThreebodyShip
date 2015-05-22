package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import cross.threebodyship.listener.OpaqueDisplayListener;
import cross.threebodyship.userinterface.EndUI.AlphaAnimeThread;
import cross.threebodyship.userinterface.ThreebodyPanel.AlphaDisappearThread;

public class EndWordsUI extends ThreebodyPanel{
	AlphaAnimeThread aat;
	StageUI stageUI;
	
	public EndWordsUI(StageUI stageUI) {
		// TODO Auto-generated constructor stub
		this.stageUI = stageUI;
		init();
	}
	
	public void init(){
		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		setOpaque(false);
		
		aat = new AlphaAnimeThread();
		addMouseListener(new OpaqueDisplayListener(stageUI.mainPanel, stageUI.mainPanel.selectorUI));
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));
		Image endCover = new ImageIcon("img/End/ending2.png").getImage();
		g.drawImage(endCover, 0, 0, null);
	}
	
}
