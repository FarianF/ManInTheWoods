import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawGameplayPanel extends JPanel implements MouseListener {
    private BufferedImage image;


    public DrawGameplayPanel() {
        this.addMouseListener(this);
        try{
            image = ImageIO.read(new File("Sprites/GasCan.png"));
        } catch (IOException e){
            System.exit(1);
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        g.drawImage(image, 0, 0, this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}