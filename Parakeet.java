package com.fourPillars;

public class Parakeet extends Animals {
// this class inherits properties from animals but not implementing anything from Felines.java
	
	public Parakeet() {
		this.hasWings = true;
		this.hasFlippers = false;
		this.breathesOxygen = true;
		this.isBipedal = false;		
		this.canBark = false;
	}
	
	// the below overrides .equals() to see if a new Parakeet (default), is the same as another Parakeet.
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Animals a = (Parakeet) o;
		if(a.hasWings != this.hasWings) {
			return false;
		}
		if(a.hasFlippers != this.hasFlippers) {
			return false;
		}
		if(a.breathesOxygen != this.breathesOxygen) {
			return false;
		}
		if(a.isBipedal != this.isBipedal) {
			return false;
		}
		if(a.canBark != this.canBark) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// this class only prints out the below
	public void canBark() {
		System.out.println("I cannot bark, I can only chirp!");
	}
	
}
