package cell;

import simulation.RandomVariables;
/**
     * All the methods related to managinc cores
     */

public class Core {
    private static int coreCount = 0;
    public static int AllCoreAmount;

    /**
     * Tells if a given cell is a core that died (brightness = 0).
     * If it is, makes the cell not a core anymore.
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

    /**
     * Generates a new core cell and increases the ammount of all and current cores on the board.
     * @param grid the board the cells are on
     * @param size the size of the board
     */
    public void create(Cell[][] grid, int size){
        int x = RandomVariables.placeRandom(size);
        int y = RandomVariables.placeRandom(size);

        coreCount();
        AllCoreAmount++;

        
        grid[y][x].setCore(true);
        grid[y][x].setBrightness(RandomVariables.brightnessRandom());
    }

    /**
     * Increases the ammount of cores currently on the board by 1.
     */
    public void coreCount() {
        coreCount++;
    }

    /**
     * Gives the ammount of cores currently on the board.
     * @return the ammount of cores currently on the board
     */
    public int getCoreCount() {
        return coreCount;
    }
}
