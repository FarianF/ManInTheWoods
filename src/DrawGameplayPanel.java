import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;


public class DrawGameplayPanel extends JPanel implements MouseListener {
    private BufferedImage image;


    private WorldReader test = new WorldReader();
    private ArrayList<String> world = new ArrayList<>();




    public DrawGameplayPanel() {
        this.addMouseListener(this);
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        test.generateWorld();
        world = new ArrayList<String>(Arrays.asList(test.getData().split("S")));
        for(String word : world){
            String[] list = word.split("\\.");
        }


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

