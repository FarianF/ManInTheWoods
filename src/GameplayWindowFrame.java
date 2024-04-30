import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class GameplayWindowFrame extends JFrame implements Runnable {
    private DrawGameplayPanel p;
    private Thread windowThread;
    private WorldReader test =  new WorldReader();

    private ArrayList<String> world = new ArrayList<>();

    public GameplayWindowFrame(String display) {
        super(display);
        int frameWidth = 800;
        int frameHeight = 800;
        p = new DrawGameplayPanel();
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(0, 0);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        startThread();

    }

    public void startThread () {
        windowThread = new Thread(this);
        windowThread.start();
    }


    public void run() {
        while(true){
            p.repaint();
        }
    }

}
