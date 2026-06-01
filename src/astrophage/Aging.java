package astrophage;

public class Aging {
    public static void aging(Astrophage astro) {
        int age = astro.getAge() + 1;
        astro.setAge(age);

        if (age >= astro.getAgeMax()) {
            astro.setIsAlive(false);
        }
    }
}
