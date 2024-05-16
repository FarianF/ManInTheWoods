import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class WorldReader {
    private ArrayList<String> data = new ArrayList<>();
    private SpriteLoader[][] gameMap;
    private Player user;
    private int fileLength;


    private int fileSize;
    private boolean startExists;




    public WorldReader(){
        generateWorld();
    }

    public Player getUser(){
        return user;
    }

    public void movePlayer(String direction){
        int currentPlayerRow = user.getRow();
        int currentPlayerColumn = user.getCol();

        if(direction.equals("N")){
            if(currentPlayerRow > 0){
                if(gameMap[currentPlayerColumn -1][currentPlayerColumn].getSpriteType() != 1)
                user.setRow(currentPlayerRow - 1);
                }
            }
        if(direction.equals("E")){
            if(currentPlayerColumn < gameMap[0].length - 1){
                if (gameMap[currentPlayerRow][currentPlayerColumn + 1].getSpriteType() != 1) {
                    user.setCol(currentPlayerColumn + 1);
                }
            }
        }
        if(direction.equals("W")){
            if(currentPlayerColumn > 0){
                if(gameMap[currentPlayerRow][currentPlayerColumn - 1].getSpriteType() != 1){
                    user.setCol(currentPlayerColumn - 1);
                }
            }
        }
        if(direction.equals("S")){
            if(gameMap[currentPlayerRow + 1][currentPlayerColumn].getSpriteType() != 1){
                user.setRow(currentPlayerRow + 1);
            }
        }

        }





    private void generateWorld(){
        int[][] worldData = getWorld();


        gameMap = new SpriteLoader[fileLength+2][fileSize+2];
        for(int r = 0; r < gameMap.length; r++ ){
            for(int c = 0; c < gameMap[0].length; c++){
                SpriteLoader t = new SpriteLoader(worldData[r][c], r, c);
                gameMap[r][c] = t;
            }
        }
    }
    public int[][] getWorld(){
        StringBuilder part1 = new StringBuilder();
        fileLength = (int) (Math.random()*6)+15;
        fileSize = (int) (Math.random()*20)+10;
        for(int i = 0; i < fileLength; i++){
            for(int j = 0; j< fileSize; j++) {
                int rand = (int) (Math.random() * 10) + 1;
                if (rand < 8) {
                    int random = (int) (Math.random()*2)+1;
                    if(random == 1 && startExists == false){
                        startExists = true;
                        part1.append('S');
                    } else {
                        part1.append("#");
                    }
                } else {
                    part1.append(".");
                }
            }


            part1.append("\n");
        }


        for(int k = 0; k<fileSize; k++){
            part1.append(".");
        }
        String part2 = String.valueOf(part1);
        try {
            FileWriter test = new FileWriter("Worlds/Forest1");
            test.write(part2);


            test.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        File test2 = new File("Worlds/Forest1");
        Scanner s = null;
        try{
            s = new Scanner(test2);
            while(s.hasNextLine()){
                data.add(s.nextLine());
            }
        } catch(FileNotFoundException e){
            System.exit(1);
        }
        String l = "";
        for(int k = 0; k < fileSize+2; k++){
            l += ".";
        }


        data.add(0,l);
        data.set(data.size()-1, l);
        String ugly2 = "";
        for(int z = 1; z < data.size()-1; z++){
            ugly2 = "." + data.get(z) + ".";
            data.set(z, ugly2);
        }


        try {
            FileWriter testPt2 = new FileWriter("Worlds/FinalForest");
            for(String ugly : data){
                testPt2.write(ugly+"\n");
            }


            testPt2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                if(pieceOfWorld.charAt(j) == 'S'){
                    worldGen[i][j] = 2;
                }
                if(pieceOfWorld.charAt(j) == 'S'){
                    this.user = new Player(i, j);
                }
            }
        }


        return worldGen;
    }


    public void playerMovement(String direction){
        if(direction.equals("N")){


        }
    }






    public ArrayList<String> getData(){
        return data;
    }


    public SpriteLoader[][] getGameMap(){
        return gameMap;
    }
}
