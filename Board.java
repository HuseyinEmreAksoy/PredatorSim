package Bil211;
import java.util.Random;

public class Board {
    static Organism[][] board = new Organism[20][20];
    static int numOfAnts;
    static int numOfDoodlebugs;
    Random randomNumGen = new Random();

    public Board() {
        numOfAnts = 100;
        numOfDoodlebugs = 150;
        putBug(numOfAnts, numOfDoodlebugs);
    }

    public void bugsCount() {// find how many bugs in the board
        int lastAnts = 0;
        int lastDoodlebugs = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (board[i][j] instanceof Ant)
                    lastAnts++;
                if (board[i][j] instanceof Doodlebug)
                    lastDoodlebugs++;
            }
        }
        numOfAnts = lastAnts;
        numOfDoodlebugs = lastDoodlebugs;
    }

    public Organism[][] getBoard() {
        return board;
    }

    public void putBug(int numAnt, int numDoodlebugs) {
        for (int i = 0; i < numAnt; i++) {
            placeBug(new Ant(), numAnt);
        }

        for (int i = 0; i < numDoodlebugs; i++) {
            placeBug(new Doodlebug(), numDoodlebugs);
        }
    }

    public boolean isOccupied(int row, int col) {
        if (Board.board[row][col] != null)
            return true;
        return false;
    }

    public void placeBug(Organism bug, int numBug) {
        //Declare and initialize random row and column values
        int row = randomNumGen.nextInt(20);
        int col = randomNumGen.nextInt(20);

        //Cycle through field until an empty cell is found
        while (isOccupied(row, col)) {
            row = randomNumGen.nextInt(20);
            col = randomNumGen.nextInt(20);
        }

        //Place a new Ant in open cell
        if (bug instanceof Ant) {
            board[row][col] = new Ant(row, col);
        }

        //Place a new Doodlebug in open cell
        else if (bug instanceof Doodlebug) {
            board[row][col] = new Doodlebug(row, col);
        }
    }

    public void printBoard() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (board[i][j] == null)
                    System.out.print("- ");
                if (board[i][j] instanceof Ant)
                    System.out.print("O ");
                if (board[i][j] instanceof Doodlebug)
                    System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println("************************************************");


    }

}
