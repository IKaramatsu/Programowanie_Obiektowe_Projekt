package astrophage;

public class Aging {
    public static void aging(Astrophage astro, int lifeLenght) {
        int age = astro.getAge() + 1;
        astro.setAge(age);

        if (age >= lifeLenght) {
            astro.setIsAlive(false);
        }
    }
}
