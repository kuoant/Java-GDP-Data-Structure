/**
 * Main program that creates a game of life simulation.
 */
public class Application {
    /**
     * Runs a game of live simulation.
     * 
     * It iterates the simulation for a given number of generations,
     * and print the field each time.
     */
    public static void main(String[] args) {
        
        MyGameOfLive myGameOfLive = new MyGameOfLive();
        myGameOfLive.field = myGameOfLive.createField();
        myGameOfLive.init(myGameOfLive.field);
        
        for (int i = 0; i < 25; i++) {
            myGameOfLive.field.print();
            myGameOfLive.evolve();
            System.out.println("");
        }
    }
}
