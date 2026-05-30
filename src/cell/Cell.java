package cell;
import java.util.ArrayList;
import java.util.List;

import astrophage.Astrophage;

public class Cell {
    private int x, y, regeneration;
    private List<Astrophage> agents;
    private float brightness;
    private boolean core, shadow;

    public Cell(int x, int y, List<Astrophage> agents, float brightness, int regeneration){
        this.x = x;
        this.y = y;
        this.agents = new ArrayList<>();
        this.brightness = brightness;
        this.core = false;
        this.shadow = false;
        this.regeneration = regeneration;
    }

    public boolean isEmpty(){
        if (agents.isEmpty()) {
            return true;
        }
        return false;
    }

    public void setCore(boolean core){
        this.core = core;
    }

    public void setShadow(boolean shadow)
    {
        this.shadow = shadow;
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

    public boolean getShadow(){
        return shadow;
    }

    public int getRegeneration(){
        return regeneration;
    }
}
