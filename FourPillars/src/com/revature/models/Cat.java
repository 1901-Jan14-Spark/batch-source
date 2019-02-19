package com.revature.models;

public class Cat extends Animal {
	//Inheritance: class derived from a superclass allowing access to their states and behaviors
	public Cat() {
		super(4, false);
	}
	//Abstraction/polymorphism: Implementation and overriding of the interface method
	public String talk() {
		return "Meow!";
	}
	
	public static void makeNoise() {
		System.out.println("Cat Noises");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Cat a = (Cat) o;
		if (a.getLegs() == this.getLegs() && a.isHasFur() == this.isHasFur()) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Cat [legs=" + legs + ", hasFur=" + hasFur + "]";
	}
}
