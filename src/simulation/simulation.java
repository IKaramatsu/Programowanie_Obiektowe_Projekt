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
    private int astrophageAmount;

    public Simulation(int size, int numAgents) {
        this.board = new Board(size);
        Grid g = new Grid();
        this.grid = g.create(size);
        this.astrophage = new ArrayList<>();
        this.stepCount = 0;
        this.isRunning = true;
        this.astrophageAmount = numAgents;

        for (int i = 1; i <= numAgents; i++) {
            Astrophage a = new Astrophage(i, size);
            this.astrophage.add(a);
        }
    }

    public void removeDeadAstrophages() {
        astrophage.removeIf(a -> !a.getIsAlive());
    }

    public List<Astrophage> getAstrophage() {
        return astrophage;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public Board getBoard() {
        return board;
    }
}