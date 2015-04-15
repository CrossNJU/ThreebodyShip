package cross.threebodyship.userinterface;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import cross.threebodyship.model.Game;
import cross.threebodyship.model.Ship;
import cross.threebodyship.model.Star;
import cross.threebodyship.transaction.GameController;

public class GameUI extends JPanel implements Observer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	GameController gameController = null;
    Game game = null;

    Canvas paintCanvas;
    JLabel labelSpeed;
    JLabel labelDirection;

    public static int canvasWidth;
    public static int canvasHeight;

    public final static int unitWidth = 1;
    public final static int unitHeight = 1;

    public GameUI(Game game, GameController gameController) {
        this.game = game;
        this.gameController = gameController;

        canvasWidth = game.maxX * unitWidth;
        canvasHeight = game.maxY * unitWidth;
        
        setLayout(null);
        setBounds(0, 0, 1000, 600);
        setBackground(Color.BLUE);
        
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BorderLayout());
        labelSpeed = new JLabel("速度: ");
        panelTop.add(labelSpeed, BorderLayout.NORTH);
        labelDirection = new JLabel("方向: ");
        panelTop.add(labelDirection, BorderLayout.SOUTH);
        add(panelTop);
        panelTop.setBounds(10, 50, 800, 50);

        paintCanvas = new Canvas();
        paintCanvas.setSize(canvasWidth + 1, canvasHeight + 1);
        paintCanvas.addKeyListener(gameController);
        add(paintCanvas);
        paintCanvas.setBounds(10, 100, canvasWidth + 1, canvasHeight + 1);

        addKeyListener(gameController);
    }
    
    public void paint() {
        Graphics g = paintCanvas.getGraphics();

        //绘制背景
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        
        //绘制星球
        drawStar(g, game.star);
        
        //绘制飞船
        drawShip(g, game.ship);
        
        updateSpeed();
        updateDirection();
    }
    private void drawStar(Graphics g, Star star) {
        //引力范围
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval((star.x - star.range) * unitWidth,
                (star.y - star.range) * unitHeight,
                star.range * 2 * unitWidth,
                star.range * 2 * unitHeight);
        //星球
        g.setColor(Color.DARK_GRAY);
        g.fillOval((star.x - star.r) * unitWidth,
                (star.y - star.r) * unitHeight,
                star.r * 2 * unitWidth,
                star.r * 2 * unitHeight);
    }
    private void drawShip(Graphics g, Ship ship) {
        g.setColor(Color.RED);
        g.fillOval((int) ((ship.x - 3) * unitWidth), (int) ((ship.y - 3) * unitHeight), 6 * unitWidth, 6 * unitHeight);
    }
    public void updateSpeed() {
        String s = "速度: " + game.ship.getSpeed();
        labelSpeed.setText(s);
    }
    public void updateDirection() {
        String s = "方向: " + game.ship.direction;
        labelDirection.setText(s);
    }
    
    public void end() {
		
	}

	@Override
    public void update(Observable o, Object arg) {
		Game game = (Game) o;
		if (!game.isInterrupted) {
			paint();
		}
        
    }
}
