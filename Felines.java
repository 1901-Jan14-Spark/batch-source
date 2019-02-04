package com.fourPillars;

public class Felines extends Animals implements CatActions {
// Felines inherits methods defined in Animals but also uses actions specific to CatActions
	
	public Felines() {
		this.hasWings = false;
		this.hasFlippers = false;
		this.breathesOxygen = true;
		this.isBipedal = false;		
		this.canBark = false;
	}

	// below methods implemented from CatActions.java
	// Parakeet can implement these methods but it would not make sense in this context
	
	@Override
	// this is also encapsulation, the superclass does not know what the method isSleepingAllDay is a part of returnAll. It does not matter to the superclass.
	public void isSleepingAllDay() {
		System.out.println("I am sleeping all day");
		
	}

	@Override
	public void isAloof() {
		System.out.println("I am not aloof!");
		
	}

	@Override
	public void isGrooming() {
		System.out.println("I am not grooming myself because I am sleeping!");
		
	}
	
	public void returnAll() {
		// this conditional is an example of abstraction. the superclass, Animals, oes not know what canBark will return.
		if(canBark == false) {
			System.out.println("I cannot bark!");
		} else {
			System.out.println("I can bark!");
		}
		isSleepingAllDay();
		isAloof();
		isGrooming();
	}
	
	
}
