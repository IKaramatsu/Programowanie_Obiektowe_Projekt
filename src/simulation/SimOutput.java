package simulation;


public class SimOutput {
    /**
     * Calculates the average energy of all astrophages currently on the board.
     * @param sim the running simulation
     * @return the average energy of all astrophages currently on the board
     */
    public  static float getAverageEnergy(Simulation sim) {

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
