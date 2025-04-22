package inputs;

import main.GamePanel;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Keyboardinputs implements KeyListener {

    private GamePanel gamePanel;
    public Keyboardinputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       System.out.println("Tecla apertada 2");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Ta pegando tecla sim");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.changeYDelta(-5);
            case KeyEvent.VK_A -> gamePanel.changeXDelta(-5);
            case KeyEvent.VK_S -> gamePanel.changeYDelta(5);
            case KeyEvent.VK_D -> gamePanel.changeXDelta(5);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
