package com.xenum.sortedlinkedlist;

/**
 * A sorted collection.  The element in this list are stored in order determined
 * by the natural ordering of those elements (i.e., the {@code compareTo()} method
 * defined in the elements' class).  
 * The user can access elements by their integer index (position in
 * the list), and search for elements in the list.<p>
 *
 * The lists implementing this interface allow duplicate elements.  
 * They do not allow null elements.<p>
 *
 * @param <E> the type of elements in this list
 *
 * @author  T. Anwer
 */

public interface SortedList<E extends Comparable<E>> extends Cloneable {
    
    /**
     * Adds the specified element to  this list in a sorted order. 
     *
     * <p>The element added must implement Comparable<E> interface. This list 
     * does not permit null elements. 
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> if this collection changed as a result of the call
     * @throws ClassCastException if the class of the specified element
     *         does not implement Comparable<E> 
     * @throws NullPointerException if the specified element is null
     */
    public boolean add(E e); 
    
    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear(); 
    
    /**
     * Returns a shallow copy of this list. (The elements
     * themselves are not cloned.)
     *
     * @return a shallow copy of this list instance
     * @throws CloneNotSupportedException - if the object's class does 
     *         not support the Cloneable interface
     */
    public Object clone() throws CloneNotSupportedException; 
    
    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     * @throws NullPointerException if the specified element is null 
     */
    public boolean contains(Object o); 
    
    /**
     * Compares the specified object with this list for equality.  Returns
     * {@code true} if and only if the specified object is also a list, both
     * lists have the same size, and all corresponding pairs of elements in
     * the two lists are <i>equal</i>.  (Two elements {@code e1} and
     * {@code e2} are <i>equal</i> if {@code e1.equals(e2)}.)  
     * In other words, two lists are defined to be
     * equal if they contain the same elements in the same order.<p>
     *
     * @param o the object to be compared for equality with this list
     * @return {@code true} if the specified object is equal to this list
     */
    public boolean equals(Object o); 
    
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range 
     * <tt>(index < 0 || index >= size())</tt>
     */
    public E get(int index);
    
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int indexOf (Object o); 
    
    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices if such exist).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException  if the index is out of range 
     * <tt>(index < 0 || index >= size())</tt>
     */
    
    public E remove (int index); 
    
    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * {@code i} such that
     * <tt>(o.equals(get(i))</tt>
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list
     * changed as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements
     */
    public boolean remove (Object o);
    
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size(); 
    
    /**
     * Returns a string representation of this list.  The string
     * representation consists of a list of the list's elements in the
     * order they are stored in this list, enclosed in square brackets
     * (<tt>"[]"</tt>).  Adjacent elements are separated by the characters
     * <tt>", "</tt> (comma and space).  Elements are converted to strings 
     * by the {@code toString()} method of those elements.
     *
     * @return a string representation of this list
     */
    public String toString(); 

}
