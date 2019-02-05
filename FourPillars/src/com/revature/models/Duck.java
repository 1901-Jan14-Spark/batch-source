package com.revature.models;

public class Duck extends Bird {
	//Inheritance: class derived from a superclass allowing access to their states and behaviors
	public Duck() {
		super();
	}
	//Abstraction/polymorphism: Implementation and overriding of the interface method
	public String talk() {
		return "Quack!";
	}
	
	public static void makeNoise() {
		System.out.println("Duck Noises");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Duck a = (Duck) o;
		if (a.getLegs() == this.getLegs() && a.isHasFur() == this.isHasFur()) {
			return true;
		}
		return false;
	}
}
