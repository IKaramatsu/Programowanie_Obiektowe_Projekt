package simulation;

import simulation.Simulation;

public class SimOutput {
    private static int allAstro = 0;

    public int getAllAstrophageAmount(Simulation sim) {
        allAstro = allAstro + sim.getAstrophageAmount();
        return allAstro;
    }

    public float getAverageEnergy(Simulation sim) {

        if (sim.getAstrophage().isEmpty()) {
            return 0;
        }

        float totalEnergy = 0;

        for (int i = 0; i < sim.getAstrophage().size(); i++) {
            totalEnergy += sim.getAstrophage().get(i).getEnergy();
        }

        return totalEnergy / sim.getAstrophage().size();
    }
}
