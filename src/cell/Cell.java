package cell;
import java.util.ArrayList;
import java.util.List;

import astrophage.Astrophage;
import simulation.Simulation;

public class Cell {
    private int x, y;
    private List<Astrophage> agents;
    private float brightness;
    private boolean core;

    public Cell(int x, int y, List<Astrophage> agents){
        this.x = x;
        this.y = y;
        this.agents = new ArrayList<>();
        this.brightness = 0;
        this.core = false;
    }

    public boolean isEmpty(){
        if (agents.isEmpty()) {
            return true;
        }
        return false;
    }

    public void setBrightness(float brightness){
        this.brightness = brightness;
    }

    public void setCore(boolean core){
        this.core = core;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public List<Astrophage> getAgents(){
        return agents;
    }

    public float getBrightness(){
        return brightness;
    }

    public boolean getCore(){
        return core;
    }
}
