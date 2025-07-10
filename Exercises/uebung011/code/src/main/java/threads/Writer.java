package threads;

public class Writer extends Thread {

  Queue q;

  public Writer(Queue q) {
      this.q = q;
  }

  public void run(){

    while (true) {

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      synchronized(q) {

        while(!q.isEmpty()){

          String out = q.dequeue();
          System.out.println(out);

        }
      }
    }
  }

  public static void main(String[] args) {
    
  }
}
