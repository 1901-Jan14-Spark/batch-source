package com.revature.models;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		Car c = new Car("Chevy","Silverado");
//		c.getNumOfWheels();
//		c.getIsMoving();
		c.setIsMoving(true);
		System.out.println(c.toString());
		
		Boat b = new Boat(true);
		//b.setNumOfWheels(12);
		//b.numOfWheels = 12;
		System.out.println(b.toString());
		
	}
	

}
