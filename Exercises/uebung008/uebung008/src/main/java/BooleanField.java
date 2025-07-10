public class BooleanField implements Field {
    boolean[][] field;
    int height;
    int width;

    BooleanField(int height, int width) {
        this.height = height;
        this.width = width;
        this.field = new boolean[height][width];
    }

    /**
     * Returns if a cell at a specified position is alive or not.
     */
    public boolean isAlive(int row, int col) {
        return this.field[row][col];
    }

    /**
     * Set a cell as alive at a given position.
     */
    public void setAlive(int row, int col) {
        this.field[row][col] = true;
    }
        
    /**
     * Set a cell as not alive at a given position.
     */
    public void setNotAlive(int row, int col) {
        this.field[row][col] = false;
    }

    /**
     * Returns the with of the field.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the field.
     */
    public int getHeight() {
        return this.height;
    }
    
}
