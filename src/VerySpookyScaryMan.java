import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VerySpookyScaryMan {

    private int row;
    private int col;

    private int damage;

    private BufferedImage image;


    public VerySpookyScaryMan(int row, int col){
        this.row = row;
        this.col = col;
        damage = 20;
        image = loadImage("Sprites/CharacterRun.gif");
    }

    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
    public BufferedImage getImage(){
        return image;
    }

    public BufferedImage loadImage(String fileName) {
        try {
            BufferedImage image;
            image = ImageIO.read(new File(fileName));
            return image;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean moveToPlayer(SpriteLoader[][] map, Player user){
        try{
            if(map[row + 1][col].getSpriteType() != 1){
                if(user.getRow() - (row + 1) < user.getRow() - (row - 1)) {
                    row++;
                    return true;
                }
            }
        } catch (IndexOutOfBoundsException e){
            return false;
        }
        return false;
    }


}
