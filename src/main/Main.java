package main;

import javax.swing.*;

public class Main {

    /*

    - get the mouse pos within the grid and fill that rectangle with the color



     */

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Painting App");

        CanvasPanel panel = new CanvasPanel();

        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panel.startApp();




    }

}
