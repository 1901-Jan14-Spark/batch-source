package com.revature.models;

public class Mouse extends Animal {
	//Inheritance: class derived from a superclass allowing access to their states and behaviors
	public Mouse() {
		super(4, true);
	}
	//Abstraction/polymorphism: Implementation and overriding of the interface method
	public String talk() {
		return "Squeek!";
	}
	
	public static void makeNoise() {
		System.out.println("Mouse Noises");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Mouse a = (Mouse) o;
		if (a.getLegs() == this.getLegs() && a.isHasFur() == this.isHasFur()) {
			return true;
		}
		return false;
	}
}
