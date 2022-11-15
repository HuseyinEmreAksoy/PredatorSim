package Bil211;
public class Doodlebug extends Organism {
    private final static int MAX_STARVE_TIME = 3;
    private int starving;
    private boolean moved = false;
    private int breed;
    private int moveCount;
    private char symbol;

    public Doodlebug() {
        super();
        this.symbol = 'X';
        this.breed = 8;
        this.starving = 0;
    }

    public Doodlebug(int row, int col) {
        super(row, col);
        this.symbol = 'X';
        this.breed = 8;
        this.starving = 0;
    }


    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public void move() {
        boolean flag = true;
        starving++;
        moveCount++;
        moved = true;
        int x = getRowPosition();
        int y = getColPosition();

        if (y > -1 && x - 1 > -1 && x - 1 < 20 && y < 20 && Board.board[x - 1][y] instanceof Ant) {
            Board.board[x - 1][y] = null; // remove Ant
            Board.board[x - 1][y] = this; //Copy  Doodlebug
            Board.board[x][y] = null; //Remove old Doodlebug
            setRowPosition(x - 1);
            starving = 0;
            flag = false;
        } else if (y + 1 > -1 && x > -1 && x < 20 && y + 1 < 20 && Board.board[x][y + 1] instanceof Ant) {
            Board.board[x][y + 1] = null;
            Board.board[x][y + 1] = this;
            Board.board[x][y] = null;
            setColPosition(y + 1);
            starving = 0;
            flag = false;
        } else if (y > -1 && x + 1 > -1 && x + 1 < 20 && y < 20 && Board.board[x + 1][y] instanceof Ant) {
            Board.board[x + 1][y] = null;
            Board.board[x + 1][y] = this;
            Board.board[x][y] = null;
            setRowPosition(x + 1);
            starving = 0;
            flag = false;
        } else if (y - 1 > -1 && x > -1 && x < 20 && y - 1 < 20 && Board.board[x][y - 1] instanceof Ant) {
            Board.board[x][y - 1] = null;
            Board.board[x][y - 1] = this;
            Board.board[x][y] = null;
            setColPosition(y - 1);
            starving = 0;
            flag = false;
        }

        int direction = (int) (Math.random() * 3 + 1);

        if (flag) {
            if (direction == 1 && y > -1 && x - 1 > -1 && x - 1 < 20 && y < 20 && Board.board[x - 1][y] == null) {
                Board.board[x - 1][y] = this;
                Board.board[x][y] = null;
                setRowPosition(x - 1);
            }
            if (direction == 2 && y + 1 > -1 && x > -1 && x < 20 && y + 1 < 20 && Board.board[x][y + 1] == null) {
                Board.board[x][y + 1] = this;
                Board.board[x][y] = null;
                setColPosition(y + 1);
            }
            if (direction == 3 && y > -1 && x + 1 > -1 && x + 1 < 20 && y < 20 && Board.board[x + 1][y] == null) {
                Board.board[x + 1][y] = this;
                Board.board[x][y] = null;
                setRowPosition(x + 1);
            }
            if (direction == 4 && y - 1 > -1 && x > -1 && x < 20 && y - 1 < 20 && Board.board[x][y - 1] == null) {
                Board.board[x][y - 1] = this;
                Board.board[x][y] = null;
                setColPosition(y - 1);
            }
        }

        if (starving == MAX_STARVE_TIME)
            die();
        if (moveCount == breed) {
            breed();
            moveCount = 0;
        }
    }

    public void die() {
        Board.board[getRowPosition()][getColPosition()] = null;
    }

    public void breed() {// create a new baby bug
        int x = getRowPosition();
        int y = getColPosition();

        if (y > -1 && x - 1 > -1 && x - 1 < 20 && y < 20 && Board.board[x - 1][y] == null)
            Board.board[x - 1][y] = new Doodlebug(x - 1, y);
        else if (y + 1 > -1 && x > -1 && x < 20 && y + 1 < 20 && Board.board[x][y + 1] == null)
            Board.board[x][y + 1] = new Doodlebug(x, y + 1);
        else if (y > -1 && x + 1 > -1 && x + 1 < 20 && y < 20 && Board.board[x + 1][y] == null)
            Board.board[x + 1][y] = new Doodlebug(x + 1, y);
        else if (y - 1 > -1 && x > -1 && x < 20 && y - 1 < 20 && Board.board[x][y - 1] == null)
            Board.board[x][y - 1] = new Doodlebug(x, y - 1);
    }

}
