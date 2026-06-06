import simulation.Simulation;
import simulation.UserInput;
import astrophage.Astrophage;

public class App {
    public static void main(String[] args) throws Exception {
        UserInput input = new UserInput();
        input.getInput();
        Simulation sim = new Simulation(input);
        
        System.out.println("Symulacja wystartowała!");
        System.out.println("Liczba agentów: " + sim.getAstrophage().size());
        
        for (int step = 1; step <= sim.getSimulationSpan(); step++) {
            System.out.println("--- Krok " + step + " ---");
            sim.update();
            for (Astrophage astro : sim.getAstrophage()) {
                System.out.println("Agent x=" + astro.getX() + " y=" + astro.getY());
            }
        }
        
        System.out.println("done");
    }
}