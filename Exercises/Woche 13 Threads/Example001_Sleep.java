/** Main class of the example. */

// Beispiel nur für einen normalen Hauptthread, nur um sleep zu demonstrieren
public class Example001_Sleep {
    public static void main(String[] args) {

        System.out.println("Start sleeping ...");
        
        try {
            Thread.sleep(1000); // time to wait in milliseconds // schlafe 3 Sekunden
            System.out.println(1);
            Thread.sleep(1000);
            System.out.println(2);
            Thread.sleep(1000);
            System.out.println(3);
        } catch (InterruptedException ie) { }

        System.out.println("... done finally!");
    }
}

// TODO
// - Change the code, so that while waiting the numbers 1, 2 and 3 are printed each after a second.