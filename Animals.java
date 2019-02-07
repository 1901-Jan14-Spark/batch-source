package com.fourPillars;

class Animals {
	// these booleans can be accessed by any classes within FourPillars
	// they are not a part of any method
	// if they were private, this would be encapsulation and only available within this class
	public boolean hasWings;
	public boolean hasFlippers;
	public boolean breathesOxygen;
	public boolean isBipedal;
	public boolean canBark;
	
	public Animals() {
		super();
	}
	
	// downcasting and method overriding
	public static int animalType() {
		Animals a1 = new Felines();
		Felines f1 = (Felines) a1;
		System.out.println(f1.animalType());
		return 0;
	}
	
	public static void main(String[] args) {
		// this creates a new Feline, where only values within the subclass are printed out. Their boolean values are not used.
		Felines newKitty = new Felines();
		// this creates a new Parakeet, where only values within the subclass are printed out. Their boolean values are not used.
		Parakeet pPaulie = new Parakeet();
		newKitty.printAll();
		pPaulie.canBark();
		
		// calling the below to downcast and override
		animalType();
		
		Felines fel1 = new Felines();
		Felines fel2 = new Felines();
		System.out.println("Felines...using value: " + fel1.equals(fel2));
		
		Parakeet par1 = new Parakeet();
		Parakeet par2 = new Parakeet();
		System.out.println("Parakeet...using value: " + par1.equals(par2));		
	}
}
