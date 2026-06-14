package astrophage;

import java.util.List;

import simulation.RandomVariables;
import simulation.Randomizer;

public class Reproduction {
    /**
     * Creares a new astrophage based on a given one.
     * If the reproduction makes the astrophage's energy lesser or equal to 0, makes it not alive.
     * @param astro the astrophage the new one is based on
     * @param astrophages a list of astrophages the new one is added to
     * @param newId the id of the new astrophage
     * @param boardSize the size of the board the astrophages are on
     */
    public static void reproduction(Astrophage astro, List<Astrophage> astrophages, int newId, int boardSize) {
        float energy = astro.getEnergy();
        int repLvl = astro.getReproductionLvl();
    
    
        int chance = Randomizer.random(1, 20);
    
        if(energy >= astro.getEnergyMax() * 0.35f && chance <= repLvl) {
            Astrophage child = new Astrophage(newId, boardSize);
            astrophages.add(child);
            Inheritance.inheritance(child, astro);
            astro.setEnergy(RandomVariables.inheritanceEnergyRandom(astro));
            Exhaustion.exhaustion(astro);
        }
    }
}
