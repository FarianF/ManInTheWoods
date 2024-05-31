import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class VerySpookyScaryMan {


    private int row;
    private int col;
    private int damage;

    private SpriteLoader[][] gameMap;
    private Player user;
    private ArrayList<String> path;
    private SpriteLoader[][] maze;
    private BufferedImage image;




    public VerySpookyScaryMan(int row, int col, SpriteLoader[][] gameMap, Player user){
        this.row = row;
        this.col = col;
        this.gameMap = gameMap;
        this.user = user;
        this.path = new ArrayList<>();
        maze = gameMap;
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

    public ArrayList<String> solveMaze() {
        explore(row, col);
        System.out.println("solveMaze");
        // Reverse the path to print it in the correct order
        ArrayList<String> reversedPath = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--) {
            reversedPath.add(path.get(i));
        }
        System.out.println(reversedPath);
        return reversedPath;
    }


    private boolean explore(int row, int col) {

        // Base case: If we reach the end of the maze
        if (row == user.getRow() && col == user.getCol()) {
            System.out.println("(" + row + "," + col + ")");
            System.out.println("end");
            return true;

        }

        // Check if current position is valid and not already visited
        if (isValid(row, col)) {
            // Mark current position as visited
            maze[row][col].setSpriteType(0);
            // Explore all possible directions
            if (explore(row + 1, col) || explore(row, col + 1) || explore(row - 1, col) || explore(row, col - 1)) {
                System.out.println("explore");
                path.add("(" + row + ", " + row + ")");
                return true;
            }

            // If no path found from this position, backtrack
            maze[row][col].setSpriteType(1);

        }

        return false;
    }


    private boolean isValid(int x, int y) {
        System.out.println("isValid");
        return x >= 0 && y >= 0 && x < gameMap.length && y < gameMap[0].length && gameMap[x][y].getSpriteType() == 0;
    }

}
