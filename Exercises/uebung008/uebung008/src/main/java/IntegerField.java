public class IntegerField implements Field {
        int[][] field;
        int height;
        int width;
    
        IntegerField(int height, int width) {
            this.height = height;
            this.width = width;
            this.field = new int[height][width];
        }
    
        /**
         * Returns if a cell at a specified position is alive or not.
         */
        public boolean isAlive(int row, int col) {
            return (this.field[row][col] == 1);
        }
    
        /**
         * Set a cell as alive at a given position.
         */
        public void setAlive(int row, int col) {
            this.field[row][col] = 1;
        }
            
        /**
         * Set a cell as not alive at a given position.
         */
        public void setNotAlive(int row, int col) {
            this.field[row][col] = 0;
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
