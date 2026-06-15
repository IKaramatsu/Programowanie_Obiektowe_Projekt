package simulation;

//import board.Board;
import board.Grid;
import astrophage.Astrophage;
import astrophage.Moving;
import astrophage.Aging;
import astrophage.Reproduction;
import cell.Cell;
import cell.Core;
import cell.Diffusion;
import cell.Light;
import java.util.List;
import java.util.ArrayList;

public class Simulation {
    //private Board board;
    private Cell[][] grid;
    private List<Astrophage> astrophage;
    private int stepCount;
    private boolean isRunning;
    private int size;
    private Core core;
    private Light light;
    private float movementCost;
    private int lifeLength;
    private int simulationSpan;
    private int coreAmount;
    private int coreCounter;
    private int allAstroAmount;

    /**
     * The simulation of the whole model.
     * @param input the values inputted by the user
     */
    public Simulation(UserInput input) {
        this.size = input.boardSize;
        this.movementCost = input.movementCost;
        this.lifeLength = input.lifeLength;
        this.simulationSpan = input.simulationSpan;
        this.coreAmount = input.coreAmount;
        //this.board = new Board(input.boardSize);
        Grid g = new Grid();
        this.grid = g.create(input.boardSize);
        this.astrophage = new ArrayList<>();
        this.stepCount = 0;
        this.isRunning = true;
        this.core = new Core();
        this.light = new Light();
        this.allAstroAmount = input.agentAmount;

        for (int i = 1; i <= input.agentAmount; i++) {
            Astrophage a = new Astrophage(i, input.boardSize);
            this.astrophage.add(a);
        }

        for (int i = 0; i < input.coreAmount; i++) {
            core.create(grid, input.boardSize);
        }
    }

    /**
     * Performes all the actions the simulation does in one tick.
     */
    public void update() {
        coreCounter = 0;
        if (stepCount >= simulationSpan) {
            isRunning = false;
            return;
        }

        if (astrophage.isEmpty()) {
            isRunning = false;
            return;
        }

        stepCount++;

        for (Astrophage a : astrophage) {
            Moving.move(a, grid, movementCost);
            Aging.aging(a, lifeLength);
        }

        List<Astrophage> newborns = new ArrayList<>();
        int newId = astrophage.size() + 1;
        for (Astrophage a : astrophage) {
            Reproduction.reproduction(a, newborns, newId++, size);
        }
        astrophage.addAll(newborns);
        allAstroAmount += newborns.size();

        removeDeadAstrophages();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Cell cell = grid[y][x];
                if (cell.getCore()) {
                    core.death(cell);
                    coreCounter++;
                    

                    light.regenerate(7, grid, size, cell);
                }

            }
        }

        if (coreCounter < coreAmount && stepCount % 3 == 0) {
            core.create(grid, size);
        }
        Diffusion.diffuse(grid, size);
    }

    /**
     * Removes all the dead astrophages from the list of the astrophages currently on the board.
     */
    public void removeDeadAstrophages() {
        astrophage.removeIf(a -> !a.getIsAlive());
    }

    /**
     * Gives the list of the astrophages currently on the board.
     * @return the list of the astrophages currently on the board
     */
    public List<Astrophage> getAstrophage() { return astrophage; }
    /**
     * Gives the current board.
     * @return the current board
     */
    public Cell[][] getGrid() { return grid; }
    //public Board getBoard() { return board; }
    /**
     * Gives the current number of performed steps of the simulation.
     * @return the current number of performed steps of the simulation
     */
    public int getStepCount() { return stepCount; }
    /**
     * Gives the size of the board.
     * @return the size of the board
     */
    public int getSize() { return size; }
    /**
     * Tells if the simulation is currently running.
     * @return true if the simulation is currently running, false if not
     */
    public boolean getIsRunning() { return isRunning; }

    public double getBoardCoveragePercentage() {
        return (double) astrophage.size() / (size * size) * 100;
    }

    public double getEnvironmentEnergy() {
        double total = 0;
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                total += grid[y][x].getBrightness();
        return total;
    }
    /**
     * Gives the maxumum length of the simulation.
     * @return the maxumum length of the simulation
     */
    public int getSimulationSpan() { return simulationSpan; 
    }

    /**
     * Gives the current ammount of the astrophages on the board.
     * @return the current ammount of the astrophages on the board
     */
    public int getAstrophageAmount() {
        return astrophage == null ? 0 : astrophage.size();
    }

    /**
     * Gives the ammount of all astrophages - dead and alive.
     * @return the ammount of all astrophages - dead and alive
     */
    public int getAllAstroAmount() {
        return allAstroAmount;
    }
}