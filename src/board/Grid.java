package board;
import cell.Cell;
import simulation.RandomVariables;

public class Grid {
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