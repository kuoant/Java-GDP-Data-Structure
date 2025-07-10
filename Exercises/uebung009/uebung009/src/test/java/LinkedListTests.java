import org.junit.Test;
import org.junit.Before;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

public class LinkedListTests {

    LinkedList longList = null;
    LinkedList oneElementList = null;

    private LinkedList createLongList() {
        longList = new LinkedList();
        longList.append(7);
        longList.append(-1);
        longList.append(10);
        longList.append(-8);
        longList.append(-10);
        longList.append(22);
        return longList;
    }

    private LinkedList createOneElementList() {
        oneElementList = new LinkedList();
        oneElementList.append(1);
        return oneElementList;
    }

    private static ArrayList<Integer> listToArrayList(LinkedList ll) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Node node = ll.head;
        while (node != null) {
            al.add(node.item);
            node = node.next;
        }
        return al;
    }

    @Test(timeout = 1000)
    public void testMaximum() {
        testMaximumLongList();
        testMaximumOneElementList();
    }

    @Test
    public void testMaximumLongList() {
        LinkedList longList = createLongList();
        assertEquals(22, longList.max());
    }

    @Test
    public void testMaximumOneElementList() {
        LinkedList oneElementList = createOneElementList();
        assertEquals(1, oneElementList.max());
    }

    @Test
    public void testMaximumEmptytList() {
        LinkedList ll = new LinkedList();
        assertEquals(Integer.MIN_VALUE, ll.max());
    }

    @Test(timeout = 1000)
    public void testReorder() {
        LinkedList ll = createLongList();
        ArrayList<Integer> listBefore = listToArrayList(ll);
        ll.reorder();
        ArrayList<Integer> listAfter = listToArrayList(ll);
        assertEquals(listBefore.size(), listAfter.size());

        for (Integer i : listBefore) {
            assertTrue(listAfter.contains(i));
        }

        boolean foundFirstPositive = false;
        for (Integer i : listAfter) {
            if (i >= 0) {
                foundFirstPositive = true;
            }
            assertTrue((foundFirstPositive && i >= 0) || (!foundFirstPositive && i <= 0));

        }
    }

    @Test(timeout = 1000)
    public void testReorderOneElement() {
        LinkedList ll = createOneElementList();
        ArrayList<Integer> listBefore = listToArrayList(ll);
        ll.reorder();
        ArrayList<Integer> listAfter = listToArrayList(ll);
        assertEquals(1, listAfter.size());
        assertEquals(listBefore.get(0), listAfter.get(0));
        assertEquals(ll.head, ll.tail);
    }

    @Test(timeout = 1000)
    public void testReorderEmptyList() {
        LinkedList ll = new LinkedList();
        ll.reorder();
        assertEquals(ll.head, null);
        assertEquals(ll.tail, null);
    }

    @Test(timeout = 1000)
    public void testInvert() {
        testInvertEvenNumberOfElements();
        testInvertOddumberOfElements();
    }

    @Test
    public void testInvertEvenNumberOfElements() {
        LinkedList ll = createLongList();
        testInvertImpl(ll);

    }

    @Test
    public void testInvertOddumberOfElements() {
        LinkedList ll = createLongList();
        ll.append(99);
        testInvertImpl(ll);

    }

    @Test(timeout = 1000)
    public void testInvertEmptyList() {
        LinkedList ll = new LinkedList();
        ll.invert();
        assertEquals(ll.head, null);
        assertEquals(ll.tail, null);
    }

    @Test(timeout = 1000)
    public void testInvertOneElementList() {
        LinkedList ll = createOneElementList();
        ArrayList<Integer> listBefore = listToArrayList(ll);
        ll.invert();
        ArrayList<Integer> listAfter = listToArrayList(ll);
        assertEquals(1, listAfter.size());
        assertEquals(listBefore.get(0), listAfter.get(0));
        assertEquals(ll.head, ll.tail);
    }

    private void testInvertImpl(LinkedList ll) {
        ArrayList<Integer> listBefore = listToArrayList(ll);
        ll.invert();
        ArrayList<Integer> listAfter = listToArrayList(ll);

        assertEquals(listBefore.size(), listAfter.size());

        for (Integer i : listBefore) {
            assertTrue(listAfter.contains(i));
        }

        for (int i = 0; i < listAfter.size() / 2; i++) {
            assertEquals(listBefore.get(i), listAfter.get((listAfter.size() - 1) - i));
        }
    }

}
