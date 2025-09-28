package edu.grinnell.csc207.listlab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class LinkedListTests {
    @Test
    public void emptyListTest() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
    }

    @Test
    public void listAddSize10() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
    }

    @Test
    public void removed() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(list.remove (5), 6);
    }

    @Test
    public void removeLast() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(list.remove (8), 9);
    }

    @Test
    public void getChecked() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(list.get (9), 9);
    }

    @Property
    public boolean listAddSize(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }
        return list.size() == sz;
    }

    @Test
    public void listAddAtIndex() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(3,20);
        assertEquals(list.get (3), 20);
    }

     @Test
    public void doesContain() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        
        assertEquals(list.contains (3), true);
    }

      @Test
    public void indexOfTest() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        
        assertEquals(list.indexOf (5), 5);
    }
}
