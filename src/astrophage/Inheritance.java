package astrophage;

import simulation.RandomVariables;

public class Inheritance {
    public static void inheritance(Astrophage child, Astrophage parent) {
        child.setX(parent.getX());
        child.setY(parent.getY());
        child.setEnergy(RandomVariables.inheritanceEnergyRandom(parent));
        child.setEnergyMax(RandomVariables.inheritanceEnergyMaxRandom(parent));
        child.setAgeMax(RandomVariables.inheritanceAgeMaxRandom(parent));
        child.setRepLvl(RandomVariables.inheritanceRepLvlRandom(parent));
    }
}
