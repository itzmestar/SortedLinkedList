package com.xenum.sortedlinkedlist;

public class SortedLinkedList<E> implements SortedList, Cloneable {

	/*  Class Node  */
	class Node<E> {
		E data;
		Node<E> next;
		
		Node (E newData){
			this.data=newData;
			this.next=null;  
			}
	}
	
	//size of the linked list
	private int size;
	
	// a reference to the first node in the list
	private Node head;
	
	//default constructor
    public SortedLinkedList()
    {
    	head=null;
        size = 0;
    }
	
	/* isEmpty
 	 * inputs: none
 	 * return value: returns true if there are no items in linked list
 	 */
	public boolean isEmpty(){ 
		return (head == null); 
	}
	
	@Override
	public boolean add(Comparable item) {
		//raise exception if null
		if ( item == null){
			throw new NullPointerException();
		}
		
		//raise exception if not valid object
		if (!(item instanceof Comparable)){
			throw new ClassCastException();
		}
		
		// make the new node to insert into list
		Node newNode = new Node(item);
		// first see if the list is empty
		if (isEmpty()){
			//for testing
			//System.out.println("add "+item +" to front");
			head = newNode;
			size++;
			return true;
		}
		// there is something in the list
		// now check to see if it belongs in front
		else if (item.compareTo(head.data) < 0)	{
			//for testing
			//System.out.println("add ("+item +") before ("+head.data+")");
			newNode.next = head;
			head = newNode;
			size++;
			return true;
		}
		// otherwise, step down the list.  n will stop 
		// at the node after the new node, and trailer will
		// stop at the node before the new node
		else {
			Node after = head.next;
			Node before = head;
			while (after != null){
				if (item.compareTo(after.data) < 0)
					break;
				before = after;
				after = after.next;
			}
			// insert between before & after
			newNode.next = before.next;
			before.next = newNode;
			size++;
			//for testing
			//System.out.println("add ("+item +") after ("+before.data+")");
			return true;
		}
	}

	@Override
	public void clear() {
    	head=null;
        size = 0;
	}

	@Override
	public boolean contains(Object o) {
		//raise exception if null
		if ( o == null){
			throw new NullPointerException();
		}
		
		if(size()==0){
			return false;
		}
		Node ptr = head;
		
		if(head.data.getClass()!=o.getClass()){
			throw new ClassCastException();
		}
		
		// for each node in the linked list
		while (ptr != null)
		{
			// if it is equal, return true
			if (o.equals(ptr.data))
				return true;
			ptr = ptr.next;
		}
		return false;
	}

	@Override
	public Comparable get(int index) {
		if(index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		
		Node ptr = head;
		//iterate to the index and return data
		for(int i=0;i<index;i++){
			ptr = ptr.next;
		}
		return (Comparable) ptr.data;
	}

	@Override
	public int indexOf(Object o) {
		//if null
		if ( o == null){
			return -1;
		}
		
		if(size()==0){
			return -1;
		}
		
		Node ptr = head;
		
		//if not valid object
		if(head.data.getClass()!=o.getClass()){
			return -1;
		}
		
		// for each node in the linked list
		int index=0;
		while (ptr != null)
		{
			// if it is equal, return true
			if (o.equals(ptr.data))
				return index;
			index++;
			ptr = ptr.next;
		}
		return -1;
	}

	@Override
	public Comparable remove(int index) {
		if(index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		
		Node ptr=head, prev = null;
		//if remove first node
        if (index == 0) {
        	head = head.next;
            size--; 
            return (Comparable) ptr.data;
        }
        //less remove any other node
        for (int i = 0; i<index; i++){
        	prev = ptr;
        	ptr = ptr.next;
        }
        
        // Unlink the node from linked list
        prev.next = ptr.next;
        size-- ;
		return (Comparable) ptr.data;
	}

	@Override
	public boolean remove(Object key) {
		//raise exception if null
		if ( key == null){
			throw new NullPointerException();
		}

		if(size()==0){
			return false;
		}
		
	    // Store head node
        Node temp = head, prev = null;
		
		//raise exception if not valid object
		if(head.data.getClass()!=key.getClass()){
			throw new ClassCastException();
		}
 
        // If head node itself holds the key to be deleted
        if (temp != null && key.equals(temp.data))
        {
            head = temp.next; // Changed head
            return true;
        }
 
        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && (!key.equals(temp.data)))
        {
            prev = temp;
            temp = temp.next;
        }    
 
        // If key was not present in linked list
        if (temp == null) return false;
 
        // Unlink the node from linked list
        prev.next = temp.next;
		return true;
	}

	@Override
	public int size() {
		 return size;
	}

	@Override
	public String toString(){
		String s="[";
		Node temp = head;
		if (temp!=null){
			s = String.format("%s%s", s, temp.data);
			temp=temp.next;
		}
		while(temp!=null){
			s = String.format("%s, %s", s, temp.data);
			temp=temp.next;
		}
		
		s = String.format("%s]",s);
		return s;
	}
	

	public Object clone()
            throws CloneNotSupportedException{
		SortedLinkedList<E> l=new SortedLinkedList();
		
		for(int i=0;i<size();i++){
			E item=(E) this.get(i);
			l.add((Comparable) item);
		}
		return l;		
	}
	
	@Override
	public boolean equals(Object o){
		//if null
		if ( o == null){
			return false;
		}
		
		// if not valid object
		if (!(o instanceof SortedLinkedList)){
			//System.out.println("instance");
			return false;
		}
		
		SortedLinkedList oll=(SortedLinkedList) o;
		//compare size first.
		if(oll.size()!=this.size()){
			//System.out.println("size");
			return false;
		}
		
		Node ptr=head;
		//compare each node in the list to be equal
		for(int i=0;i<this.size;i++){
			if (!(oll.get(i).equals(ptr.data))){
				//System.out.println(i);
				return false;
			}
			ptr=ptr.next;
		}
		
		return true;
	}
}