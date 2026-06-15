package board;
import cell.Cell;

public class Grid {
    /**
     * Creates an empty square grid of cells of a given size for the astrophages to move on.
     * @param size number of cells per edge of the board
     * @return an empty grid
     */
    public Cell[][] create(int size){
        Cell[][] grid = new Cell[size][size];

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                grid[y][x] = new Cell(x, y, null);
            }
        }
        return grid;
    }
}