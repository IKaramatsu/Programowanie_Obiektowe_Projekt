package astrophage;

import simulation.RandomVariables;

public class Astrophage {
    private int id;
    private int x, y;
    private float energy, energyMax;
    private int age, ageMax;
    private int reproductionLvl;

    public Astrophage(int id, int size){
        this.id = id;
        this.x = RandomVariables.placeRandom(size);
        this.y = RandomVariables.placeRandom(size);
        this.energy = RandomVariables.energyRandom();
        this.energyMax = RandomVariables.energyMaxRandom((int) this.energy);
        this.age = 1;
        this.ageMax = RandomVariables.ageMaxRandom();
        this.reproductionLvl = RandomVariables.reproductionLvlRandom();
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
