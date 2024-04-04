import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class DrawPanel extends JPanel {
    private Rectangle button;

    protected void paintComponent(Graphics g){
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("Start Game", 150, 120);
        g.drawRect(150, 120, 10, 50);
    }
}
