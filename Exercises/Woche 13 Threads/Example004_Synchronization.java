// Problem zwei threads greifen auf gleiche Variable zu.
// Das Betriebssystem sagt hier, wann welcher thread dran ist.
// Man fügt vielleicht 300 hinzu. Wie lang hat jeder thread geearbeitet?

/** Main class of the example. */
public class Example004_Synchronization {

    public static void main(String[] args) {

        // setup producer-storage-consumer situation
        Storage s = new Storage();
        Thread producer = new Actor( 1, s);
        Thread consumer = new Actor(-1, s);
        System.out.println("Starting with " + s.amount + " items in the storage.");

        

        // start threads
        producer.start();
        consumer.start();

        // wait until threads have finished execution
        try {
            synchronized(s) {
                producer.join();
                consumer.join();
            }
        } catch ( InterruptedException ie) { }

        // show how much is in the storage
        System.out.println(s.amount + " items are in the storage at the end.");
    }
}

/** Example class that holds some data. */
class Storage {
    int amount = 1000;

    /** Add the passed value to the amount. */
    /*synchronized*/ void add(int value) { // könnte so als Methode deklariert werden mit dem gleichen Ergebnis wie beim Block
        this.amount += value;
    }
}

/** Thread class that adds 10k times the specified amount to the storage. */
class Actor extends Thread {
    private int change;
    private Storage s;

    /** Create an actor that changes the storage by a specified amount. */
    Actor(int change, Storage s) {
        this.change = change;
        this.s = s;
    }

    /** Change the storage 10k times. */
    @Override
    public void run() {
        for(int i = 0; i < 10000; i = i + 1) {
            s.add(change);
        }
    }

    // Consumer entfernt 100000 mal etwas und Producer fügt 100000 mal was hinzu

}

// TODO
// - Add synchronization to the example, such that the final result is deterministic.