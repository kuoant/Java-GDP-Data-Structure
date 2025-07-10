package threads;

public class Main {

    public static void main(String[] args) {
        // Ihre Implementation

        Queue q = new Queue();

        Reader reader = new Reader(q);
        Writer writer = new Writer(q);

        reader.start();
        writer.start();
    
    }

}

    
