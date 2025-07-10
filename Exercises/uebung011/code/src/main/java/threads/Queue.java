package threads;

import java.util.NoSuchElementException;

class Node {
    String value;
    Node next;

    Node(String s) {
        this.value = s;
    }
}

public class Queue {

    Node head;
    Node tail;

    public void enqueue(String s) {

        Node n = new Node(s);

        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public String dequeue() throws NoSuchElementException {

        if (head == null) {
            throw new NoSuchElementException("tried to dequeue element from empty queue");
        }

        String s = head.value;
        
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        System.out.println("dequeuing " + s + " isempty " + isEmpty());
        return s;
    }

    public boolean isEmpty() {
        return (head == null);
    }

}
