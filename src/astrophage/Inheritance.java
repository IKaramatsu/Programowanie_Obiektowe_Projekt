package astrophage;

import simulation.RandomVariables;

public class Inheritance {
    /**
     * Makes one astrophage inherit some of the values of another variables.
     * The positions are ineherited directly.
     * The current and maximum energy, maximum age and reproduction level are inherited randomly, based on the parent's.
     * @param child the astrophage inheriting the values
     * @param parent the astrophage giving the values
     */
    public static void inheritance(Astrophage child, Astrophage parent) {
        child.setX(parent.getX());
        child.setY(parent.getY());
        child.setEnergy(RandomVariables.inheritanceEnergyRandom(parent));
        child.setEnergyMax(RandomVariables.inheritanceEnergyMaxRandom(parent));
        child.setAgeMax(RandomVariables.inheritanceAgeMaxRandom(parent));
        child.setRepLvl(RandomVariables.inheritanceRepLvlRandom(parent));
    }
}
