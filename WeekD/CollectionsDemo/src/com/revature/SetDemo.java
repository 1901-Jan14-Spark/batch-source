package com.revature;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		
		/*
		 *  HashSet
		 *  - no duplicates 
		 *  - not sorted or ordered
		 *  - order can change over time
		 *  
		 */
		HashSet<Integer> hSet1 = new HashSet<Integer>();
		hSet1.add(2);
		hSet1.add(5);
		hSet1.add(3);
		hSet1.add(4);
		hSet1.add(8);
		hSet1.add(10);
		hSet1.add(10);
		System.out.println(hSet1);
		
		/*
		 * LinkedHashSet
		 * - HashSet with a linked list running through it
		 * - will maintain insertion order
		 * 
		 */
		LinkedHashSet<Integer> lhSet1 = new LinkedHashSet<Integer>();
		lhSet1.add(2);
		lhSet1.add(5);
		lhSet1.add(3);
		lhSet1.add(4);
		lhSet1.add(8);
		lhSet1.add(10);
		lhSet1.add(10);
		System.out.println(lhSet1);
		
		/*
		 * TreeSet 
		 * - sorted by natural ordering
		 * 
		 */
		TreeSet<Integer> tSet1 = new TreeSet<Integer>();
		tSet1.add(2);
		tSet1.add(5);
		tSet1.add(3);
		tSet1.add(4);
		tSet1.add(8);
		tSet1.add(10);
		tSet1.add(10);
		System.out.println(tSet1);
		
		
		/*
		 * HashSet (Strings)
		 * 
		 */
		HashSet<String> hSet2 = new HashSet<String>();
		hSet2.add("alpha");
		hSet2.add("bravo");
		hSet2.add("charlie");
		hSet2.add("delta");
		hSet2.add("echo");
		System.out.println(hSet2);
		
		/*
		 * TreeSet (Strings)
		 * 
		 */
		TreeSet<String> tSet2 = new TreeSet<String>();
		tSet2.add("charlie");
		tSet2.add("delta");
		tSet2.add("echo");
		tSet2.add("alpha");
		tSet2.add("bravo");
		System.out.println(tSet2);

		/*
		 * HashSet (IceCream)
		 * 
		 */
		HashSet<IceCream> iceCreamSet = new HashSet<IceCream>();
		iceCreamSet.add(new IceCream("chocolate", 3, new String[] {"sprinkles", "fudge"}));
		iceCreamSet.add(new IceCream("strawberry", 4, new String[] {"strawberries"}));
		iceCreamSet.add(new IceCream("vanilla", 2, new String[] {"whipped cream", "fudge", "cherry"}));
		System.out.println(iceCreamSet); // implicitly using the toString
		
		/*
		 * TreeSet (IceCream)
		 * - tree set will look for the natural ordering
		 * - if our object doesn't have implicit natural ordering,
		 *   it will rely on the Comparable interface's compareTo method
		 */
		TreeSet<IceCream> iceCreamSet2 = new TreeSet<IceCream>();
		iceCreamSet2.add(new IceCream("chocolate", 3, new String[] {"sprinkles", "fudge"}));
		iceCreamSet2.add(new IceCream("strawberry", 4, new String[] {"strawberries"}));
		iceCreamSet2.add(new IceCream("vanilla", 2, new String[] {"whipped cream", "fudge", "cherry"}));
		System.out.println(iceCreamSet2); 
	}
	
	
}
