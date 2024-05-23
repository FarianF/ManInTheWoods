import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class GasCan {
    private int row;
    private int col;
    private BufferedImage image;

    private boolean isCollected;

    private int itemSize;

    public GasCan(int row , int col){
        this.row = row;
        this.col = col;
        image = loadImage("Sprites/Gas (1).png");
        isCollected = false;
        itemSize = (int) (Math.random()*15)+5;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public BufferedImage loadImage(String fileName) {
        try {
            BufferedImage image;
            image = ImageIO.read(new File(fileName));
            return image;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
    public BufferedImage getImage(){
        return image;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setCollected(){
        isCollected = true;
    }

    public boolean isCollected() {
        return isCollected;
    }
    public int getItemSize(){
        return itemSize;
    }

    public void setItemSize(int itemSize) {
        this.itemSize = itemSize;
    }
}
