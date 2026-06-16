package cell;
import java.util.ArrayList;
import java.util.List;

import astrophage.Astrophage;

/**
     * class responsible fir creating and managing invidual cells of the board
     */
public class Cell {
    private int x, y;
    private List<Astrophage> agents;
    private float brightness;
    private boolean core;

    /**
     * A single cell that an astrophage can stay on.
     * @param x in which column the cell is
     * @param y in which row the cell is
     * @param agents list of all astrophages currently on the cell
     */
    public Cell(int x, int y, List<Astrophage> agents){
        this.x = x;
        this.y = y;
        this.agents = new ArrayList<>();
        this.brightness = 0; //brightness of the cell
        this.core = false; //is the cell a core
    }

    /**
     * Tells if a given cell has any astrophages currently on it.
     * @return true if there are no astrophages, false if there are any
     */
    public boolean isEmpty(){
        if (agents.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Sets the brightness of this cell to a given value.
     * @param brightness what value to change the brightness to
     */
    public void setBrightness(float brightness){
        this.brightness = brightness;
    }

    /**
     * Sets the core of this cell to a given value.
     * @param core what value to change core to
     */
    public void setCore(boolean core){
        this.core = core;
    }

    /**
     * Gives the column of this cell.
     * @return column of this cell
     */
    public int getX(){
        return x;
    }

    /**
     * Gives the row of this cell.
     * @return row of this cell
     */
    public int getY(){
        return y;
    }

    /**
     * Gives the list of all astrophages currently on this cell.
     * @return the list of all astrophages currently on this cell
     */
    public List<Astrophage> getAgents(){
        return agents;
    }

    /**
     * Gives the brightness value of this cell.
     * @return brightness value of this cell
     */
    public float getBrightness(){
        return brightness;
    }

    /**
     * Tells if this cell is a core.
     * @return true if this cell is a core, false if it isn't
     */
    public boolean getCore(){
        return core;
    }
}
