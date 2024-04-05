import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.*;
public class Window {
    private BufferedImage background;

    private BufferedImage getBackground(String fileName){
        File f = new File(fileName);
        Scanner s = null;
        try{
            s = new Scanner(f);
        } catch(FileNotFoundException e){
            System.out.println("No File Found");
            System.exit(1);
        }
            return null;
    }


}
