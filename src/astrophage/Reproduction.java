package astrophage;

import java.util.List;

import simulation.RandomVariables;
import simulation.Randomizer;

public class Reproduction {
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
