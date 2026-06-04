package simulation;

import astrophage.Astrophage;

public class RandomVariables {

    public static int placeRandom(int size){
        return Randomizer.random(0,size-1);
    }

    public static float energyRandom(){
        return (float)Randomizer.random(0,18);
    }

    public static float energyMaxRandom(int min){
        return (float)Randomizer.random(min + 1, 19);
    }

    public static int ageMaxRandom(){
        return Randomizer.random(2, 10);
    }

    public static int reproductionLvlRandom(){
        return Randomizer.random(1, 100);
    }

    public static float inheritanceEnergyRandom(Astrophage parent){
        return Randomizer.random(1, (int) parent.getEnergy());
    }

    public static float inheritanceEnergyMaxRandom(Astrophage parent){
        return Randomizer.random((int) parent.getEnergy() + 1, (int) parent.getEnergyMax());
    }

    public static int inheritanceAgeMaxRandom(Astrophage parent){
        return Randomizer.random(2, parent.getAgeMax());
    }

    public static int inheritanceRepLvlRandom(Astrophage parent){
        return Randomizer.random(1, (int) parent.getReproductionLvl());
    }

    public static float brightnessRandom(){
        return Randomizer.random(1, 10);
    }
}
