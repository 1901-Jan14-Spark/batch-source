package com.revature.linkedlist;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class Driver {
static	LinkedList<Integer> list = new LinkedList<Integer>();
public static void main(String[] args) {
	 // head = null
	list.push(3); 
	list.push(5); 
	list.push(7);
	list.push(2); 
	list.push(12); 
	list.push(9);
	list.push(200);
	//Collections.sort(list);
//	Collections.shuffle(list);
// int v=Collections.binarySearch(list, );
// list.pop();
// list.poll();
// list.pollLast();
	System.out.println(list);
}
public static LinkedList<Integer> sortAscending() {         
    Collections.sort(list);         
    return list;     
  }



}
