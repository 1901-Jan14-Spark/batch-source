package com.revature.models;

public class Dog extends Animal {
	//Inheritance: class derived from a superclass allowing access to their states and behaviors
	public Dog() {
		super(4, true);
	}
	//Abstraction/polymorphism: Implementation and overriding of the interface method
	public String talk() {
		return "Woof!";
	}
	public static void makeNoise() {
		System.out.println("Dog Noises");
	}
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Dog a = (Dog) o;
		if (a.getLegs() == this.getLegs() && a.isHasFur() == this.isHasFur()) {
			return true;
		}
		return false;
	}
}
