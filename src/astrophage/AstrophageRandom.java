package astrophage;

import simulation.Randomizer;

public class AstrophageRandom {

    public static int placeRandom(){
        return Randomizer.random(0,50);
    }

    public static float energyRandom(){
        return (float)Randomizer.random(0,20);
    }

    public static float energyMaxRandom(int min){
        return (float)Randomizer.random(min + 1, 20);
    }

    public static int ageMaxRandom(){
        return Randomizer.random(2, 10);
    }

    public static int reproductionLvlRandom(){
        return Randomizer.random(0, 10);
    }
}
