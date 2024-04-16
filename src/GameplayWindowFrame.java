import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GameplayWindowFrame extends JFrame implements Runnable {
    private DrawGameplayPanel p;
    private WindowFrame x;
    private Thread windowThread;

    public GameplayWindowFrame(String display) {
        super(display);
        int frameWidth = 563;
        int frameHeight = 360;
        p = new DrawGameplayPanel();
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(600, 100);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.dispatchEvent(new WindowEvent(x, WindowEvent.WINDOW_CLOSING));
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
