package com.Revature.lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ArraylistVsLinkedlist {
static ArrayList<String> ourList= new ArrayList<String>();




public static void main(String[] args) {

ourList.add("taco");
ourList.add("hamburger");
ourList.add("salad");
ourList.add("donut");
ourList.add("zebra cake");
//ourList.add(2, "Ice Cream");
ourList.removeAll(ourList);
//ourList.remove(2);
//System.out.println(ourList.size());
//for (int i=0; i<ourList.size(); i++) {
//	String Index =  ourList.get(i);
//	System.out.println(Index);
//}
//if (ourList.size()>0){
//System.out.println(sortAscending().get(sortAscending().size()-1));
//}
//else {System.out.println(-1);
//}
System.out.println(ourList);
}

public static ArrayList<String> sortAscending() {         
    Collections.sort(ourList);         
    return ourList;     
  } 

//System.out.println(ourList);
	}

