package com.revature.models;

public class Animal {

	/* this is a basic example of encapsulation, using protected variables
	 * so that they can only be accessed by this class and all the subclasses
	 * of this Animal class, and any class within the package */
	protected int numOfLegs;
	protected boolean hasTail;	
	
	// this is the no-arguments constructor
	public Animal() {
		// a reference to the parent class, which would be the object class in this case
		super();
	}
	
	
	// this second Animal constructor, that now takes two arguments, is an example of method overloading in Polymorphism
	public Animal(int numOfLegs, boolean hasTail) {
		super();
		this.numOfLegs = numOfLegs;
		this.hasTail = hasTail;
	}
	
	// because the variables of this class are protected, they can only be accessed and changed through the get and set methods
	// this is another example of encapsulation
	public int getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}
	
	public boolean getHasTail() {
		return hasTail;
	}
	
	public void setHasTail (boolean hasTail){
		this.hasTail = hasTail;
		
	}
	

	//the most basic string method.  each subclass implements it's own version of this method through method overriding
	// another example of polymorphism
	public String toString() {
		return "Animal\n------\nNumber of Legs: " + numOfLegs + "\nHas Tail: " + hasTail;
	}
		
	
}
