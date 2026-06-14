package astrophage;

import simulation.RandomVariables;

public class Astrophage {
    private int id;
    private int x, y;
    private float energy, energyMax;
    private int age, ageMax;
    private int reproductionLvl;
    private boolean isAlive = true;

    /**
     * A single Astrophage - the agent.
     * @param id a number identyfying the astrophage
     * @param size the size of the board thet the astrophages exist on
     */
    public Astrophage(int id, int size){
        this.id = id;
        this.x =  RandomVariables.placeRandom(size-1); //current column
        this.y =  RandomVariables.placeRandom(size-1); //current row
        this.energy =  RandomVariables.energyRandom();
        this.energyMax =  RandomVariables.energyMaxRandom((int) this.energy);
        this.age = 1;
        this.ageMax = RandomVariables.ageMaxRandom();
        this.reproductionLvl =  RandomVariables.reproductionLvlRandom(); //used in the reproduction precess
    }

    /**
     * Gives the Id of this astrophage.
     * @return Id of this astrophage
     */
    public int getId(){
        return this.id;
    }

    /**
     * Gives the column of this astrophage.
     * @return column of this astrophage
     */
    //dla Moving
    public int getX(){
        return this.x;
    }  
    
    /**
     * Gives the row of this astrophage.
     * @return row of this astrophage
     */
    public int getY(){
        return this.y;
    } 

    /**
     * Gives the current age of this astrophage.
     * @return current age of this astrophage
     */
    public int getAge(){
        return this.age;
    } 

    /**
     * Gives the maximum age of this astrophage.
     * @return maximum age of this astrophage
     */
    public int getAgeMax(){
        return this.ageMax;
    }

    /**
     * Gives the current energy of this astrophage.
     * @return current energy of this astrophage
     */
    public float getEnergy(){
        return this.energy;
    }

    /**
     * Gives the maximum energy of this astrophage.
     * @return maximum energy of this astrophage
     */
    public float getEnergyMax(){
        return this.energyMax;
    }

    /**
     * Tells if the given astrophage is alive.
     * @return true if the astrophage is alive, false if it isn't
     */
    public boolean getIsAlive(){
        return this.isAlive;
    } 

    /**
     * Gives the reproduction level of this astrophage.
     * @return reproduction level of this astrophage
     */
    public int getReproductionLvl(){
        return this.reproductionLvl;
    } 

    /**
     * Moves this astrophage to a given column.
     * @param x the given column to move the astrophage to
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * Moves this astrophage to a given row.
     * @param y the given row to move the astrophage to
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * Sets the age of this astrophage to a given value.
     * @param age what value to change the age to
     */
    public void setAge(int age){
        this.age = age;
    }

     /**
     * Sets the energy of this astrophage to a given value.
     * @param energy what value to change the energy to
     */
    public void setEnergy(float energy){
        this.energy = energy;
    } 
    
    /**
     * Sets the maximum energy of this astrophage to a given value.
     * @param energyMax what value to change the maximum energy to
     */
    public void setEnergyMax(float energyMax){
        this.energyMax = energyMax;
    }
    
    /**
     * Sets the maximum age of this astrophage to a given value.
     * @param ageMax what value to change the maximum age to
     */
    public void setAgeMax(int ageMax){
        this.ageMax = ageMax;
    }  
    
    /**
     * Sets the reproduction level of this astrophage to a given value.
     * @param repLvl what value to change the reproduction level to
     */
    public void setRepLvl(int repLvl){
        this.reproductionLvl = repLvl;
    } 

    /**
     * Sets the alive status of this astrophage to a given value.
     * @param isAlive what value to change the alive status to
     */
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }  
}
