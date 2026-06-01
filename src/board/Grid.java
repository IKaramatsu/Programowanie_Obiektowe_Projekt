package board;
import cell.Cell;

public class Grid {
    public Cell[][] create(int size){
        Cell[][] grid = new Cell[size][size];

        for(int i = 0; i<size;i++){
            for(int j=0; j<size;j++){
                grid[j][i] = new Cell(j, i, null);
            }
        }

        return grid;
    }
}
