package astrophage;

import cell.Cell;

public class Absorption {
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
