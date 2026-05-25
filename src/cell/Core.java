package cell;

public class Core {
    public boolean death(Cell cell){
        if (cell.getCore() && cell.getShadow()){
            cell.setCore(false);
            return true;
        }
        return false;
    }
}
