package simulation;

import java.util.Random;
/**
     * Random variables for random variables
     */

public class Randomizer {
    private static Random random = new Random();

    /**
     * Generates a random integer value between two given values.
     * @param min the lower limit
     * @param max the higher limit
     * @return the generated value
     */
    public static int random(int min, int max){
        return random.nextInt(max - min + 1) + min;
    }
}
