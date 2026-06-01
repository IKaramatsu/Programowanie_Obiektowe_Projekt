package astrophage;

import simulation.RandomVariables;
import board.Board;

public class Astrophage {
    private int id;
    private int x, y;
    private float energy, energyMax;
    private int age, ageMax;
    private int reproductionLvl;
    private boolean isAlive = true;
    private int boardSize;

    public Astrophage(int id, int size){
        this.id = id;
        this.boardSize = size;
        this.x =  RandomVariables.placeRandom(size-1);
        this.y =  RandomVariables.placeRandom(size-1);
        this.energy =  RandomVariables.energyRandom();
        this.energyMax =  RandomVariables.energyMaxRandom((int) this.energy);
        this.age = 1;
        this.ageMax = RandomVariables.ageMaxRandom();
        this.reproductionLvl =  RandomVariables.reproductionLvlRandom();
    }

    //dla Moving
    public int getX(){
        return this.x;
    }  
    
    public int getY(){
        return this.y;
    } 

    public int getAge(){
        return this.age;
    } 

    public int getAgeMax(){
        return this.ageMax;
    }
    public float getEnergy(){
        return this.energy;
    }

    public float getEnergyMax(){
        return this.energyMax;
    }

    public boolean getIsAlive(){
        return this.isAlive;
    } 

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setEnergy(float energy){
        this.energy = energy;
    }  

    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }  
}
