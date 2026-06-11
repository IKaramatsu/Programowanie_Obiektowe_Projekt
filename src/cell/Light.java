package cell;

public class Light {

    public void regenerate(float lightGiven, Cell[][] grid, int size, Cell core){
        int coreX = core.getX();
        int coreY = core.getY();

        float[][] oldBrightness = new float[size][size];
        for(int x = 0; x < size; x++)
            for(int y = 0; y < size; y++)
                oldBrightness[y][x] = grid[y][x].getBrightness();

        // rdzeń zawsze ma pełne światło
        grid[coreY][coreX].setBrightness(lightGiven);

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                if(grid[y][x].getCore()) continue;

                float bestNeighbour = 0;
                for(int dx = -1; dx <= 1; dx++){
                    for(int dy = -1; dy <= 1; dy++){
                        if(dx == 0 && dy == 0) continue;
                        int nx = x + dx;
                        int ny = y + dy;
                        if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                        if(oldBrightness[ny][nx] > bestNeighbour)
                            bestNeighbour = oldBrightness[ny][nx];
                    }
                }

                float newLight = bestNeighbour - 1;
                if(newLight > grid[y][x].getBrightness()){
                    illuminate(newLight, grid[y][x]);
                }
            }
        }
    }

    /**
     * Sets the light of a given cell to a given value and ensures that the brightness remains between 0 and 10.
     * @param lightGiven the value of brightness to be given to the cell
     * @param cell the cell the light is given to
     */
    private void illuminate(float lightGiven, Cell cell){
        cell.setBrightness(lightGiven);
        if(cell.getBrightness() > 10) cell.setBrightness(10);
        if(cell.getBrightness() < 0) cell.setBrightness(0);
    }
}