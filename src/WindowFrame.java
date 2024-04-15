import javax.swing.JFrame;
import java.awt.*;

public class WindowFrame extends JFrame implements Runnable {
    private DrawPanel p;
    private Thread windowThread;

    public WindowFrame(String display) {
        super(display);
        int frameWidth = 563;
        int frameHeight = 360;
        p = new DrawPanel();
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(600, 100);
        this.setVisible(true);
        startThread();
    }

        public void startThread () {
            windowThread = new Thread(this);
            windowThread.start();
        }

        public void run () {
            while (true) {
                p.repaint();
            }
        }
    }
