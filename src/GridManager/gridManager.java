package GridManager;

import main.CanvasPanel;

import java.awt.*;

public class gridManager {

    CanvasPanel cp;
    public int[][] tileArray;

    // pixle size of each grid cell
    public final int gridSize = 48;

    // count of grid cells
    public final int gridXcount = 20;
    public final int gridYcount = 20;

    public gridManager(CanvasPanel cp) {

        this.cp = cp;


    }


    // drawing function

    public void draw(Graphics2D g2) {

        g2.setColor(Color.black);


        for(int i = 0;i<gridXcount;i++) {

            for(int j = 0;j<gridYcount;j++)
            {

            }

        }

        g2.setColor(Color.BLUE);
        //g2.draw(new Rectangle(48,48));
        for(int i = 0;i<=gridXcount;i++) {

            for(int j = 0;j<=gridYcount;j++)
            {
                // X lines
                g2.drawLine(0,i*gridSize,gridSize*gridXcount,i*gridSize);
                // Y lines
                g2.drawLine(i*gridSize,0,i*gridSize,gridSize*gridYcount);


            }

        }



    }

}
