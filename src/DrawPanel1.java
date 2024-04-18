import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class DrawPanel1 extends JPanel implements MouseListener {
    private Rectangle button;
    private GameplayWindowFrame game;
    private Rectangle loadButton;
    private Image background;

    public DrawPanel1(){
        this.addMouseListener(this);
        button = new Rectangle(180, 50, 200, 35);
        loadButton = new Rectangle(180, 150, 200, 35);

    }

    protected void paintComponent(Graphics g){
        try{
            background = ImageIO.read(new File("Forests/Forest2.jpg"));
            } catch (IOException e){
            background = null;
        }
        int x = 180;
        int y = 50;
        ImageIcon icon = new ImageIcon("Forests/Forest2.jpg");
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        super.paintComponent(g);
        g.drawImage(icon.getImage(), 0, 0, null);
        g.setFont(new Font("Courier New", Font.BOLD, 40));
        g.drawString("New Game", 185, 80);
        g.setFont(new Font("Courier New", Font.BOLD, 35));
        g.drawString("Load Game", 185, 180);
        g.drawRect(x, y, 200, 35);
        g.drawRect(x, 150, 200, 35);
        }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clicked = e.getPoint();

        if(e.getButton() == 1 ){
            if(button.contains(clicked) || loadButton.contains(clicked)){
                game = new GameplayWindowFrame("Test2");
            }
        }

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
