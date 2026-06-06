package simulation;
import java.util.Scanner;

public class UserInput {
    public int agentAmount;
    public int boardSize;
    public float movementCost;
    public int simulationSpan;
    public int lifeLength;
    public int coreAmount;

    public void getInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the starting amount of astrophage:");
        agentAmount = myObj.nextInt();
        System.out.println("Enter the size of the board:");
        boardSize = myObj.nextInt();
        System.out.println("Enter the energy cost of each movement:");
        movementCost = myObj.nextFloat();
        System.out.println("Enter the length of the simulation:");
        simulationSpan = myObj.nextInt();
        System.out.println("Enter the lifespan of each astrophage:");
        lifeLength = myObj.nextInt();
        System.out.println("Enter the core amount:");
        coreAmount = myObj.nextInt();
        myObj.close();
    }
}