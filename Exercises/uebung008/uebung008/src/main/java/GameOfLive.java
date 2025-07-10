/**
 * The game that knows how to evolve given the field and the rules.
 */
public abstract class GameOfLive {
    Field field;
    Rules rules;

    /**
     * Creates the rules, the field and initializes the field using the abstract methods.
     */
    public GameOfLive() {
        this.field = createField();
        this.rules = createRules();

    }

    /**
     * Creates rules, yet undefined.
     * @return Returns the rules that should be used.
     */
    abstract public Rules createRules();

    /**
     * Create a field, yet undefined.
     * @return Returns a newly created field.
     */
    abstract public Field createField();

    /**
     * Some way of initializing a field, yet undefined.
     * @param field Initializes the passed field.
     */
    abstract public void init(Field field);

    /**
     * Evolves the game by one iteration applying the rules.
     */
    public void evolve() {
        
            Field newField = new BooleanField(field.getHeight(), field.getWidth());
    
            for (int row = 0; row < field.getHeight(); row++) {
                for (int col = 0; col < field.getWidth(); col++) {
                    if (rules.willBeAlive(field, row, col)) {
                        newField.setAlive(row, col);
                    } else {
                        newField.setNotAlive(row, col);
                    }
                }
            }
            field = newField;
        }
    
    /**
     * Printing the game state just prints the field.
     */
    public void print() {
        this.field.print();
    }

}
