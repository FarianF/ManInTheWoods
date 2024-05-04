import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class SpriteLoader {

    private BufferedImage image;
    private int spriteType;

    private final String gasCan = "Sprites/Gas (1).png";


    int r;
    int c;

    public SpriteLoader(int spriteType, int r, int c) {
        this.setSpriteType(spriteType);
        this.r = r;
        this.c = c;
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

    }


    public BufferedImage getImage(){
        return image;
    }

    public int getSpriteType(){
        return spriteType;
    }
}
