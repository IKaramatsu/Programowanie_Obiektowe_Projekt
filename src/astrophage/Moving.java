package astrophage;

import simulation.Randomizer;
import cell.Cell;

public class Moving {
    // coordinates of specyfic directions
    private static int[][] directions = {
        {1, 0}, // up
        {1, 1}, // right-up
        {0, 1}, // right
        {-1, 1}, //right-down
        {-1, 0}, //down
        {-1, -1}, //left-down
        {0, -1}, //left
        {1, -1} //left-up
    };

    /**
     * Analizes the neighbouring cells of a given astrophage (including the one it's on) and returns the brightest one. 
     * @param astro the given astrophage
     * @param grid the board the astrophage is on
     * @return the coordinates of the brightest neighbouring cell
     */
    public static int[] analyze(Astrophage astro, Cell[][] grid){
        int astroX = astro.getX();
        int astroY = astro.getY();
        Cell currentCell = grid[astroY][astroX];

        int bestPlaceX = astroX;
        int bestPlaceY = astroY;
        float bestBright = currentCell.getBrightness();

        for(int i=0; i<8; i++){

            int newX = astroX + directions[i][1];
            int newY = astroY + directions[i][0];

            //is it outside board
            if (newX<0 || newX>=grid[0].length || newY<0 || newY>=grid.length) {
                continue;
            }

            Cell neighbourCell = grid[newY][newX];

            //looking for best place
            if(neighbourCell.getBrightness() > bestBright){
                bestBright = neighbourCell.getBrightness();
                bestPlaceX = newX;
                bestPlaceY = newY;
            }
        }

        return new int[]{bestPlaceX, bestPlaceY};
    }

    /**
     * Moves the given astrophage to the brightest neighbouring place on the board.
     * If the astrophage is already on the brightest place, moves it to a random neighbouring place instead.
     * @param astro the moved astrophage
     * @param grid the board the astrophage is on
     * @param bestPlace the coordinates of the brightest neighbouring cell
     */
    public static void deciding(Astrophage astro, Cell[][] grid, int[] bestPlace){
        int astroX = astro.getX();
        int astroY = astro.getY();

        int bestPlaceX = bestPlace[0];
        int bestPlaceY = bestPlace[1];

        //place with light
        if (bestPlaceX != astroX || bestPlaceY != astroY){
            astro.setX(bestPlaceX);
            astro.setY(bestPlaceY);
        }
        //random place
        else{
            while(true){
                //looking for new place
                int randomPlace = Randomizer.random(0,7);
                int astroNewX = astroX + directions[randomPlace][1];
                int astroNewY = astroY + directions[randomPlace][0];

                //is it outside board
                if (astroNewX<0 || astroNewX>=grid[0].length || astroNewY<0 || astroNewY>=grid.length) {
                    continue;
                }
            
                astro.setX(astroNewX);
                astro.setY(astroNewY);
                break;
            }
        }
    }

    /**
     * Moves the given astrophage, decreases it's energy and absorbs the light from the cell it moved to.
     * If the move makes the astrophage's energy lesser or equal to 0, makes it not alive and it does not absorb the light.
     * @param astro the given astrophage
     * @param grid the board the astrophage is on
     * @param movementCost the energy cont of the astrophage's movement
     */
    public static void move(Astrophage astro, Cell[][] grid, float movementCost){
        int[] bestPlace = analyze(astro, grid);
        deciding(astro, grid, bestPlace);
        astro.setEnergy(astro.getEnergy() - movementCost);
        Exhaustion.exhaustion(astro);
        
        Absorption.absorption(astro, grid);
    }
}
