import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class DrawGameplayPanel extends JPanel implements MouseListener {
    private BufferedImage image;


    private WorldReader test = new WorldReader();

    private Image background;


    public DrawGameplayPanel() {
        this.addMouseListener(this);
    }


    protected void paintComponent(Graphics g) {
        int[][] blah = test.generateWorld();
        int x = 0;
        int y = 0;
        super.paintComponent(g);
        try{
            image = ImageIO.read(new File("Sprites/Gas (1).png"));
        } catch (IOException e){
            image = null;
        }
        ImageIcon icon = new ImageIcon("Sprites/Gas (1).png");
        for(int r = 0; r < blah.length; r++){
            for(int c = 0; c < blah[0].length; c++){
                if(blah[r][c] == 1){
                    g.drawImage(icon.getImage(), x, y, null);
                    x += 20;
                }
            }
        }
        this.setOpaque(true);
        this.setBackground(Color.BLACK);



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

