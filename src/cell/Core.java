package cell;

import astrophage.AstrophageRandom;

public class Core {
    public boolean death(Cell cell){
        if (cell.getCore() && cell.getShadow()){
            cell.setCore(false);
            return true;
        }
        return false;
    }

    public void create(Cell[][] grid){
        int x, y;
        do {
            x = AstrophageRandom.placeRandom();
            y = AstrophageRandom.placeRandom();
        } while (grid[x][y].getShadow());
        
        grid[x][y].setCore(true);
    }
}
