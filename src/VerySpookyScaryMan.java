import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class VerySpookyScaryMan {
    private int row;
    private int col;
    private SpriteLoader[][] gameMap;
    private Player user;
    private List<String> path;
    private BufferedImage image;

    public VerySpookyScaryMan(int row, int col, SpriteLoader[][] gameMap, Player user) {
        this.row = row;
        this.col = col;
        this.gameMap = gameMap;
        this.user = user;
        this.path = new ArrayList<>();
        this.image = loadImage("Sprites/TinierSpookyLilDude.png");
    }

    public BufferedImage loadImage(String fileName) {
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException e) {
            System.out.println("Error loading image: " + e);
            return null;
        }
    }

    public void update() {
        if (hasLineOfSight()) {
            calculatePath();
            move();  // Move based on the new path
        } else if (!path.isEmpty()) {
            move();  // Continue following the last known path if the player is out of sight
        } else {
            searchOrPatrol();  // Search or patrol if no path and no line of sight
        }
        checkAndAttackPlayer();  // Check if within attack range to attack
    }

    private void moveTowardsPlayer(){

    }




    private void move() {
        if (!path.isEmpty()) {
            String[] nextMove = path.remove(0).split(",");
            this.row = Integer.parseInt(nextMove[0]);
            this.col = Integer.parseInt(nextMove[1]);

            if (isAdjacentToPlayer()) {
                path.clear(); // Clear the path if adjacent to stop further movement
            }
        }
    }





    private void checkAndAttackPlayer() {
        if (isAdjacentToPlayer()) {
            user.takeDamage(); // Assuming damage function takes amount as parameter
        }
    }

    private void searchOrPatrol() {
        List<int[]> directions = getWeightedDirectionsTowardsPlayer();
        for (int[] direction : directions) {
            if (tryMove(direction[0], direction[1])) {
                break; // Stop if move successful
            }
        }
    }

    private List<int[]> getWeightedDirectionsTowardsPlayer() {
        List<int[]> directions = new ArrayList<>();
        int dx = Integer.signum(user.getCol() - col);
        int dy = Integer.signum(user.getRow() - row);

        directions.add(new int[]{dx, 0}); // Horizontal step towards the player
        directions.add(new int[]{0, dy}); // Vertical step towards the player
        directions.add(new int[]{-dx, 0}); // Opposite horizontal
        directions.add(new int[]{0, -dy}); // Opposite vertical

        return directions;
    }

    private boolean tryMove(int dx, int dy) {
        int newX = col + dx;
        int newY = row + dy;
        if (isValid(newX, newY)) {
            col = newX;
            row = newY;
            return true;
        }
        return false;
    }

    private void calculatePath() {
        path.clear();
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(n -> n.fCost));
        HashSet<Node> closedSet = new HashSet<>();
        Node startNode = new Node(row, col, null, 0, estimateHeuristic(row, col));
        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            Node currentNode = openSet.poll();
            closedSet.add(currentNode);

            // Stop path calculation if the current node is adjacent to the player
            if (isAdjacentToPlayer(currentNode.row, currentNode.col)) {
                reconstructPath(currentNode);
                return;
            }

            // Explore neighbors
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
            for (int[] direction : directions) {
                int newRow = currentNode.row + direction[0];
                int newCol = currentNode.col + direction[1];
                if (isValid(newRow, newCol) && !closedSet.contains(new Node(newRow, newCol, null, 0, 0))) {
                    Node neighbor = new Node(newRow, newCol, currentNode, currentNode.gCost + 1, estimateHeuristic(newRow, newCol));
                    if (!openSet.contains(neighbor) || currentNode.gCost + 1 < neighbor.gCost) {
                        neighbor.gCost = currentNode.gCost + 1;
                        neighbor.fCost = neighbor.gCost + neighbor.hCost;
                        neighbor.parent = currentNode;
                        openSet.add(neighbor);
                    }
                }
            }
        }
    }


    private boolean hasLineOfSight() {
        int maxDistance = 10;  // Define the sight distance
        // Directions include right, down, left, up, and the four diagonals
        int[][] directions = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}, // Cardinal directions: right, down, left, up
                {1, 1}, {-1, 1}, {1, -1}, {-1, -1} // Diagonal directions: NE, SE, NW, SW
        };

        for (int[] dir : directions) {
            int checkRow = row;
            int checkCol = col;
            for (int i = 0; i <= maxDistance; i++) {
                checkRow += dir[0];
                checkCol += dir[1];

                // Check if we've reached the player
                if (checkRow == user.getRow() && checkCol == user.getCol()) {
                    return true;
                }

                // Check if the path is blocked by an obstacle or is out of bounds
                if (!isValid(checkRow, checkCol)) {
                    break;  // Stop if hits an invalid position or obstacle
                }
            }
        }
        return false;  // Player not found within line of sight
    }


    private boolean isAdjacentToPlayer(int nodeRow, int nodeCol) {
        // Check if the given node position is adjacent to the player's position
        return Math.abs(user.getRow() - nodeRow) <= 1 && Math.abs(user.getCol() - nodeCol) <= 1;
    }

    private boolean isAdjacentToPlayer() {
        return Math.abs(user.getRow() - row) <= 1 && Math.abs(user.getCol() -col) <= 1;
    }



    private void reconstructPath(Node currentNode) {
        while (currentNode != null) {
            path.add(0, currentNode.row + "," + currentNode.col);
            currentNode = currentNode.parent;
        }
    }

    private int estimateHeuristic(int row, int col) {
        return Math.abs(row - user.getRow()) + Math.abs(col - user.getCol());
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < gameMap.length && col >= 0 && col < gameMap[0].length && (gameMap[row][col].getSpriteType() == 0 || gameMap[row][col].getSpriteType() == 3);
    }

    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }
    public int getCol() { return col; }
    public void setCol(int col) { this.col = col; }
    public BufferedImage getImage() { return image; }
    public void setImage(BufferedImage image) { this.image = image; }

    private class Node {
        int row, col;
        Node parent;
        int gCost, hCost, fCost;

        Node(int row, int col, Node parent, int gCost, int hCost) {
            this.row = row;
            this.col = col;
            this.parent = parent;
            this.gCost = gCost;
            this.hCost = hCost;
            this.fCost = gCost + hCost;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return row == node.row && col == node.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
