package simulation;

public class AstrophageRandom {

    public static int placeRandom(){
        /*tak mi wpadło do głowy: powinnyśmy chyba zmienić tą funkcję tak,
        żeby losowała miejsca istniejąca na mapie (np jeśli ktoś zrobi mapę 10/10,
        to może zostać wylosowane 30, co będzie poza)
        (nie zmieniam tego, bo nie chcę wam mieszać w funkcjach)*/
        return Randomizer.random(0,49);
    }

    public static float energyRandom(){
        return (float)Randomizer.random(0,19);
    }

    public static float energyMaxRandom(int min){
        return (float)Randomizer.random(min + 1, 19);
    }

    public static int ageMaxRandom(){
        return Randomizer.random(2, 10);
    }

    public static int reproductionLvlRandom(){
        return Randomizer.random(0, 10);
    }
}
