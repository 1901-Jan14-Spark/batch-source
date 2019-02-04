package com.fourPillars;

public class Parakeet extends Animals {
// this class inherits properties from animals but not implementing anything from Felines.java
	
	public Parakeet() {
		this.hasWings = false;
		this.hasFlippers = false;
		this.breathesOxygen = true;
		this.isBipedal = false;		
		this.canBark = false;
	}
	
	public void canBark() {
		System.out.print("I cannot bark, I can only chirp!");
	}
	
}
