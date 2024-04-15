import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawPanel extends JPanel {
    private Rectangle button;
    private Image background;

    protected void paintComponent(Graphics g){
        try{
            background = ImageIO.read(new File("Forests/Forest2.jpg"));
            } catch (IOException e){
            background = null;
        }
        ImageIcon icon = new ImageIcon("Forests/Forest2.jpg");
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        super.paintComponent(g);
        g.drawImage(icon.getImage(), 0, 0, null);
        }
    }
