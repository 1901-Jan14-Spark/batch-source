package com.revature.models;

public class Cow extends Animal {
	//Inheritance: class derived from a superclass allowing access to their states and behaviors
	public Cow() {
		super(4, true);
	}
	//Abstraction/polymorphism: Implementation and overriding of the interface method
	public String talk() {
		return "Moo!";
	}
}
