package main;

import inputs.Keyboardinputs;
import inputs.Mouseinputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GamePanel extends JPanel {

    private Mouseinputs mouseinputs;

    private long lastCheck;

    private int frames = 0;
    private float xDelta = 100;
    private float yDelta = 100;

    private float xDir = 1f;

    private float yDir = 1f;

    private Random random;

    private Color color = new Color(150,20,90);



    public GamePanel() {

        random = new Random();
        mouseinputs = new Mouseinputs(this);
        addKeyListener(new Keyboardinputs(this));
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);


    }

    public void setRectanglePosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;

    }

    public void changeXDelta(int value) {
        this.xDelta += value;

    }

    public void changeYDelta(int value) {
        this.yDelta += value;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Jpanel extends JComponent entao JComponent é a super classe
        updateRectangle();
        g.setColor(color);
        g.fillRect((int)xDelta, (int)yDelta, 200, 50);




    }

    public void updateRectangle(){
        xDelta+= xDir;

        yDelta+= yDir;

        if(xDelta > 400 || xDelta < 0){
            xDir*= -1;
            color = getRandomColor();
        }
        if(yDelta > 400 || yDelta < 0){
            yDir*= -1;
            color = getRandomColor();
        }

    }

    private Color getRandomColor(){
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r,g,b);

    }
}
