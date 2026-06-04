package astrophage;

import java.util.List;

import simulation.RandomVariables;

public class Reproduction {
    public static void reproduction(Astrophage astro, List<Astrophage> astrophages, int newId, int boardSize) {
        float energy = astro.getEnergy();
        
        if(energy >= astro.getEnergyMax()/2 && astro.getReproductionLvl() >= RandomVariables.reproductionLvlRandom()) {
            Astrophage child = new Astrophage(newId, boardSize);
            astrophages.add(child);
            Inheritance.inheritance(child, astro);

            astro.setEnergy(energy - 1);
            Exhaustion.exhaustion(astro);
        }
    }
}
