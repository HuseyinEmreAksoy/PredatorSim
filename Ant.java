package Bil211;
public class Ant extends Organism {
    private boolean moved = false;
    private int breed;
    private int moveCount;
    private char symbol;

    public Ant() {
        super();
        this.symbol = 'O';
        this.breed = 3;
    }

    public Ant(int row, int col) {
        super(row, col);
        this.symbol = 'O';
        this.breed = 3;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public void move() {
        moved = true;
        moveCount++;
        int x = getRowPosition();
        int y = getColPosition();

        int direction = (int) (Math.random() * 3 + 1);

        if (direction == 1 && y > -1 && x - 1 > -1 && x - 1 < 20 && y < 20 && Board.board[x - 1][y] == null) {
            Board.board[x - 1][y] = this; //Copy Ant
            Board.board[x][y] = null; //Remove old Ant
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

        if (moveCount == breed) {
            breed();
            moveCount = 0;
        }
    }

    public void breed() {// create a new baby bug
        int x = getRowPosition();
        int y = getColPosition();

        if (y > -1 && x - 1 > -1 && x - 1 < 20 && y < 20 && Board.board[x - 1][y] == null)
            Board.board[x - 1][y] = new Ant(x - 1, y);
        else if (y + 1 > -1 && x > -1 && x < 20 && y + 1 < 20 && Board.board[x][y + 1] == null)
            Board.board[x][y + 1] = new Ant(x, y + 1);
        else if (y > -1 && x + 1 > -1 && x + 1 < 20 && y < 20 && Board.board[x + 1][y] == null)
            Board.board[x + 1][y] = new Ant(x + 1, y);
        else if (y - 1 > -1 && x > -1 && x < 20 && y - 1 < 20 && Board.board[x][y - 1] == null)
            Board.board[x][y - 1] = new Ant(x, y - 1);
    }

}

