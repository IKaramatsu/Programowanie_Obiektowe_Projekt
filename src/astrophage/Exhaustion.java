package astrophage;

public class Exhaustion {
    /**
     * If a given's astrophage energy is lesser or equal to 0, makes the astrophage not alive.
     * @param astro the checked astrophage
     */
    public static void exhaustion(Astrophage astro){
        if(astro.getEnergy() <= 0) {
            astro.setIsAlive(false);
        }
    }
}
