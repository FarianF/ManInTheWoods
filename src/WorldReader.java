import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class WorldReader {
    private ArrayList<String> data = new ArrayList<>();
    public int[][] generateWorld(){
        try{
            File myObj = new File("Worlds/Forest1");
            Scanner s = new Scanner(myObj);
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
            }
        }
        return worldGen;
    }



    public ArrayList<String> getData(){
        return data;
    }
}
