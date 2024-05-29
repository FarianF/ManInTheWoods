import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class  WorldReader {
    private ArrayList<String> data = new ArrayList<>();
    private SpriteLoader[][] gameMap;
    private Player user;
    private ArrayList<GasCan> items = new ArrayList<GasCan>();
    private int fileLength;
    private int fileSize;
    private boolean startExists;

    private int itmAmt;

    private VerySpookyScaryMan badGuy;




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
                if(gameMap[currentPlayerRow - 1][currentPlayerColumn].getSpriteType() != 1) {
                    user.setRow(currentPlayerRow - 1);
                } else if(user.getChainSawDurability() != 0){
                    gameMap[currentPlayerRow - 1][currentPlayerColumn].setSpriteType(3);
                    user.useChainSaw();
                }
                }
            }
        if(direction.equals("E")){
            if(currentPlayerColumn < gameMap[0].length - 1){
                if (gameMap[currentPlayerRow][currentPlayerColumn + 1].getSpriteType() != 1) {
                    user.setCol(currentPlayerColumn + 1);
                } else if (user.getChainSawDurability() != 0) {
                    gameMap[currentPlayerRow][currentPlayerColumn + 1].setSpriteType(3);
                    user.useChainSaw();
                }
            }
        }
        if(direction.equals("W")){
            if(currentPlayerColumn > 0){
                if(gameMap[currentPlayerRow][currentPlayerColumn - 1].getSpriteType() != 1){
                    user.setCol(currentPlayerColumn - 1);
                } else if(user.getChainSawDurability() != 0){
                    gameMap[currentPlayerRow][currentPlayerColumn - 1].setSpriteType(3);
                    user.useChainSaw();
                }
            }
        }
        if(direction.equals("S")){
            if(gameMap[currentPlayerRow + 1][currentPlayerColumn].getSpriteType() != 1){
                user.setRow(currentPlayerRow + 1);
            } else if (user.getChainSawDurability() != 0) {
                gameMap[currentPlayerRow +1][currentPlayerColumn].setSpriteType(3);
                user.useChainSaw();
            }
        }
        for(GasCan item : items){
            if(user.getRow() == item.getRow() && user.getCol() == item.getCol() && user.getPlayerInv() >= item.getItemSize() && gameMap[user.getRow()][user.getCol()].isHasItem() == true){
                item.setCollected();
                user.setPlayerInv(item.getItemSize());
                user.addItemCollected(item.getItemSize());
                gameMap[item.getRow()][item.getCol()].itemCollected();
            }
        }

        }

    public void dropItem(){
        if((user.getItemsCollected().size() -1) > -1) {
            GasCan item = new GasCan(user.getRow(), user.getCol());
            item.setItemSize(items.get(items.size() - 1).getItemSize());
            items.add(item);
            gameMap[item.getRow()][item.getCol()].setHasItem();
            user.setPlayerInv(-user.getItemsCollected().get(user.getItemsCollected().size() - 1));
            user.setItemsCollected();
            gameMap[user.getRow()][user.getCol()].setHasItem();

        }

    }

    public void inventory(){
        System.out.println(user.getItemsCollected());
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
        itmAmt = (int) (Math.random()*1)+5;
        generateItems(itmAmt);
        generateEnemies();
    }
    public int[][] getWorld(){
        StringBuilder part1 = new StringBuilder();
        fileLength = (int) (Math.random()*6)+15;
        fileSize = (int) (Math.random()*20)+10;
        int count = 0;
        for(int i = 0; i < fileLength; i++){
            for(int j = 0; j< fileSize; j++) {
                int rand = (int) (Math.random() * 10) + 1;
                if (rand < 8) {
                    int random = (int) (Math.random()*999)+1;
                    if(random > 25 && startExists == false){
                        startExists = true;
                        part1.append('S');
                    } else if(random < 25 && count < 5){
                        count++;
                        part1.append('G');


                    } else {
                        part1.append('#');
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

        for(String levelPiece : data){
            levelPiece.replace(levelPiece.charAt(3), 'G');
                data.set(data.indexOf(levelPiece), levelPiece);
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
                if(pieceOfWorld.charAt(j) == 'G'){
                    worldGen[i][j] = 3;
                }
                if(pieceOfWorld.charAt(j) == 'S'){
                    this.user = new Player(i, j);
                }
            }
        }


        return worldGen;
    }

    public void generateItems(int itmAmt){
        ArrayList<Point> itemPoint = new ArrayList<Point>();
        for(int r = 0; r < gameMap.length; r++){
            for(int c = 0; c < gameMap[0].length; c++){
                if(gameMap[r][c].getSpriteType() == 0){
                    itemPoint.add(new Point(r, c));
                }
            }
        }
        int itemCreated = 0;
        while(itemCreated != itmAmt){
            int randomItemPoint = (int) (Math.random() * itemPoint.size());
            Point itemPlacement = itemPoint.remove(randomItemPoint);
            int row = (int)(itemPlacement.getX());
            int col = (int)(itemPlacement.getY());
            items.add(itemCreated, new GasCan(row, col));
            gameMap[row][col].setHasItem();
            itemCreated++;
        }
    }

    public void generateEnemies(){
        int row = (int) (Math.random()*((fileLength-1)));
        int col = (int) (Math.random()*(fileSize-1));

        Point enemy = new Point(row, col);

        for(int r = 0; r < gameMap.length; r++){
            for(int c = 0; c < gameMap[0].length; c++){
                Point enemyLocation = new Point(r, c);
                if(enemyLocation.equals(enemy)){
                    badGuy = new VerySpookyScaryMan(r, c);
                    gameMap[r][c].setEnemySpawn();
                }
            }
        }
    }
    public ArrayList<GasCan> getItems(){
        return items;
    }



    public ArrayList<String> getData(){
        return data;
    }


    public SpriteLoader[][] getGameMap(){
        return gameMap;
    }

    public VerySpookyScaryMan getBadGuy(){
        return badGuy;
    }
}
