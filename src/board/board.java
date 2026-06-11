package board;

//import cell.Cell;
//import board.Grid;

public class Board {
    private int size;
    //private Cell[][] grid;

    public Board(int size) {
        this.size = size;
        //Grid g = new Grid();
        //this.grid = g.create(size);
    }

    public int getSize() {
        return this.size;
    }
}
