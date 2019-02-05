package com.revature.models;

public class Seal extends Animal {
	//Inheritance: class derived from a superclass allowing access to their states and behaviors
	public Seal() {
		super(2, false);
	}
	//Abstraction/polymorphism: Implementation and overriding of the interface method
	public String talk() {
		return "Ow ow ow!";
	}
	
	public static void makeNoise() {
		System.out.println("Seal Noises");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Seal a = (Seal) o;
		if (a.getLegs() == this.getLegs() && a.isHasFur() == this.isHasFur()) {
			return true;
		}
		return false;
	}
}
