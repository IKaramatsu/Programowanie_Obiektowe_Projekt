package cell;

import simulation.RandomVariables;

public class Core {
    public boolean death(Cell cell){
        if (cell.getCore() && cell.getBrightness() == 0){
            cell.setCore(false);
            return true;
        }
        return false;
    }

    public void create(Cell[][] grid, int size){
        int x = RandomVariables.placeRandom(size);
        int y = RandomVariables.placeRandom(size);
        
        grid[y][x].setCore(true);
        grid[y][x].setBrightness(RandomVariables.brightnessRandom());
    }
}
