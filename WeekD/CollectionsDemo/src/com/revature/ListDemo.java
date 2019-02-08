package com.revature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListDemo {
	
	public static void main(String[] args) {
		
		/*
		 * LinkedList
		 * - have access to queue methods like push and pop
		 * - can have duplicates
		 * - more efficient insertion/deletion in the middle of the list than arrays or ArrayLists
		 * - index based methods provided by our List interface 
		 */
		LinkedList<IceCream> iceCreamList = new LinkedList<IceCream>();
		iceCreamList.add(new IceCream("chocolate", 3, new String[] {"sprinkles", "fudge"}));
		iceCreamList.add(new IceCream("strawberry", 4, new String[] {"strawberries"}));
		iceCreamList.add(new IceCream("vanilla", 2, new String[] {"whipped cream", "fudge", "cherry"}));
//		iceCreamList.add(new IceCream("vanilla", 2, new String[] {"whipped cream", "fudge", "cherry"}));
		
		/*
		// because a LinkedList, like any collection, implements Iterable we can use a for each loop
		System.out.println("Unsorted:");
		for(IceCream iceCream : iceCreamList) {
			System.out.println(iceCream);
		}
		
		// the sort method will use the compareTo method implemented in the IceCream class
		Collections.sort(iceCreamList);
		
		System.out.println("Sorted as a Comparable:");
		for(IceCream iceCream : iceCreamList) {
			System.out.println(iceCream);
		}
		
		FlavorComparator comparator = new FlavorComparator();
		Collections.sort(iceCreamList, comparator);
		System.out.println("Sorted with FlavorComparator:");
		for(IceCream iceCream : iceCreamList) {
			System.out.println(iceCream);
		}
		
		Comparator<IceCream> comparator2 = new ToppingsComparator(); 
		Collections.sort(iceCreamList, comparator2);
		System.out.println("Sorted with ToppingsComparator:");
		for(IceCream iceCream : iceCreamList) {
			System.out.println(iceCream);
		}
		*/
		
		// can iterate with an enhanced loop or with a normal for loop
//		for(int i=0;i<iceCreamList.size();i++) {
//			System.out.println(iceCreamList.get(i));
//		}
		
		/* 
		 * we can also use an iterator for cases where we're iterating two collections concurrently
		 * also good for when we are removing elements
		 * - next() -> returns next element in our collection
		 * - hasNext() -> returns true/false dependent on any remaining element following
		 * - remove() -> remove the current node
		 */
		Iterator<IceCream> i = iceCreamList.iterator();
		while(i.hasNext()) {
			IceCream currentElement = i.next();
//			String currentElement = (String) i.next();
			System.out.println(currentElement);
		}	
		
		/*
		 * Generics for type safety
		 */
//		ArrayList arrList = new ArrayList();
//		arrList.add("test");
//		arrList.add(5);
//		Integer firstIndex = (Integer) arrList.get(0);
//		System.out.println(firstIndex);
		
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("test");
//		arrList.add(5);
//		Integer firstIndex = (Integer) arrList.get(0);
		String firstIndex = arrList.get(0);
		System.out.println(firstIndex);
		
		
	}

}
