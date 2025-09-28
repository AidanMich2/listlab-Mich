package edu.grinnell.csc207.listlab;

/**
 * An array-based implementation of the list ADT.
 */
public class ArrayList {

    private int size;
    private int[] array;


    public ArrayList (){
        size = 0;
        array = new int[8];
    }
    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        // throw new UnsupportedOperationException("Unimplemented method 'add'");
        if (array.length == size){
            expand();
        }
        array[size] = value;
        size++;
    }

    private void expand() {
        int nsize = array.length * 2;
        int[] narray = new int[nsize];
        for(int i = 0; i < array.length; i++){
            narray[i] = array[i];
        }
        array = narray;
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
        return array[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        int value = array[index];
        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
        return value;
    }
}
