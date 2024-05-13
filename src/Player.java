import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private int row;
    private int col;
    private BufferedImage image;

    private String playerSprite;


    public Player(int row, int col){
        this.row = row;
        this.col = col;
        image = loadImage("Sprites/Gas (1).png");
    }

    public BufferedImage loadImage(String fileName) {
        try {
            BufferedImage image;
            image = ImageIO.read(new File(fileName));
            return image;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }
}
