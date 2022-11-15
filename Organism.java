package Bil211;
public class Organism {
   private boolean moved = false;
    private int breed;
    private int moveCount;
    private char symbol;
    private int rowPosition;
    private int colPosition;

    public Organism() {
        this.setRowPosition(-1);
        this.setColPosition(-1);
        this.moveCount = 0;
        this.symbol = '-';
    }

    public Organism(int row, int col) {
        this.setRowPosition(row);
        this.setColPosition(col);
        this.moveCount = 0;
        this.symbol = '-';
    }
    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }
    public void die() {
        Board.board[getRowPosition()][getColPosition()] = null;
    }

    public void breed() {// create a new baby bug
       Board.board[getRowPosition()][getColPosition()] = new Organism();
    }

    public void move() {
        Board.board[rowPosition][colPosition] = null;
    }

    public int getRowPosition() {
        return this.rowPosition;
    }

    public int getColPosition() {
        return this.colPosition;
    }

    public void setRowPosition(int row) {
        this.rowPosition = row;
    }

    public void setColPosition(int col) {
        this.colPosition = col;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public int getBreed() {
        return breed;
    }

    public void setBreed(int breed) {
        this.breed = breed;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

