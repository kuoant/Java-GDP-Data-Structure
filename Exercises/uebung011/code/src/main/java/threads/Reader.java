package threads;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
import java.util.Scanner;

public class Reader extends Thread {
    // Ihre Implementation kommt hierhin

    Queue q;

    public Reader(Queue q) {
        this.q = q;
    }

    public void run(){

        try (Scanner scanner = new Scanner(System.in)) {

            String in = scanner.nextLine();

            while(!(in.equals("quit"))){

                synchronized(q) {
                  q.enqueue(in);
                }
                in = scanner.next();
                
                if(in.equals("quit")) {
                    System.exit(0);
                }

              }
              
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
    }
}
