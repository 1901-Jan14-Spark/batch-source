package com.revature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		
		/*
		 * HashMap
		 * - stores key value pairs
		 * - essentially an array of linked lists 
		 * - uses hashcode to determine location of entries
		 * - no particular order
		 */
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("Sally", 965);
		scores.put("Jonah", 862);
		scores.put("Lisa", 805);
		scores.put("Paul", 950);
		
//		System.out.println(scores.containsKey("Lisa"));
//		System.out.println(scores.containsKey("Molly"));
//		System.out.println(scores.get("Lisa"));
//		System.out.println(scores.get("Molly"));
		
//		Set<String> keySet = scores.keySet();
//		for(String key : keySet) {
//			System.out.println(key);
//		}
		
		scores.put("Julie", 800);
		scores.put("Cindy", 642);
		scores.put("Charles", 538);
		scores.put("Newton", 990);
		
//		System.out.println();
//		Set<String> keySet2 = scores.keySet();
//		for(String key : keySet2) {
//			System.out.println(key);
//		}
		
		/*
		 * TreeMap 
		 * - keys are ordered in their natural order 
		 * 
		 */
		TreeMap<String, Integer> scores2 = new TreeMap<String, Integer>();
		scores2.put("Sally", 965);
		scores2.put("Jonah", 862);
		scores2.put("Lisa", 805);
		scores2.put("Paul", 950);
		
//		Set<String> keySet3 = scores2.keySet();
//		for(String key : keySet3) {
//			System.out.println(key);
//		}
		
		scores2.put("Julie", 800);
		scores2.put("Cindy", 642);
		scores2.put("Charles", 538);
		scores2.put("Newton", 990);
		
//		System.out.println();
//		Set<String> keySet4 = scores2.keySet();
//		for(String key : keySet4) {
//			System.out.println(key);
//		}
		
		/*
		 * TreeMap 
		 */
		
		TreeMap<IceCream,Integer> iceCreamMap = new TreeMap<IceCream,Integer>();
		iceCreamMap.put(new IceCream("chocolate", 3, new String[] {"sprinkles", "fudge"}), 5);
		iceCreamMap.put(new IceCream("black raspberry", 3, new String[] {"gummy bears","marshmallows"}), 3);
		iceCreamMap.put(new IceCream("strawberry", 4, new String[] {"strawberries"}), 10);
		iceCreamMap.put(new IceCream("red velvet", 5, new String[] {"cheese cake bites","jimmies"}), 4);
				
		Set<IceCream> iceCreamSet = iceCreamMap.keySet();
		for(IceCream iceCream : iceCreamSet) {
			System.out.println(iceCream+" got "+iceCreamMap.get(iceCream)+" votes");
		}
		
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("hello");
		
	}
	

}
