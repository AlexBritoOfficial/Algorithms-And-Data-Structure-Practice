package com.company.ImplementDS;

import java.util.Collection;

public interface MyList<E> extends Collection<E> {

    /** Add new element at specified index **/
    abstract void add(int index, E element);

    /** Return an element from this list at a specified index **/
    public E get(int index);

    /** Return the index of the first matching element in this list
     * return -1 if the element does not exist **/
    public int indexOf(Object element);

    /** Return the index of the last matching element in this list
     * return -1 if the element does not exist **/
    public int lastIndexOf(E element);

    /** Remove the element from the specified index of this list
     * Shift any subsequent elements to the left
     * return the element that was removed the list **/
    public E remove(int index);

    /** Replace element at the specified index of this list
     * with the specified element and returns the new set.
     ***/
    public E set (int index, E element);

    @Override /** Add new element to the end of the list **/
    public default boolean add(E element){
        add(size(), element);
        return true;
    };

    @Override /** Return true if this list contains no elements **/
    public default boolean isEmpty(){
        return size() == 0;
    };

    @Override /** Remove the first occurrence of the element e from this list.
     Shift any subsequent elements to the left.
     Return true if element was successfully removed from the list **/
    public default boolean remove(Object e){
        if(indexOf(e) >= 0){
            remove(indexOf(e));
            return true;
        }
        else
            return false;
    };


}
