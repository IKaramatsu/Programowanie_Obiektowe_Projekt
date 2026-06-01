package astrophage;

public class Exhaustion {
    public static void exhaustion(Astrophage astro){
        if(astro.getEnergy() == 0) {
            astro.setIsAlive(false);
        }
    }
}
