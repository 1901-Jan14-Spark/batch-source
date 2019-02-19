package com.revature.models;

public class Elephant extends Animal {
	//Inheritance: class derived from a superclass allowing access to their states and behaviors
	public Elephant() {
		super(4, false);
	}
	//Abstraction/polymorphism: Implementation and overriding of the interface method
	public String talk() {
		return "Toot!";
	}
}
