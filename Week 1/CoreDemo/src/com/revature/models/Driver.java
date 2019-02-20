package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		Car c = new Car();
//		c.setNumOfWheels(-20);
//		System.out.println("set my num of wheels");
//		Car c2 = new Car("CarSpecs.txt");
//		System.out.println(c2);
		
		int a = 3;
		int b = 0;
//		System.out.println(a/b);
		
		Car c3 = null;
//		System.out.println(c3.equals(c));
		
		int[] arr = new int[] {2,4};
		for(int i = 0; i<100; i++) {
			try {
				System.out.println(arr[i]);				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("please dont do this");
			}
		}
		
		
		

	}

}
