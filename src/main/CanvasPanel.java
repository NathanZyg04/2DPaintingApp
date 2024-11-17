package main;

import GridManager.gridManager;

import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel implements Runnable {

    public final int screenWidth = 1200;
    public final int screenHeight = 1200;

    public MouseHandler mouse = new MouseHandler();

    public gridManager grid = new gridManager(this);

    Thread appThread;

    public final int FPS = 60;


    public CanvasPanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addMouseListener(mouse);

    }

    public void startApp() {

        appThread = new Thread(this);
        appThread.start();

    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;


        while(appThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;


            if(delta >= 1) {


                repaint();
                delta--;

            }

        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        grid.draw(g2);

    }


}
