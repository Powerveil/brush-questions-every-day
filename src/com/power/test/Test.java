package com.power.test;

import javax.swing.*;
import java.awt.*;

/**
 * @author 崔帅
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Test extends JFrame implements Runnable {
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 500;
    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Test() {
        this.setTitle("心形曲线");
        this.setLocation((WIDTH - GAME_WIDTH) / 2, (HEIGHT - GAME_HEIGHT) / 2);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        double x, y, r;
        Image OffScreen = createImage(GAME_WIDTH, GAME_HEIGHT);
        Graphics dramOffScreen = OffScreen.getGraphics();
        for (int i = 0; i < 90; i++) {
            for (int j = 0; j < 90; j++) {
                r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + GAME_WIDTH / 2;
                y = -r * Math.sin(Math.PI / 45 * j) + GAME_HEIGHT / 4;
                dramOffScreen.setColor(Color.PINK);
                dramOffScreen.fillOval((int) x, (int) y, 2, 2);
            }
            g.drawImage(OffScreen, 0, 0, this);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread t = new Thread(test);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                this.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
