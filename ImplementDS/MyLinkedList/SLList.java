package ImplementDS.MyLinkedList;

public class SLList {


    /**
     * The first item (if it exists) is at sentinel.next
     **/
    public IntNode sentinel;
    private int size;

    public SLList() {
        this.sentinel = new IntNode(63, null);
        this.size = 0;
    }

    public SLList(int element){
        this.sentinel = new IntNode(63, null);
        this.sentinel.next = new IntNode(element, null);
        this.size++;
    }

    public void addFirst(int element){
        this.sentinel.next = new IntNode(element, this.sentinel.next);
        size++;
    }

    public int getFirst(){
        return this.sentinel.next.data;
    }

    public void addLast(int element){

        IntNode current = this.sentinel;

        while(current.next != null){
            current = current.next;
        }

        current.next = new IntNode(element, null);
        size++;
    }

    public int size(){
        return this.size;
    }

    private static class IntNode {
        public int data;
        public IntNode next;

        public IntNode(int data, IntNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SLList slList = new SLList();
        slList.addFirst(20);
        System.out.println(slList.size());
    }
}
