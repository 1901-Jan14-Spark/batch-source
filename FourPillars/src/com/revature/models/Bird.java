package com.revature.models;

public class Bird extends Animal {
	//Inheritance: class derived from a superclass allowing access to their states and behaviors
	public Bird() {
		super(2, false);
	}
	//Abstraction/polymorphism: Implementation and overriding of the interface method
	public String talk() {
		return "Tweet!";
	}
	public static void makeNoise() {
		System.out.println("Bird Noises");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Bird a = (Bird) o;
		if (a.getLegs() == this.getLegs() && a.isHasFur() == this.isHasFur()) {
			return true;
		}
		return false;
	}
}
