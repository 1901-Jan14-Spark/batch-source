package com.revature.models;


public class Animal implements Comparable<Animal>{

	/* this is a basic example of encapsulation, using protected variables
	 * so that they can only be accessed by this class and all the subclasses
	 * of this Animal class, and any class within the package */
	protected int numOfLegs;
	protected boolean hasTail;
	protected String name;
	
	// this is the no-arguments constructor
	public Animal() {
		// a reference to the parent class, which would be the object class in this case
		super();
	}
	
	
	// this second Animal constructor, that now takes two arguments, is an example of method overloading in Polymorphism
	public Animal(int numOfLegs, boolean hasTail, String name) {
		super();
		this.numOfLegs = numOfLegs;
		this.hasTail = hasTail;
		this.name = name;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	//the most basic string method.  each subclass implements it's own version of this method through method overriding
	// another example of polymorphism
	public String toString() {
		return "Animal\n------\nName: " + name + "\nNumber of Legs: " + numOfLegs + "\nHas Tail: " + hasTail;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasTail ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numOfLegs;
		return result;
	}


//	@Override
//	public boolean equals(Object o) {
//		if(o.getClass() != this.getClass()) {
//			return false;
//		}
//		Animal a = (Animal) o;
//		if(a.getNumOfLegs() != this.getNumOfLegs()) {
//			return false;
//		}
//		if(a.getHasTail() != this.getHasTail()) {
//			return false;
//		}
//		if(a.getName() != this.getName()) {
//			return false;
//		}
//		return true;		
//	}
	
	// override the previous equals method to implement the comparable interface 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (hasTail != other.hasTail)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numOfLegs != other.numOfLegs)
			return false;
		return true;
	}
	
	
	//this is a static method within a parent class
	public static void staticMethod() {
		System.out.println("This static method is from the parent (Animal) class.");
	}
	
	public void instanceMethod() {
		System.out.println("This is a non-static method in the parent (Animal) class.");
	}

	// implementation of the comparable interface using the compareTo method
	@Override
	public int compareTo(Animal a) {
		if(this.numOfLegs == a.numOfLegs) {
			return this.getName().compareTo(a.getName());
		}
		return this.numOfLegs - a.numOfLegs;
	}


}
