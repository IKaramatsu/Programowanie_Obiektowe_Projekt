package astrophage;

import astrophage.AstrophageRandom;

public class Astrophage {
    private int id;
    private int x;
    private int y;
    private float energy;
    private float energyMax;
    private int age;
    private int ageMax;
    private int reproductionLvl;

    public Astrophage(int id){
        this.id = id;
        this.x = AstrophageRandom.placeRandom();
        this.y = AstrophageRandom.placeRandom();
        this.energy = AstrophageRandom.energyRandom();
        this.energyMax = AstrophageRandom.energyMaxRandom((int) this.energy);
        this.age = 1;
        this.ageMax = AstrophageRandom.ageMaxRandom();
        this.reproductionLvl = AstrophageRandom.reproductionLvlRandom();
    }
}
