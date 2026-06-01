package cell;

public class Light {

    public void regenerate(float lightGiven, Cell[][] grid, int size, Cell core){
        int coreX = core.getX();
        int coreY = core.getY();
        for(int i = coreY-1; i <= coreY + 1; i++){
            for(int j = coreX-1; j <= coreX + 1; j++){
                if(grid[j][i].getCore()){
                    iluminate(lightGiven, grid[j][i]);
                }
                else{
                    if (i >= 0 && i < size && j >= 0 && j < size) {
                        iluminate(lightGiven-1, grid[j][i]);
                    }
                }
            }
        }
    }

    private void iluminate(float lightGiven, Cell cell){
        cell.setBrightness(lightGiven);
        if (cell.getBrightness() > 10) {
            cell.setBrightness(10);
        }
    }
}