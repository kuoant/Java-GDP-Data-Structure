/**
 * Knoten in einer verketteten Liste
 */
class Node {
    int item; // Der Wert, der in der Liste gespeichert wird
    Node next;

    Node(int item) {
        this.item = item;
        this.next = null;
    }
}

/**
 * Implementiert eine verkettete Liste
 */
public class LinkedList {

    Node head; // Referenz auf erstes Element
    Node tail; // Referenz auf letztes Element

    /**
     * Kreiert eine leere Liste
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Gibt die Elemente der Liste aus
     */
    public void print() {

        if (head == null) {
            return;
        }

        Node n = this.head;
        while (n.next != null) {
            System.out.print(n.item + ", ");
            n = n.next;
        }

        System.out.println(n.item);
    }

    /**
     * Fügt ein neues Element am Ende der Liste hinzu
     */
    public void append(int item) {
        Node newItem = new Node(item);
        if (head == null) {
            this.head = newItem;
            this.tail = newItem;
        } else {
            this.tail.next = newItem;
            this.tail = newItem;
        }
    }



    /**
     * Gibt das grösste Element in der Liste zurück
     */
    public int max() {
        int max = Integer.MIN_VALUE;
        Node current = head;

        while (current != null) {
            if (max < current.item) {
                max = current.item;
            }
            current = current.next;
        }
        return max;


    }


    /**
     * Ordnet die Elemente in der Liste so an, dass alle negativen Elemente vor den
     * positiven Elementen kommen.
     */
    public void reorder() {
        //Node current will point to head  
        Node current = head;
        Node index = null;  
        int temp;  
          
        if (head == null) {  
            return;  
        } else {  
            while(current != null) {  
                //Node index will point to node next to current  
                index = current.next;  
                  
                while(index != null) {  
                    //If current node's data is greater than index's node data, swap the data between them  
                    if(current.item > index.item) {  
                        temp = current.item;  
                        current.item = index.item;  
                        index.item = temp;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }      
        }  
    }  

    /**
     * Invertiert die Reihenfolge der Elemente
     */
    public void invert() {
        Node previous = null;
        Node current = head;
        Node temp = null;
        
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.append(10);
        linkedList.append(50);
        linkedList.append(-3);
        // linkedList.append(10);
        // linkedList.append(-13);
        // linkedList.append(-23);
        linkedList.invert();
        linkedList.print();


    }

}
