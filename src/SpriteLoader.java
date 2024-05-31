import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class SpriteLoader {


    private BufferedImage image;
    private int spriteType;


    private final String gasCan = "Sprites/Gas (1).png";


    private boolean hasItem;


    private boolean enemySpawn;


    private boolean hasPlayer;




    int r;
    int c;


    public SpriteLoader(int spriteType, int r, int c) {
        this.setSpriteType(spriteType);
        this.r = r;
        this.c = c;
        this.hasItem = false;
        this.enemySpawn = false;
        this.hasPlayer = false;


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


    public void setSpriteType(int spriteType) {
        this.spriteType = spriteType;
        if(spriteType == 1){
            int treeType = (int) (Math.random()*2)+1;
            image = loadImage("Sprites/TREE" + treeType + ".png");
        }
        if(spriteType == 3){
            image = loadImage("Sprites/000000 (2).png");
        }






    }




    public BufferedImage getImage(){
        return image;
    }


    public int getSpriteType(){
        return spriteType;
    }


    public boolean isHasItem() {
        return hasItem;
    }


    public void setHasItem(){
        this.hasItem = true;
    }


    public void itemCollected(){
        this.hasItem = false;
    }


    public void setEnemySpawn(){
        this.enemySpawn = true;
    }


    public boolean isHasPlayer() {
        return hasPlayer;
    }


    public void setHasPlayer(boolean hasPlayer) {
        this.hasPlayer = hasPlayer;
    }
}
