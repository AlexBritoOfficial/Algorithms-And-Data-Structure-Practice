package ImplementDS.MyQueue;

public class CormenQueue {

    private int head;
    private int tail;
    private int n;
    private int [] Q;

    public CormenQueue(int n){
        head = tail = 0;
        this.n = n;
        this.Q = new int[n];
    }

    public void enqueue(int element){
        Q[tail] = element;

        if(tail == n){
            tail = 0;
        }

        else {
            ++tail;
        }
    }

    public int dequeue(){
        int element = Q[head];

        Q[head] = 0;

        if(head == n){
            head = 0;
        }

        else {
            ++head;
        }
        return element;
    }



    public static void main(String[] args) {
        CormenQueue cormenQueue = new CormenQueue(6);
        cormenQueue.enqueue(1);
        cormenQueue.enqueue(2);
        cormenQueue.enqueue(3);
        cormenQueue.enqueue(4);
        cormenQueue.dequeue();
        cormenQueue.dequeue();
        cormenQueue.enqueue(1);
        cormenQueue.enqueue(2);

    }
}
