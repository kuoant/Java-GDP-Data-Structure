public class AliveBoundaryRules extends Rules {

    public boolean isAlive(Field field, int row, int col) {

        if (row >= field.getHeight() || row < 0) {
            return true; 
        } else if (col >= field.getWidth() || col < 0) {
            return true;
        } else {
            return field.isAlive(row, col);
        }



    }
}
