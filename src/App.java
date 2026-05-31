import astrophage.Astrophage;
import astrophage.Moving;
import simulation.Simulation;

public class App {
    public static void main(String[] args) throws Exception {
        Simulation sim = new Simulation(50, 50, 3);
        
        System.out.println("Symulacja wystartowała!");
        System.out.println("Liczba agentów: " + sim.getAstrophage().size());
        
        // 10 kroków symulacji
        for (int step = 1; step <= 10; step++) {
            System.out.println("--- Krok " + step + " ---");
            
            for (Astrophage astro : sim.getAstrophage()) {
                Moving.move(astro, sim.getGrid());
                System.out.println("Agent x" + astro.getX() + " y=" + astro.getY());
            }
        }
        
        System.out.println("done");
    }
}

 //ten kod powyzej przeniesc i dostosowac do simulation, 
        // a tu zostawić poniższy kod i go odkomentować
        /*
        Simulation simulation = new Simulation();
        simulation.start();
        */