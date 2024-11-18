package main;

import GridManager.gridManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    public int screenX = 0;
    public int screenY = 0;

    private int paletteRows;
    private int paletteCols;
    private int gridSize;

    private Point[][] imagePos;

    public int imageClickX;
    public int imageClickY;

    public CanvasPanel cp;

    public int[][] tileArray;
    public int imageIndex;

    private int gridCols;
    private int gridRows;


    public MouseHandler(CanvasPanel cp,int paletteCols, int paletteRows, int gridSize, int gridCols, int gridRows) {

        this.cp = cp;
        this.gridCols = gridCols;
        this.gridRows = gridRows;
        this.tileArray = new int[gridCols][gridRows];
        this.paletteRows = paletteRows;
        this.paletteCols = paletteCols;
        this.gridSize = gridSize;

        imagePos = new Point[paletteCols][paletteRows];

    }

    public void setImagePosArray(Point[][] imagePos)
    {
        this.imagePos = imagePos;
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        screenX = e.getX();
        screenY = e.getY();



        int tileX = (int) Math.floor((double) screenX/gridSize);
        int tileY = (int) Math.floor((double) screenY/gridSize);
        System.out.println("Click!");
        System.out.println(Math.floor((double) screenX /48) + ", " + Math.floor((double) screenY /48));

        // show the tile array to console
        cp.printTileArray();

        for(int i = 0;i < paletteRows;i++) {

            for(int j = 0;j<paletteCols;j++) {

                Point pos = imagePos[i][j];
                int x = pos.x;
                int y = pos.y;

                if(screenX >= x && screenX <= x + gridSize &&
                        screenY >= y && screenY <= y + gridSize) {
                    imageClickX = i;
                    imageClickY = j;
                    imageIndex = i * paletteCols + j;

                    System.out.println("If statement");
                    //return;
                }

            }
        }

        if(tileX < gridCols && tileY < gridRows) {

            System.out.println("If staasdftement");
            tileArray[tileY][tileX] = imageIndex;
        }

        // if shift is held down reset tile
        if(e.isShiftDown()) {
            tileArray[tileY][tileX] = 0;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
