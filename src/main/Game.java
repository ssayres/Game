package main;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    private Thread gameThread;

    private final int FPS_SET = 120;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();

    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {


        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        int frames =0;
        long lastCheck = System.currentTimeMillis();

        long now = System.nanoTime();

        while(true){
            now = System.nanoTime();
            if(System.nanoTime() - lastFrame >= timePerFrame){
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }


            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println(" FPS " + frames);
                frames = 0;
            }
        }

    }
}
