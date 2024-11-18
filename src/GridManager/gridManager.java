package GridManager;

import main.CanvasPanel;
import main.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class gridManager {

    CanvasPanel cp;
    // array for the final images
    //public int[][] tileArray;

    // array for the tile images
    public Tile[] tileImageArray;

    public final int totalImages = 35;

    // array for the images
    public int[][] paletteArray;
    // pixle size of each grid cell
    public final int gridSize = 48;

    // count of grid cells
    public int gridRows;
    public int gridCols;
    public int paletteRows;
    public int paletteCols;
    public int tileX;
    public int tileY;

    // screen location offeset for the image palette
    private final int paletteXoffset = 100;
    private final int paletteYoffset = 1050;

    public Point[][] imagePos;

    public MouseHandler mouse;

    // image index for what image was selected in the image Array
    private int imageIndex;

    public gridManager(CanvasPanel cp, MouseHandler mouse, int rows, int cols, int gridRows, int gridCols) {

        this.cp = cp;
        this.mouse = mouse;
        this.paletteRows = rows;
        this.paletteCols = cols;
        this.gridCols = gridCols;
        this.gridRows = gridRows;
        imagePos = new Point[rows][cols];
        //tileArray = new int[gridCols][gridRows];
        // Palette array for selection tiles
        paletteArray = new int[rows][cols];
        tileImageArray = new Tile[totalImages];

        getTileImage();


    }

    public void update() {

    }

    // load the tile images
    public void getTileImage() {

        try {

            for(int i = 0;i<totalImages;i++) {
                tileImageArray[i] = new Tile();
            }

            tileImageArray[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/blank.png")));
            tileImageArray[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/grass01.png")));
            tileImageArray[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/floor01.png")));
            tileImageArray[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water01.png")));
            tileImageArray[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/earth.png")));
            tileImageArray[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/tree.png")));
            tileImageArray[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road00.png")));
            tileImageArray[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road01.png")));
            tileImageArray[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road02.png")));
            tileImageArray[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road03.png")));
            tileImageArray[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road04.png")));
            tileImageArray[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road05.png")));
            tileImageArray[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road06.png")));
            tileImageArray[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road07.png")));
            tileImageArray[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road08.png")));
            tileImageArray[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road09.png")));
            tileImageArray[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road10.png")));
            tileImageArray[17].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road11.png")));
            tileImageArray[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/road12.png")));
            tileImageArray[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/table01.png")));
            tileImageArray[20].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/hut.png")));
            tileImageArray[21].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/wall.png")));
            tileImageArray[22].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/grass00.png")));
            tileImageArray[23].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water02.png")));
            tileImageArray[24].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water03.png")));
            tileImageArray[25].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water04.png")));
            tileImageArray[26].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water05.png")));
            tileImageArray[27].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water06.png")));
            tileImageArray[28].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water07.png")));
            tileImageArray[29].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water08.png")));
            tileImageArray[30].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water09.png")));
            tileImageArray[31].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water10.png")));
            tileImageArray[32].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water11.png")));
            tileImageArray[33].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water12.png")));
            tileImageArray[34].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/TileImages/water13.png")));

            int ySpacing = 0;
            int xSpacing = 0;

            // x and y position for the image palette
            for(int i = 0;i<2;i++) {

                for(int j = 0;j<17;j++) {


                    imagePos[i][j] = new Point(
                            (j * gridSize) + paletteXoffset + xSpacing,
                            (i * gridSize) + paletteYoffset + ySpacing
                    );
                    xSpacing += 10;
                }
                xSpacing = 0;
                ySpacing = 10;
            }

            // give the image Pos to the MouseHandler
            mouse.setImagePosArray(imagePos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // drawing function

    public void draw(Graphics2D g2) {

        g2.setColor(Color.black);
        int imageIndex = 0;
        int xSpacing = 0;
        int ySpacing = 0;

        // outline for the image box
        g2.drawRect(90,1045,995,115);

        // images for selecting the images
        for(int i = 0;i<2;i++) {

            for(int j = 0;j<17;j++) {

                // draw the image palette
                g2.drawImage(tileImageArray[imageIndex].image,
                        (j*gridSize)+paletteXoffset+xSpacing,
                        (i*gridSize)+paletteYoffset+ySpacing,
                        gridSize,
                        gridSize,
                        null);

                imageIndex++;
                xSpacing += 10;
            }
            xSpacing = 0;
            ySpacing = 10;

        }

        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.setColor(Color.BLACK);
        g2.drawString("Current Tile", 1040,160);
        g2.drawImage(tileImageArray[mouse.imageIndex].image,1050,50,80,80,null);

        g2.setColor(Color.BLUE);

        for(int i = 0;i<gridRows;i++) {

            for(int j = 0;j<gridCols;j++)
            {
                // X lines
                g2.drawLine(0,i*gridSize,gridSize*gridRows,i*gridSize);
                // Y lines
                g2.drawLine(i*gridSize,0,i*gridSize,gridSize*gridCols);

                g2.drawImage(tileImageArray[mouse.tileArray[j][i]].image,i*gridSize,j*gridSize,gridSize,gridSize,null);

            }
        }
    }





}
