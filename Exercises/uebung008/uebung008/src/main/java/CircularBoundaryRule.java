public class CircularBoundaryRule extends Rules {

    public boolean isAlive(Field field, int row, int col) {

        if (row >= field.getHeight() || row < 0) {
            row = (row + field.getHeight()) % field.getHeight(); 
        }

        if (col >= field.getWidth() || col < 0) {
            col = (col + field.getWidth()) % field.getWidth();
        }

        return field.isAlive(row, col);
    }
}
