package simulation;

import board.Board;
import astrophage.Astrophage;
import java.util.List;

public class Simulation {
    private Board board;
    private List<Astrophage> astrophage;
    private int stepCount;
    private boolean isRunning;
    private int regenerationCost;
    private int astrophageAmount;
}