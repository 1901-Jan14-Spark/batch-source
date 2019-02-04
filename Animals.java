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
	
	public boolean getHasWings() {
		return hasWings;
	}
	
	public boolean getHasFlippers() {
		return hasFlippers;
	}
	
	public boolean GetBreathesOxygen() {
		return breathesOxygen;
	}
	
	public boolean getIsBipedal() {
		return isBipedal;
	}
	
	public boolean getCanBark() {
		return canBark;
	}
	
	public void setHasWings(boolean wings) {
		this.hasWings = wings;
	}
	
	public void setHasFlippers(boolean flippers) {
		this.hasFlippers = flippers;
	}
	
	public void setBreathesOxygen(boolean oxygen) {
		this.breathesOxygen = oxygen;
	}
	
	public void setIsBipedal(boolean bipedal) {
		this.isBipedal = bipedal;
	}
	
	public void setCanBark(boolean bark) {
		this.canBark = bark;
	}
	
	public static void main(String[] args) {
		// this creates a new Feline, where only values within the subclass are printed out. Their boolean values are not used.
		Felines newKitty = new Felines();
		// this creates a new Parakeet, where only values within the subclass are printed out. Their boolean values are not used.
		Parakeet pPaulie = new Parakeet();
		newKitty.returnAll();
		pPaulie.canBark();
		// if I were to have a new Felines or Parakeet constructor, I could change their inherit values. That would be polymorphism. However, their values are static for now. I would need to change the values here.
	}
	
}
