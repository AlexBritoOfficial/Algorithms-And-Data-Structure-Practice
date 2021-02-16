package com.company.ImplementDS;

import com.company.ImplementDS.MyBST.BinarySearchTree;

import java.util.Iterator;

public class Main<E> {

    public static void main(String[] args) {
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
//        Double [] l1 = {60.0,55.0,100.0,45.0,57.0,67.0,107.0};
        Integer [] l1 = {60,55,100,45,57,67,107};
        BinarySearchTree root = new BinarySearchTree(l1);
//        root.insert(56.0);
//        root.insert(59.0);
//        root.delete(57.0);
//        root.insert(44.0);
//        root.insert(46.0);
//        root.insert(48.0);
//        root.insert(49.0);
//        root.insert(44.5);
//        root.insert(44.8);
//        root.insert(43.0);
//        root.insert(42.8);
//        root.insert(44.8);
//        root.insert(42.9);
//        root.breadthFirstSearch();
        Iterator<Integer> iterator = root.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

//      TreeNode.insert(root,101);
//      System.out.println();
//      TreeNode.insert(root,59);

//      Integer [] l1 = {2,4,32,44,43,12,34,43,82,94,53};
//      MyLinkedList list1 = new MyLinkedList(l1);
//      list1.add(9,60);
//
//      BinarySearchTree<Integer> myComputer = new BinarySearchTree<Integer>();

//      Iterator<Integer> listIterator = list1.iterator();
//
//      while(listIterator.hasNext()){
//        System.out.println("Element: " + listIterator.next());
//      }
    }
}
