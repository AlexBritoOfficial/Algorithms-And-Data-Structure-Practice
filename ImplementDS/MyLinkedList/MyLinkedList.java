package ImplementDS.MyLinkedList;


import ImplementDS.MyList;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<E> implements MyList<E> {
    /**
     * Head of the List
     **/
    private Node<E> head;
    /**
     * Tail of the List
     **/
    private Node<E> tail;
    /**
     * The size of MyLinkedList will be in respect to the ith index that we are currently at, as we iterate
     * through the array we pass into the MyLinkedList constructor, to construct the Data Structure.
     **/
    private int size = 0;

    /**
     * Creates a default Linked List
     **/
    public MyLinkedList() {
    }

    /**
     * Creates a linked list from n array of elements
     **/
    public MyLinkedList(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    /**
     * Adds an element to the head of the list
     **/
    public void addFirst(E e) {
        // Create new node.
        Node newNode = new Node(e);
        // Link new nodes Node next member to point to the current head for the swap.
        newNode.next = head;
//        newNode.previous = head;
        // Assign new node to point to head.
        head = newNode;
        // Increment size list
        size++;
        // Check if our tail member type is empty meaning, there is only one node in the list. If true, tail will point to head.
        if (tail == null) {
            tail = head;
        }
    }

    /**
     * Adds an element to the tail of the list
     **/
    public void addLast(E e) {
        // Create new node
        Node newNode = new Node(e);

        // Check if tail is null. If tail is null,
        if (size == 0) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Returns the first element of the Linked List
     **/
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        return head.data;
    }

    /**
     * Returns the last element of the Linked List
     **/
    public E getLast() {
        if (size == 0) {
            return null;
        }
        return head.data;
    }

    /**
     * Removes the first element of the Linked List
     **/
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }
            return temp.data;
        }
    }

    /**
     * Removes the last element of the Linked List
     **/
    public E removeLast() {
        // If size equals 0, simply return null;
        if (size == 0) {
            return null;
        }
        // If size equals 1, there only exists one Node in the list;
        else if (size == 1) {
            // Store head node in temp node.
            Node<E> temp = head;
            // Initialize head and tail to be null.
            head = tail = null;
            // Initialize size back to zero, because there is nothing in the linked list!!!!
            size = 0;
            // Return data that once to exist in the head node but is now in temp!!!
            return temp.data;
        } else {
            // Node current will be used to iterate through the list, putting us one Node
            Node<E> current = head;
            for (int i = 1; i < size - 2; i++) {
                current = current.next;
            }
            // Store tail node in a temp node.
            Node<E> temp = tail;
            // Point tail at the current node
            current = tail;
            // Point current.next to null, indicating we are at the end of the list.
            current.next = null;
            // Decrement size by 1
            size--;
            // Return data that once to exist in the tail node but is now in temp!!!
            return temp.data;
        }
    }

    @Override
    public void add(int index, E element) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be greater than zero!!!");
        } else if (index == 0) {
            addFirst(element);
        } else if (index >= size) {
            addLast(element);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(element);
            (current.next).next = temp;
            size++;
        }
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object element) {
        return 0;
    }

    @Override
    public E remove(int index) {
        if (size == 0) {
            return (E) "The list is empty!.";
        } else if (index >= 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return (E) removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.data;
        }
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E elememt = current.data;
            current = current.next;
            return elememt;
        }
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    private static class Node<E> {
        /**
         * A static nested class may be instantiated without instantiating its outer class.
         **/
        E data;
        Node<E> next;
//        Node<E> previous;

        public Node(E data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
//        Integer [] l1 = {2,4,32,44,43,12,34,43,82,94,53};
        Integer[] l1 = {2, 4, 32};
        MyLinkedList list1 = new MyLinkedList(l1);
        list1.add(2,54);
    }
}
