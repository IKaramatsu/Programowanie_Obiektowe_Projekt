package cell;

/**
     * diffuses light from the gradient accross the board
     */
public class Diffusion {
    /**
     * Spreads the light between neighbouring cells more equally.
     * @param grid the board the cells are on
     * @param size the size of the board
     */
    public static void diffuse(Cell[][] grid, int size) {
        float[][] newBrightness = new float[size][size];

        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                newBrightness[y][x] = grid[y][x].getBrightness();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (grid[y][x].getCore()) continue;

                float sum = 0;
                int count = 0;

                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx == 0 && dy == 0) continue;
                        int nx = x + dx;
                        int ny = y + dy;
                        if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                        sum += newBrightness[ny][nx];
                        count++;
                    }
                }

                float avg = sum / count;
                grid[y][x].setBrightness(grid[y][x].getBrightness() * 0.85f + avg * 0.15f);
            }
        }
    }
}