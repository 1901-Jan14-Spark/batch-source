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
}
