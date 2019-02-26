package com.revature.models;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		Car c = new Car("Chevy","Silverado");
//		c.getNumOfWheels();
//		c.getIsMoving();
		c.setIsMoving(true);
		//System.out.println(c.toString());
		
		Boat b = new Boat(true);
		//b.setNumOfWheels(12);
		//b.numOfWheels = 12;
		//System.out.println(b.toString());

		
		Vehicle v1 = new Boat();
//		System.out.println(v1.toString());
		Vehicle v2 = new Car();
//		System.out.println(v2.toString());
		Vehicle v3 = new Vehicle();
//		System.out.println(v3.toString());
		
		Vehicle[] arr = new Vehicle[3];
		arr[0] = v1;
		arr[1] = v2;
		arr[2] = v3;
		
		/*
		for(Vehicle v: arr) {
			System.out.println(v.toString());
			System.out.println(v.getClass());
		}
		
		Boat b1 = (Boat) v1;
		b1.setHasSail(true);
		System.out.println(b1);
		
		Boat b2 = (Boat) v2;
		b2.setHasSail(true);
		System.out.println(b2);
		*/
		
		/*
		// invoking these methods will always execute the method from the associated class, we will not see virtual method invocation
		c.myStaticMethod();
		// equivalent to
		Car.myStaticMethod();
		
		v2.myStaticMethod();
		// equivalent to
		Vehicle.myStaticMethod();
		*/
		
		/*
		Vehicle veh1 = new Vehicle();
		System.out.println(veh1);
		Vehicle veh2 = new Vehicle();
		System.out.println(veh2);
		System.out.println("Using reference: "+(veh1==veh2));
		System.out.println("Using value: "+(veh1.equals(veh2)));
		*/
		
		Car car1 = new Car("Ford", "Mustang");
		Car car2 = new Car("Ford", "Mustang");
		System.out.println("Another Mustang:");
		System.out.println("Using reference: " + (car1==car2));
		System.out.println("Using value: " + (car1.equals(car2)));
		
		Vehicle veh1 = new Vehicle();
		System.out.println("A vehicle:");
		System.out.println("Using reference: " + (car1==veh1));
		System.out.println("Using value: " + (car1.equals(veh1)));
		
		Car car3 = new Car("Nissan", "Versa");
		System.out.println("A different type of car:");
		System.out.println("Using reference: " + (car1==car3));
		System.out.println("Using value: " + (car1.equals(car3)));
		
	}
	

}
