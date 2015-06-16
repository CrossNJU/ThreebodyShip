package cross.threebodyship.userinterface;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.omg.CORBA.PUBLIC_MEMBER;

import cross.threebodyship.listener.EnterStageButtonListener;
import cross.threebodyship.listener.MainChangeListener;
import cross.threebodyship.listener.StageStartButtonListener;
import cross.threebodyship.model.Stage;
import cross.threebodyship.transaction.GameController;
import cross.threebodyship.util.DisplayPanel;

public class StageUI extends ThreebodyPanel implements Observer {
	public String style = "stage";
	private static final long serialVersionUID = 1L;

	public Component currentPane;

	BeforeUI beforeUI = null;
	WinUI winUI = null;
	FailUI failUI = null;
	PauseUI pauseUI = null;
	ChapUI chapUI = null;
	EndUI endUI = null;

	public GameUI gamePanel;
	MainPanel mainPanel = null;

	public Stage stage;

	public StageUI(MainPanel mainPanel, Stage stage) {
		this.stage = stage;
		this.mainPanel = mainPanel;

		init();
	}

	public void init() {
		stage.addObserver(this);

		setLayout(null);
		setBounds(0, 0, MainUI.WIDTH, MainUI.HEIGHT);
		// setBackground(Color.BLUE);
		setVisible(true);
		setOpaque(false);

		// Game部分
		initGamePanel(this);

		winUI = new WinUI(this);
		beforeUI = new BeforeUI(this);
		failUI = new FailUI(this);
		chapUI = new ChapUI(this);
		endUI = new EndUI(this);

		if ((stage.num % 3 == 1) && (stage.num != 19)) {
			beforeUI.setVisible(false);
			add(chapUI);
			chapUI.aat.execute();
		}
		add(beforeUI);
		currentPane = gamePanel;
		add(currentPane);

	}

	public void initGamePanel(StageUI stageUI) {
		GameController gameController = new GameController(stage.game);
		gamePanel = new GameUI(stage.game, this);
		stage.game.addObserver(gamePanel);
		gamePanel.setSize(MainUI.WIDTH, MainUI.HEIGHT);
		gamePanel.setLocation(0, 0);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				alpha));

	};

	@Override
	public void update(Observable o, Object arg) {
		String msg = (String) arg;
		// WinGame之后
		if (msg.equals("win")) {
			if (stage.num != 18) {
				System.out.println("To Next in Starter");
				remove(currentPane);
				currentPane = winUI;
				add(currentPane);
				revalidate();
				repaint();
				winUI.waat.execute();
			} else {
				System.out.println("To Next in Starter");
				remove(currentPane);
				currentPane = endUI;
				add(currentPane);
				revalidate();
				repaint();
				endUI.aat.execute();
			}
			
			// 更新记录数据
			// System.out.println(stageUI.mainPanel.num);
			if (mainPanel.num <stage.game.gameNumber+1 && stage.game.gameNumber<=18)
				mainPanel.num = stage.game.gameNumber+1;
			// System.out.println(stageUI.mainPanel.num);

			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(new File("data")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				writer.write(String.valueOf(mainPanel.num));
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("update");
			System.out.println(mainPanel.num);
		}

		if (msg.equals("fail")) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					failUI.setVisible(true);
					gamePanel.add(failUI, 0);
					gamePanel.validate();
					gamePanel.repaint();
					failUI.aat.execute();
				}
			});

		}
	}

	public String getStyle() {
		return style;
	}
}
