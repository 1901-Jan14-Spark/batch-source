package com.revature.types;

public class Driver {

	public static void main(String[] args) {
		
		// Boxing - converting a primitive int into an object Integer
		int num1 = 5;
		Integer num2 = new Integer(num1); //new Integer(5);
		
		// Unboxing
		Integer num3 = new Integer(3);
		int num4 = num3.intValue();
		
		// AutoBoxing - automatic version of boxing
		int num5 = 12;
		Integer num6 = num5;
		
		// AutoUnboxing
		Integer num7 = new Integer(7);
		int num8 = num7;
		
		Object[] objectArr = new Object[4];
		objectArr[0] = 5;
		objectArr[1] = 10;
		objectArr[2] = 12;
		objectArr[3] = false;

	}

}
