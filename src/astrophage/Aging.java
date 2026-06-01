package astrophage;

public class Aging {
    public static void aging(Astrophage astro) {
        int age = astro.getAge();
        int ageMax = astro.getAgeMax();

        if(age++ == ageMax) {
            astro.setIsAlive(false);
        }
        else age++;
    }
}
