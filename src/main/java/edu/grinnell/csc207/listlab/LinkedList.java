package edu.grinnell.csc207.listlab;

/**
 * A linked implementation of the list ADT.
 */
public class LinkedList {


    public static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList (){
        head = null;
        size = 0;
    }
    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        Node n = new Node (value, null);
        if (head == null){
            head = n;
            tail = n;
            size++;
        }else{
            tail.next = n;
            tail = n;
            size++;
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        int i = 0;
        Node n = head;
        while (i != index){
            n = n.next;
            i++;
        }
        return n.value;
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        Node n = head;
        int lmnt = n.value;
        if (index == 0){
            head = n.next;
        }
        else{
            int i = 0;
            while (n.next != null && i < index - 1){
                n = n.next;
                i++;
            }
            lmnt = n.next.value;
            if (index == size - 1){
                tail = n;
            }
            else{
                n.next = n.next.next;
            }
        }
        size--;
        return lmnt;
    }

    boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    void clear(){
        head = null;
        tail = null;
    }

    int indexOf(int value){
        Node n = head;
        int index = 0;
        while (n.next != null){
            if (n.value == value){
                return index;
            }
            index++;
            n = n.next;
        }
        return -1;
    }

    boolean contains(int value){
     Node n = head;
        while (n.next != null){
            if (n.value == value){
                return true;
            }
            n = n.next;
        }
        return false;
    }

    void add(int index, int value){
        Node newNode = new Node (value, null);
        Node n = head;
        int i = 1;
        if (index == 0 && n.next != null){
            newNode.next = head.next;
            head = newNode;
            size++;
            return;
        } else if (index == 0 && n.next == null){
            head = newNode;
            size++;
            return;
        }
        while (n.next != null){
            if (index == i){
                newNode.next = n.next;
                n.next = newNode;
                size++;
                return;
            }
            i++;
            n = n.next;
        }
        if (index == i){
            tail.next = newNode;
            size++;
            return;
        }
        else {
            throw new IndexOutOfBoundsException ("not within limits of list");
        }
    }

    public static void main (String [] args){
        // LinkedList list = new LinkedList();
        // for (int i = 0; i < 10; i++){
        //     list.add (i);
        //     System.out.print(list.get (i) + ",");
        // }
        // System.out.print ("\n");
        // System.out.println (list.remove (0));
        // System.out.println (list.remove (8));
        // System.out.println (list.remove (4));
        // for (int i = 0; i < list.size; i++){
        //     System.out.print(list.get (i) + ",");
        // }


        LinkedList list2 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        list2.add(3,20);
        for (int i = 0; i < list2.size; i++){
            System.out.println(list2.get (i));

        }

    }
}
