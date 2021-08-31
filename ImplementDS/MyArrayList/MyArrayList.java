package ImplementDS.MyArrayList;

import ImplementDS.MyList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {

    /**
     * Initial Capacity
     **/
    public static final int INITIAL_CAPACITY = 16;

    /**
     * Array for storing elements in this array list
     **/
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    /**
     * The number of elements in the array list
     **/
    private int size = 0;

    /**
     * Creates a default arraylist
     **/
    public MyArrayList() {
    }

    ;


    /**
     * Creates an arraylist from an of objects
     **/
    public MyArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index Out of Bounds!");
        }

        ensureCapacity();

        /** Move elements to the right  **/
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        /** Insert New Element to data[index] **/
        data[index] = element;

        /** Increase size by 1 **/
        size++;
    }

    /**
     * Create a new larger array, double the current size + 1
     **/
    public void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) new Object[INITIAL_CAPACITY * 2 + 1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds!!!");
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        return 0;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public class MyArrayListIterator implements Iterator<E> {

        int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            return data[current++];
        }
    }

    public static void main(String[] args) {
        Integer[] myIntegers = {10, 20, 39, 40};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(myIntegers);
        myArrayList.add(4, 60);
    }
}
