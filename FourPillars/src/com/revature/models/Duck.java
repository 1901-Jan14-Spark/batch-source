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
}
