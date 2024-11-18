package main;

import javax.swing.*;

public class Main {

    /*

    TO:DO
        - Implement FileDialogHandler functionality
        - Add number key binds to the current tile for selection
        - Add more key binds for filling in canvas
        - implement the canvas so its as big as the game's is
            * use the same camera and movement mechanics
        - clean up UI
     */

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("2D Painting App");

        CanvasPanel panel = new CanvasPanel(window);


        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panel.startApp();




    }

}
