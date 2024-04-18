import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GameplayWindowFrame extends JFrame implements Runnable {
    private DrawGameplayPanel p;
    private WindowFrame x;
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
        this.setLocation(600, 100);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        startThread();
        world = test.generateWorld();
        for(int r = 0; r < test.getWorlds().size(); r++){
            for(int c = 0; c<test.getWorlds())
        }
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
