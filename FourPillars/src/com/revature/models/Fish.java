package com.revature.models;

public class Fish extends Animal {
	//Inheritance: class derived from a superclass allowing access to their states and behaviors
	public Fish() {
		super(0, false);
	}
	//Abstraction/polymorphism: Implementation and overriding of the interface method
	public String talk() {
		return "Blub!";
	}
	
	public static void makeNoise() {
		System.out.println("Fish Noises");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Fish a = (Fish) o;
		if (a.getLegs() == this.getLegs() && a.isHasFur() == this.isHasFur()) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Fish [legs=" + legs + ", hasFur=" + hasFur + "]";
	}
}
