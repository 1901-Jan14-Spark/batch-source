package com.rev.sub;

import java.util.ArrayList;

public class Driver {
public static void main(String[] args) {
	ArrayList<String> arrList = new ArrayList<>();
	arrList.add("test");
	String i = arrList.get(0);
	
	Integer[] inArr = {1,2,3,4,5};
	printMe(inArr);
	
	Character[] chArr = {'d','s','f','w'};
	printMe(chArr);
	
	
	
	//can return something of type T withought knowning the type at compile time 
	public static <T> void  printMe(T[] arr){
		for(T item : arr) {
			System.out.println(item);
			}
		
		}
	
	public static <T extends Caluculatable > T calculateArg(T input) {
		System.out.println(input.);
	}
	
	}
}
