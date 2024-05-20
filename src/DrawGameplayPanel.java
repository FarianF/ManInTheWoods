import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class DrawGameplayPanel extends JPanel implements MouseListener, KeyListener {
    private  WorldReader test = new WorldReader();



    public DrawGameplayPanel() {
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
    }


    protected void paintComponent(Graphics g) {
        int x = 10;
        int y = 10;

        int playerX = test.getUser().getRow();
        int playerY = test.getUser().getCol();
        super.paintComponent(g);
        for(int r = 0; r < test.getGameMap().length; r++){
            for(int c = 0; c < test.getGameMap()[0].length; c++){
                SpriteLoader sprite = test.getGameMap()[r][c];
                g.drawImage(sprite.getImage(), x, y, null);




                if(r == playerX && c == playerY){
                    g.drawImage(test.getUser().getImage(),x + 2, y + 2, null);
                }
                x = x + 33;
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

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if(c == 'w'){
            test.movePlayer("N");
        }
        if(c == 's'){
            test.movePlayer("S");
        }
        if(c == 'a'){
            test.movePlayer("W");
        }
        if(c == 'd'){
            test.movePlayer("E");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

