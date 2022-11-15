package Bil211;
import java.util.Scanner;

public class PredatorSim {
    public static void enterToContinue() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Press enter to continue: ");
        keyboard.nextLine();
    }

    public static void main(String[] args) {
        Board testBoard = new Board();

        testBoard.printBoard();

        while (true) {

            
            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 20; j++)
                    if (testBoard.getBoard()[i][j] instanceof Doodlebug && !((Doodlebug) testBoard.getBoard()[i][j]).isMoved())
                        testBoard.getBoard()[i][j].move();

            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 20; j++)
                    if (testBoard.getBoard()[i][j] instanceof Doodlebug && ((Doodlebug) testBoard.getBoard()[i][j]).isMoved())
                        ((Doodlebug) testBoard.getBoard()[i][j]).setMoved(false);

            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 20; j++)
                    if (testBoard.getBoard()[i][j] instanceof Ant && !((Ant) testBoard.getBoard()[i][j]).isMoved())
                        testBoard.getBoard()[i][j].move();
            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 20; j++)
                    if (testBoard.getBoard()[i][j] instanceof Ant && ((Ant) testBoard.getBoard()[i][j]).isMoved())
                        ((Ant) testBoard.getBoard()[i][j]).setMoved(false);
            testBoard.bugsCount();

            testBoard.printBoard();
            if (Board.numOfDoodlebugs == 0 || Board.numOfAnts == 400)
                break;
        }

    }

}

