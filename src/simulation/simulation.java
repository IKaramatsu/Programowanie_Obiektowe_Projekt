package simulation;

import board.Board;
import board.Grid;
import astrophage.Astrophage;
import cell.Cell;
import java.util.List;
import java.util.ArrayList;

public class Simulation {
    private Board board;
    private Cell[][] grid;
    private List<Astrophage> astrophage;
    private int stepCount;
    private boolean isRunning;
    private int regenerationCost;
    private int astrophageAmount;

    public Simulation(int width, int height, int numAgents) {
        this.board = new Board(width, height);
        this.regenerationCost = 2;
        Grid g = new Grid();
        this.grid = g.create(width, height, 5.0f, regenerationCost);
        this.astrophage = new ArrayList<>();
        this.stepCount = 0;
        this.isRunning = true;
        this.astrophageAmount = numAgents;

        for (int i = 1; i <= numAgents; i++) {
            Astrophage a = new Astrophage(i);
            this.astrophage.add(a);
        }
    }

    public List<Astrophage> getAstrophage() {
        return astrophage;
    }

    public Cell[][] getGrid() {
        return grid;
    }
}