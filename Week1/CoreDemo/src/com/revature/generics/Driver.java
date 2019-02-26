package com.revature.generics;

import java.util.ArrayList;
import java.util.Comparator;

import com.revature.models.Car;
import com.revature.shapes.Calculatable;
import com.revature.shapes.Rectangle;

public class Driver {

	public static void main(String[] args) {
		
		ArrayList<String> arrList = new ArrayList<>();
		arrList.add("test");
		String i = arrList.get(0);
		
		Integer[] intArr = {1,2,4,6,8};
//		printMe(intArr);
		
		Character[] chArr = {'h','e','l','l','o'};
//		printMe(chArr);
		
		Rectangle r = new Rectangle(4,5);
		Car c = new Car();
//		calculateArg(c);
//		calculateArg(r);
		
		Rectangle r2 = new Rectangle(3,7);
		LargerShapeComparator comp = new LargerShapeComparator();
		(comp.compare(r, r2)).draw();
		
		//I created a LargerShapeComparator in a new file, but I can do it inline with a lambda using arrow notation
		// () -> {} 
		MyComparator<Rectangle> comp2 = (Rectangle rect1, Rectangle rect2) -> {
			Rectangle largerRectangle = (rect1.calculateArea()>rect2.calculateArea())?rect1:rect2;
			return largerRectangle;
		};
		
		(comp2.compare(r, r2)).draw();

	}
	
//	public static void printMe(Integer[] arr) {
//		for(Integer i: arr) {
//			System.out.println(i);
//		}
//	}
//	
//	public static void printMe(Character[] arr) {
//		for(Character c: arr) {
//			System.out.println(c);
//		}
//	}

	
	// can return something of type T without knowing the type at compile time
	public static <T> void printMe(T[] arr){
		for(T item : arr) {
			System.out.println(item);
		}
	}
	
	public static <T extends Calculatable> T calculateArg(T input) {
		System.out.println("This object is a "+input.getClass()+" with the perimeter of: "+input.calculatePerimeter()+" and the area of "+input.calculateArea());
		return input;
	}
	
}
