package cell;

import simulation.RandomVariables;

public class Core {
    private static int coreCount = 0;

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

        coreCount();
        
        grid[y][x].setCore(true);
        grid[y][x].setBrightness(RandomVariables.brightnessRandom());
    }

    public void coreCount() {
        coreCount++;
    }

    public int getCoreCount() {
        return coreCount;
    }
}
