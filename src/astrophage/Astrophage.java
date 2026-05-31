package astrophage;

import simulation.AstrophageRandom;

public class Astrophage {
    private int id;
    private int x, y;
    private float energy, energyMax;
    private int age, ageMax;
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

    public int getX(){
        return this.x;
    }  
    
    public int getY(){
        return this.y;
    }  

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
