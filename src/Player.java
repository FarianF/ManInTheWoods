import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;




public class Player {
    private int row;
    private int col;
    private BufferedImage image;
    private int playerInv;


    private ArrayList<Integer> itemsCollected = new ArrayList<Integer>();


    private int chainSawDurability;


    private int health;




    public Player(int row, int col){
        this.row = row;
        this.col = col;
        image = loadImage("Sprites/CharacterRun.gif");
        playerInv = 20;
        health = 100;
        chainSawDurability = 50;


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

    public void takeDamage(){
        health -= 20;
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


    public void useChainSaw(){
        chainSawDurability -= 5;
    }
    public void fuelChainSaw(){


        chainSawDurability++;
    }
    public int getPlayerInv(){
        return playerInv;
    }


    public int getChainSawDurability(){
        return chainSawDurability;
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
