package com.revature.models;

//Inheritance example
public class Eagle extends Bird{
	public Eagle() {
		super();
	}
	//Abstraction and Overriding Polymorphism
	@Override
	public void Soar() {
		System.out.println("Eagle will Soar high than all other Animals");
	}

	@Override
	public void Fly() {
		System.out.println("Eagles will Fly for great lengths to hunt on " + this.wings + " Wings and " + this.legs() + " Legs");
	}
	public String call() {
		return "Screee";
	}
	
	
	
}
