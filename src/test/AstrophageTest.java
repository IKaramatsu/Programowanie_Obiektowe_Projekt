package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import astrophage.Astrophage;

import astrophage.Aging;
import astrophage.Absorption;
import astrophage.Exhaustion;
import cell.Cell;
import cell.Core;
import simulation.UserInput;
import simulation.Simulation;

public class AstrophageTest {

    // 1. Absorption czy jasnosc pola maleje po absorpcji
    @Test
    void testAbsorptionDecreasesBrightness() {
        Astrophage a = new Astrophage(1, 20);
        Cell[][] grid = new Cell[20][20];
        for (int x = 0; x < 20; x++)
            for (int y = 0; y < 20; y++)
                grid[y][x] = new Cell(x, y, null);

        grid[a.getY()][a.getX()].setBrightness(5);
        float brightnessBefore = grid[a.getY()][a.getX()].getBrightness();
        a.setEnergy(0); // czy moze absorbowac

        Absorption.absorption(a, grid);

        assertTrue(grid[a.getY()][a.getX()].getBrightness() < brightnessBefore);
    }

    // 2. Exhaustion czy astrophage umiera gdy energy <= 0
    @Test
    void testExhaustionKillsAstrophage() {
        Astrophage a = new Astrophage(1, 20);
        a.setEnergy(0);
        Exhaustion.exhaustion(a);
        assertFalse(a.getIsAlive());
    }

    // 3. Aging czy wiek rosnie o 1 po kroku
    @Test
    void testAgingIncrementsAge() {
        Astrophage a = new Astrophage(1, 20);
        int ageBefore = a.getAge();
        Aging.aging(a, 100);
        assertEquals(ageBefore + 1, a.getAge());
    }

    // 4. Core czy rdzeń umiera gdy brightness == 0
    @Test
    void testCoreDeathWhenNoBrightness() {
        Cell[][] grid = new Cell[20][20];
        for (int x = 0; x < 20; x++)
            for (int y = 0; y < 20; y++)
                grid[y][x] = new Cell(x, y, null);

        grid[5][5].setCore(true);
        grid[5][5].setBrightness(0);

        Core core = new Core();
        boolean died = core.death(grid[5][5]);

        assertTrue(died);
        assertFalse(grid[5][5].getCore());
    }

    // 5. Simulation czy stepCount rosnie po update
    @Test
    void testSimulationStepCountIncrements() {
        UserInput input = new UserInput();
        input.agentAmount = 5;
        input.boardSize = 20;
        input.movementCost = 0.5f;
        input.simulationSpan = 100;
        input.lifeLength = 20;
        input.coreAmount = 3;

        Simulation sim = new Simulation(input);
        int stepsBefore = sim.getStepCount();
        sim.update();
        assertEquals(stepsBefore + 1, sim.getStepCount());
    }
}