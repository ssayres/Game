package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); // Jpanel extends JComponent entao JComponent é a super classe
        g.fillRect(100, 100, 200, 50);
    }
}
