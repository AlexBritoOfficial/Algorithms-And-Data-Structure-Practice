package ImplementDS;

import ImplementDS.MyBST.BinarySearchTree;
import ImplementDS.MyStack.MyStack;

import java.util.Iterator;

public class Main<E>  {




    public static void main(String[] args){
       /**
        /**
        *          60
        *        /   \
        *     55      100
        *    /  \    /   \
        *  45   57 67    107
               /  \
              56  59
        **/

        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.pop());


    }
}
