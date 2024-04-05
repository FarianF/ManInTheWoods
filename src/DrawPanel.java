import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawPanel extends JPanel {
    private Rectangle button;
    private Image background;

    protected void paintComponent(Graphics g){
        try{
            background = ImageIO.read(new File(".idea/Forests/TitleScreen.gif"));
            } catch (IOException e){
            background = null;
        }
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        }
    }
