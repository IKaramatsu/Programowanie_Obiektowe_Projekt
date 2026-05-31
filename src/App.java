import java.util.ArrayList;
import java.util.List;

import astrophage.Astrophage;
import astrophage.Moving;
import cell.Cell;
import simulation.Simulation;

public class App {
    public static void main(String[] args) throws Exception {
        List<Astrophage> population = new ArrayList<>();
        Cell[][] grid = new Cell[50][50]; //chwilowe, pozmieniać grid na board i wrzycić w board

        for (int i = 0; i < 50; i++) {
            population.add(new Astrophage(i));
        }

        for (Astrophage astro : population) {
            Moving.move(astro, grid);
        }

        //ten kod powyzej przeniesc i dostosowac do simulation, 
        // a tu zostawić poniższy kod i go odkomentować
        /*
        Simulation simulation = new Simulation();
        simulation.start();
        */
    } 

}
