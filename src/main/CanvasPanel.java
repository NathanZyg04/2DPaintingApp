package main;

import GridManager.gridManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class CanvasPanel extends JPanel implements Runnable {

    public final int screenWidth = 1200;
    public final int screenHeight = 1200;

    int paletteRows = 2;
    int paletteCols = 17;
    int gridSize = 48;

    // the cols and rows within the painting canvas
    final int gridCols = 20;
    final int gridRows = 20;

    public MouseHandler mouse = new MouseHandler(this,paletteCols,paletteRows,gridSize,gridCols,gridRows);

    public gridManager grid = new gridManager(this, mouse,paletteRows,paletteCols,gridRows,gridCols);

    Thread appThread;

    public final int FPS = 60;

    // file menu stuff
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveAsNew = new JMenuItem("Save As");
    JMenuItem save = new JMenuItem("Save");

    public JFrame window;



    public JDialog fileDialog;

    private FileDialogHandler fileHandle;


    public CanvasPanel(JFrame window) {

        this.window = window;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addMouseListener(mouse);

        fileHandle = new FileDialogHandler(window);

        saveAsNew.setFont(new Font("Arial", Font.BOLD, 20));
        openFile.setFont(new Font("Arial", Font.BOLD, 20));
        save.setFont(new Font("Arial", Font.BOLD, 20));
        // add the file menu options
        fileMenu.add(openFile);
        fileMenu.add(saveAsNew);
        fileMenu.add(save);
        menuBar.add(fileMenu);

        fileMenu.setFont(new Font("Arial", Font.BOLD, 20));

        window.setJMenuBar(menuBar);
        window.add(this);


        // functionality for menu bar items

        openFile.addActionListener(e -> openFileAction(e));
        saveAsNew.addActionListener(e -> saveAsNewAction(e));
        save.addActionListener(e -> saveAction(e));

        fileDialog = new JDialog(window,"Enter File Name", true);

    }

    // Action methods for menu bar items


    // open a file
    public void openFileAction(ActionEvent e) {
        fileHandle.openFile();
    }

    public void saveAsNewAction(ActionEvent e) {
        fileHandle.saveFile();
    }

    public void saveAction(ActionEvent e) {

    }



    public void startApp() {

        appThread = new Thread(this);
        appThread.start();


    }

    @Override
    public void run() {

//        double drawInterval = (double) 1000000000 /FPS;
//        double delta = 0;
//        long lastTime = System.nanoTime();
//        long currentTime;


        while(appThread != null) {


            update();
            repaint();

//            currentTime = System.nanoTime();
//
//            delta += (currentTime - lastTime) / drawInterval;
//
//            lastTime = currentTime;
//
//
//            if(delta >= 1) {
//
//
//                delta--;
//
//            }

        }
    }

    public void update() {
        grid.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        grid.draw(g2);



    }

    public void printTileArray() {

        for(int i = 0;i<gridCols;i++)
        {
            for(int j = 0;j<gridRows;j++) {

                System.out.print(grid.mouse.tileArray[i][j] + " ");

                //grid.drawTile(g2,grid.tileX,grid.tileY.);
            }
            System.out.println();
        }


    }


}
