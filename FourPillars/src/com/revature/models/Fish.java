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
}
