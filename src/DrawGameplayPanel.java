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


public class DrawGameplayPanel extends JLayeredPane implements MouseListener {
    private BufferedImage image;


    private WorldReader test = new WorldReader();



    public DrawGameplayPanel() {
        this.addMouseListener(this);
    }


    protected void paintComponent(Graphics g) {
        int x = 10;
        int y = 10;
        super.paintComponent(g);
        try{
            image = ImageIO.read(new File("Sprites/Gas (1).png"));
        } catch (IOException e){
            image = null;
        }
        for(int r = 0; r < test.getGameMap().length; r++){
            for(int c = 0; c < test.getGameMap()[0].length; c++){
                SpriteLoader sprite = test.getGameMap()[r][c];
                g.drawImage(sprite.getImage(), x, y, null);
                if(sprite.getSpriteType() == 0){
                }
                x += 33;
            }
            x = 10;
            y += 45;

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

