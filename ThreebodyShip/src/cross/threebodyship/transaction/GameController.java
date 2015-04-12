package cross.threebodyship.transaction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import cross.threebodyship.model.Game;

public class GameController implements KeyListener{
    Game game;

    public GameController(Game game){
        this.game = game;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (game.running){
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    game.ship.speedUp();
                    break;
                case KeyEvent.VK_DOWN:
                    game.ship.speedDown();
                    break;
                case KeyEvent.VK_SPACE:
                    game.ship.changePauseState();
                    break;
                default:
            }
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            game.reset();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
