package board;
import cell.Cell;

public class Grid {
    public Cell[][] create(int width, int height, float brightness, int regeneration){
        Cell[][] grid = new Cell[width][height];

        for(int i = 0; i<height;i++){
            for(int j=0; j<width;j++){
                grid[j][i] = new Cell(j, i, null, brightness, regeneration);
            }
        }

        return grid;
    }
}
