package board;

import cell.Cell;

public class Board {
    private int width;
    private int height;
    private Cell[][] grid;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Cell[width][height];
    }

    public boolean inBounds(int x, int y) {
        return false;
    }

    public void placeAgents(int x, int y) {
    }

    public void moveAgents(int newX, int newY) {
    }

    public void removeAgents() {
    }

    public int getCellmates(int x, int y) {
        return 0;
    }

    public void diffusion(int x1, int y1, int x2, int y2, float brightness1, float brightness2) {
    }

    public void brightnessSpread(int x1, int y1, int x2, int y2, float brightness1, float brightness2) {
    }

    public void newCore(int coreDis) {
    }
}
