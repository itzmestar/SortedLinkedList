package com.xenum.sortedlinkedlist;

public class Test{
	public static void main(String[] args)
    {
		SortedLinkedList l= new SortedLinkedList();
		
		l.add(100);
		l.add(34);
		l.add(1000);
		l.add(34);
		l.add(56);
		l.add(1);
		l.add(7);
		
		System.out.println(" List l = "+l);
		
		SortedLinkedList l1= new SortedLinkedList();
		l1.add("zoom");
		
		l1.add("boom");
		
		l1.add("auch");
		
		l1.add("vroom");
		
		l1.add("doom");
		
		System.out.println(" List l1 = "+l1);
    }
}