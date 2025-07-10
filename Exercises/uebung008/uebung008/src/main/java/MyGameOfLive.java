public class MyGameOfLive extends GameOfLive {

        /**
     * Creates rules, yet undefined.
     * @return Returns the rules that should be used.
     */
    public Rules createRules() {
        Rules rules = new CircularBoundaryRule();
        return rules;
    }

    /**
     * Create a field, yet undefined.
     * @return Returns a newly created field.
     */
    public Field createField() {
        Field field = new IntegerField(6, 6);
        return field;
    }

    /**
     * Some way of initializing a field, yet undefined.
     * @param field Initializes the passed field.
     */
    public void init(Field field) {
        // Original
        // for (int row = 0; row < field.getHeight(); row++) {
        //     for (int col = 0; col < field.getWidth(); col++) {
        //         if (Math.random() < 0.3) {
        //             field.setAlive(row, col);
        //         } else {
        //             field.setNotAlive(row, col);
        //         }
        //     }
        // }


        // Zusatz: Variante 1 Block
        // field.setAlive(1, 1);
        // field.setAlive(1, 2);
        // field.setAlive(2, 1);
        // field.setAlive(2, 2);

        // Zusatz: Variante 2 Blinker
        // field.setAlive(1, 2);
        // field.setAlive(2, 2);
        // field.setAlive(3, 2);

        // Zusatz: Variante 3 Glider
        field.setAlive(1, 1);
        field.setAlive(1, 3);
        field.setAlive(2, 2);
        field.setAlive(2, 3);
        field.setAlive(3, 2);


    }


    
}
