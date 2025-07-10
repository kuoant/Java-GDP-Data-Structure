/** Simple thread that sleeps three seconds before it's done. */
class SleeperThread extends Thread {

    /** The run methode specifies what the thread will do. */
    @Override
    public void run() {
        System.out.println("Start sleeping in Thread ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
        System.out.println("... done finally!");
    }
    
}

/** Main class of the example. */
public class Example002_Thread {

    public static void main(String[] args) {

        // Creates an object representing a thread.
        Thread thread = new SleeperThread();
        
        System.out.println("Starting thread");

        // The next line does not create a thread. It's just an ordinary call of a method
        // thread.run(); // Fehler: es müsste run heissen. Heisst, es wird gar kein neuer Thread gestartet. Es führt alles wie sonst auch aus.
        
        // // Only here, the thread is actually started
        thread.start(); // wenn mittels start() aufgerufen wird, dann wird direkt done! aufgerufen (der andere Thread schläft währenddessen)
        System.out.println("Thread started.");

        // Wait for the thread to finish
        try {
            thread.join(); // hier sagen wir dem Hauptprogramm: warte bitte, bis der Nebenthread fertig geschlafen hat.
            // heisst jetzt wird das done wieder erst am Ende ausgegeben. Da das Hauptprogramm warten muss.
        } catch (InterruptedException ie) {
        }

        System.out.println("Done!");
    }
}
