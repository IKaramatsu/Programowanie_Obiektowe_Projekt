package astrophage;

import cell.Cell;

public class Absorption {
    /**
     * A given astrophage absorbs some of the light from a given cell (if there is any) and turns in into energy.
     * @param astro the astrophage absorbing the light from the cell
     * @param grid the cell the light is absorbed from
     */
    public static void absorption(Astrophage astro, Cell[][] grid) {
        int x = astro.getX();
        int y = astro.getY();
        Cell cell = grid[y][x];

        if(cell.getBrightness() != 0 && astro.getEnergy() < astro.getEnergyMax()){
            cell.setBrightness(cell.getBrightness() - 1);
            astro.setEnergy(astro.getEnergy() + 1);
        }
    }
}
