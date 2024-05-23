import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player {
    private int row;
    private int col;
    private BufferedImage image;
    private int playerInv;

    private ArrayList<Integer> itemsCollected = new ArrayList<Integer>();


    public Player(int row, int col){
        this.row = row;
        this.col = col;
        image = loadImage("Sprites/Gas (1).png");
        playerInv = 20;

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
    public BufferedImage getImage(){
        return image;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setPlayerInv(int itemSize){
        playerInv = playerInv - itemSize;
    }
    public int getPlayerInv(){
        return playerInv;
    }

    public void addItemCollected(int itemSize){
        itemsCollected.add(itemSize);
    }
    public ArrayList<Integer> getItemsCollected(){
        return itemsCollected;
    }

    public void setItemsCollected(){
        itemsCollected.remove(itemsCollected.size()-1);
    }
}
