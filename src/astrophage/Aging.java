package astrophage;

public class Aging {
    /**
     * Increases the given astrophage's age by 1.
     * If it makes the age greater or equal to the maximum life length of the astrophage, makes the astrophage not alive.
     * @param astro the astrophage whose age increases
     * @param lifeLength the maximum life length of the given astrophage
     */
    public static void aging(Astrophage astro, int lifeLength) {
        int age = astro.getAge() + 1;
        astro.setAge(age);

        if (age >= lifeLength) {
            astro.setIsAlive(false);
        }
    }
}
