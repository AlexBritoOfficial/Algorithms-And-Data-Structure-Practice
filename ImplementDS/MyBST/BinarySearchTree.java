package ImplementDS.MyBST;



import ImplementDS.MyQueue.MyQueue;
import ImplementDS.Tree;

import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>> implements Tree<E> {

    protected TreeNode<E> root;

    protected int size = 0;

    public BinarySearchTree(E[] e) {
        for (int i = 0; i < e.length; i++) {
            add(e[i]);
        }
    }

    @Override
    public boolean search(E e) {
        /** Use current to reference root node.
         * **/
        TreeNode<E> current = root;

        while (current != null) {

            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                return true;
        }

        return false;
    }


    /**
     * Insert element e into the binary tree
     * Return true if the element is inserted successfully
     * //
     **/
    @Override
    public boolean insert(E e) {
        // Create root node if root is null
        if (root == null) {
            root = createNewNode(e);
        }
        // Else locate the parent node
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;

            while (current != null) {

                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }

            // Create the new node and attach it to the parent node.
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }


    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break;
        }

        if (current == null) {
            return false;
        }

        // Case 1: Current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else
                    parent.right = current.right;
            }
        } else {
            // Case 2: The current node has a left child
            // Locate the rightMost node in the left subtree of
            // the current node and also it's parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true;
    }

    /**
     * Returns a path from the root.leading to the specified element
     **/
    public ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> pathList = new ArrayList<>();
        TreeNode<E> current = root;

        while (current != null) {
            pathList.add(current);

            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }
        return pathList;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    // Inner class InorderIterator
    private class InorderIterator implements Iterator<E>{
        // Store elements in a list
        private ArrayList<E> list = new ArrayList<>();

        private int current = 0; // Point to the current element in the list.

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in the list.
        }

        private void inorder(){
            inorder(root);
        }

        /** Inorder traversal from the root
         * @param root**/
        private void inorder(TreeNode<E> root){
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override /** More elements for traversing? **/
        public boolean hasNext() {
            if(current < list.size()){
                return true;
            }
            return false;
        }

        @Override /** Get the current element and move to the next **/
        public E next() {
            return list.get(current++);
        }

        @Override /** Remove the current element **/
        public void remove() {
            if(current == 0){
                throw new IllegalArgumentException();
            }

            delete(list.get(current--));
            list.clear(); // Clear the list
            inorder();
        }
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Create new Tree Node
     **/
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E element) {
            this.element = element;
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode<E> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.element + " ");
        inOrder(root.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    /** Recursively visits it's current nodes left tree, then the current nodes right, and finally the current node itself**/
    private void postOrder(TreeNode<E> root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.element + " ");
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(TreeNode<E> root) {
        System.out.print(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void breadthFirstSearch() {
        MyQueue<TreeNode<E>> myQueue = new MyQueue<>();
        myQueue.enqueue(root);

        while(!myQueue.isEmpty()){
            /**
             * while queue is not empty
             *
             *  TreeNode treeNode <- myQueue.dequeue
             *
             *  sout(treeNode.element);
             *
             *  if(treenode.left != null ){
             *     myQueue.add(treeNode.left);
             *  }
             * 
             *  if(treenode.right != null ){
             *   myQueue.add(treeNode.right);
             *  }
             * ***/
            TreeNode<E> treeNode = myQueue.dequeue();
            System.out.print(treeNode.element + " ");
            if(treeNode.left != null ){
                myQueue.enqueue(treeNode.left);
            }
            if(treeNode.right != null ){
                myQueue.enqueue(treeNode.right);
            }
        }
    }

    public static void main(String[] args) {
        final int min = 1;
        final int max = 300;
        final int SIZE = 10;
        Integer [] array = {238, 88, 114, 172, 184, 103, 60, 50, 246, 28};

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(array);
        binarySearchTree.delete(114);


    }
}
