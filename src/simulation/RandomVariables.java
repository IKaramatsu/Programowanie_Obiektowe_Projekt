package simulation;

import astrophage.Astrophage;
 /**
     * The class responsible for generating random values for the model
     */
public class RandomVariables {

    /**
     * Randomizes a row or column on the board.
     * @param size the size of the board
     * @return the generated value
     */
    public static int placeRandom(int size){
        return Randomizer.random(0,size-1);
    }

    /**
     * Radnomizes an energy value.
     * @return the generated vaule
     */
    public static float energyRandom(){
        return (float)Randomizer.random(0,18);
    }

    /**
     * Randomizes a maximum energy value.
     * @param min the minimum value of maximum energy (usually the current energy) 
     * @return the generated vaule
     */
    public static float energyMaxRandom(int min){
        return (float)Randomizer.random(min + 1, 19);
    }

    /**
     * Randomizes a maximum age value.
     * @return the generated vaule
     */
    public static int ageMaxRandom(){
        return Randomizer.random(2, 10);
    }

    /**
     * Randomizes a reproduction level value.
     * @return the generated vaule
     */
    public static int reproductionLvlRandom(){
        return Randomizer.random(1, 100);
    }

    /**
     * Radnomizes an energy value lesser or equal to a given astrophage's one.
     * @param parent the given astrophage
     * @return the generated vaule
     */
    public static float inheritanceEnergyRandom(Astrophage parent){
        return Randomizer.random(1, (int) parent.getEnergy());
    }

    /**
     * Randomizes a maximum energy value between the current and maximum energy value of a given astrophage.
     * @param parent the given astrophage
     * @return the generated vaule
     */
    public static float inheritanceEnergyMaxRandom(Astrophage parent){
        int min = (int) parent.getEnergy();
        int max = (int) parent.getEnergyMax();
        if (min >= max) return max;
        return Randomizer.random(min + 1, max);
    }

    /**
     * Radnomizes an age value lesser or equal to a given astrophage's one.
     * @param parent the given astrophage
     * @return the generated vaule
     */
    public static int inheritanceAgeMaxRandom(Astrophage parent){
        return Randomizer.random(2, parent.getAgeMax());
    }

    /**
     * Radnomizes a reproduction level value lesser or equal to a given astrophage's one.
     * @param parent the given astrophage
     * @return the generated vaule
     */
    public static int inheritanceRepLvlRandom(Astrophage parent){
        return Randomizer.random(1, (int) parent.getReproductionLvl());
    }

    /**
     * Radnomizes a brightness value between 1 and 4.
     * @return the generated value
     */
    public static float brightnessRandom(){
        return Randomizer.random(1, 4);
    }

    /**
     * Randomizes an offset value.
     * @return the generated vaule
     */
    public static int moveOffset(){
        return Randomizer.random(-4, 4);
    }
}
