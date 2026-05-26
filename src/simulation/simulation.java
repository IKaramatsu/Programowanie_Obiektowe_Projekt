package simulation;

import board.Board;
import astrophage.Astrophage;
import java.util.List;
import java.util.ArrayList;
import simulation.Randomizer;

public class Simulation {
    private Board board;
    private List<Astrophage> astrophage;
    private int stepCount;
    private boolean isRunning;
    private int regenerationCost;
    private int astrophageAmount;

    private Simulation(int width, int height, int numAgents) {
        this.board = new Board(width, height);
        this.astrophage = new ArrayList<>();
        this.stepCount = 0;
        this.isRunning = true;
        this.regenerationCost = Randomizer.random(0, 10);
        this.astrophageAmount = numAgents;
    }

    private void initialize() {
    }

    private void step() {
    }

    private void end(int steps) {
    }
}
