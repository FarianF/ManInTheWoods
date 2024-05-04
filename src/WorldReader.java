import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class WorldReader {
    private ArrayList<String> data = new ArrayList<>();
    private SpriteLoader[][] gameMap;

    public WorldReader(){
        generateWorld();
    }


    private void generateWorld(){
        int[][] worldData = getWorld("Worlds/Forest1");

        gameMap = new SpriteLoader[8][23];
        for(int r = 0; r < gameMap.length; r++ ){
            for(int c = 0; c < gameMap[0].length; c++){
                SpriteLoader t = new SpriteLoader(worldData[r][c], r, c);
                gameMap[r][c] = t;
            }
        }
    }
    public int[][] getWorld(String fileName){
        File myObj = new File(fileName);
        Scanner s = null;
        try{
            s = new Scanner(myObj);
            while(s.hasNextLine()){
                data.add(s.nextLine());
            }
        } catch(FileNotFoundException e){
            System.exit(1);
        }


        int r = data.size();
        int c = data.get(0).length();

        int[][] worldGen = new int[r][c];

        for(int i = 0; i < data.size(); i++){
            String pieceOfWorld = data.get(i);
            for(int j = 0; j < pieceOfWorld.length(); j++){
                if(pieceOfWorld.charAt(j) == '.'){
                    worldGen[i][j] = 1;
                }
                if(pieceOfWorld.charAt(j) == '#'){
                    worldGen[i][j] = 0;
                }
            }
        }
        return worldGen;
    }



    public ArrayList<String> getData(){
        return data;
    }

    public SpriteLoader[][] getGameMap(){
        return gameMap;
    }
}
