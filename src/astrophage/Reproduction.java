package astrophage;

import java.util.List;

import simulation.RandomVariables;
import simulation.Randomizer;

public class Reproduction {
    public static void reproduction(Astrophage astro, List<Astrophage> astrophages, int newId, int boardSize) {
        float energy = astro.getEnergy();
        float random = Randomizer.random(1, 10);

        if(energy >= 10) {
            if(energy + random >= 15) {
                Astrophage child = new Astrophage(newId, boardSize);
                astrophages.add(child);
                Inheritance.inheritance(child, astro);

                astro.setEnergy(energy - 1);
                Exhaustion.exhaustion(astro);
            }
        }
    }
}
