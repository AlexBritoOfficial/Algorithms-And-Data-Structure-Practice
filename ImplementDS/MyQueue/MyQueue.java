package ImplementDS.MyQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<E>  {
    LinkedList<E> linkedList = new LinkedList<>();

    public void enqueue(E e){
        linkedList.addLast(e);
    }

    public E dequeue(){
        return linkedList.removeFirst();
    }

    public int getSize(){
        return linkedList.size();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

//    Node<E> head, tail;
//    int size = 0;
//
//    public MyQueue() {
//    }
//
//
//
//    public boolean add(E e) {
//        Node<E> newNode = new Node<>(e);
//        // 60 70 90
//        if (size == 0) {
//            head = tail = newNode;
//        } else {
//            tail.next = newNode;
//            tail = newNode;
//        }
//        size++;
//        return true;
//    }
//
//    private void print() {
//        Node<E> current = head;
//        for (int i = 0; i < size; i++) {
//            System.out.println(current.element);
//            current = current.next;
//        }
//    }
//
//    public boolean isEmpty(){
//        return size == 0;
//    }
//
//    class Node<E> {
//        E element;
//        Node next;
//
//        public Node(E element) {
//            this.element = element;
//        }
}




