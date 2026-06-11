package cell;

import simulation.RandomVariables;

public class Core {
    private static int coreCount = 0;
    public static int AllCoreAmount;

    /**
     * Tells if a given cell is a core that died (brightness = 0).
     * if it is, makes the cell not a core anymore
     * @param cell the checked/updated cell
     * @return true if the cell was a dead core and was updated, false if it wasn't
     */
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
        AllCoreAmount++;

        
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
