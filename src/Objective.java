import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Objective {
    private int row;

    private int col;

    private BufferedImage image;

    public Objective(int row, int col){
        this.row = row;
        this.col = col;
        image = loadImage("Sprites/Car.png");
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


}
