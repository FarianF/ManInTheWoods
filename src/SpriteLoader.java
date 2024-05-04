import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class SpriteLoader {

    private BufferedImage image;
    private int spriteType;

    private final String gasCan = "Sprites/Gas (1).png";

    private final String tree1 = "Sprites/TREE1.png";

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
            image = loadImage(tree1);
        }
        if(spriteType == 0){
            image = loadImage(gasCan);
        }
    }

    public BufferedImage getImage(){
        return image;
    }
}
