package com.company.ImplementDS;

import java.util.Collection;

public interface Tree<E> extends Collection<E> {

    /**
     * Return true if element is in tree
     **/
    public boolean search(E e);

    /**
     * Insert element e into the binary tree
     * Return true if the element is inserted successfully
     **/
    public boolean insert(E e);

    /**
     * Delete the specified element from the tree
     * Return true if the element is successfully deleted
     **/
    public boolean delete(E e);

    /**
     * Get the number of elements in the tree
     **/
    public int getSize();

    /**
     * InOrder Traversal from the root
     **/
    public default void inOrder() {

    }

    /**
     * PostOrder Traversal from the root
     **/
    public default void postOrder() {

    }

    /**
     * PreOrder Traversal from the root
     **/


    @Override
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public default Object[] toArray(){
        return null;
    };

    @Override
    public default <T> T[] toArray(T[] a){
        return null;
    };

    @Override
    public default boolean add(E e) {
        return insert(e);
    }

    @Override
    public default boolean contains(Object e) {
        return search((E) e);
    }

    @Override
    public default boolean remove(Object e) {
        return delete((E) e);
    }

    @Override
    public default int size() {
        return getSize();
    }

    @Override
    public default boolean containsAll(Collection<?> c){
        return false;
    };

    @Override
    public default  boolean addAll(Collection<? extends E> c){
        return false;
    };

    @Override
    public default boolean removeAll(Collection<?> c){
        return false;
    };

    @Override
    public default boolean retainAll(Collection<?> c){
        return false;
    };
}
