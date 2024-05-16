import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class ImageHitBoxTesting {

    private int topLeft;
    private int topRight;
    private int bottomLeft;
    private int bottomRight;

    private BufferedImage image;
    public ImageHitBoxTesting(BufferedImage image){
        this.image = image;

        image.getHeight();
        image.getNumXTiles();
        image.getNumYTiles();
    }
}
