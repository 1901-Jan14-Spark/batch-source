package com.revature.models;

// the use of the "extends" keyword denotes that this Sphynx class is a subclass of the Cat class
public class Sphynx extends Cat {
	
	
	//this constructor is a reference to the parent constructor in the Cat class that takes 3 arguments
	public Sphynx() {
		super("Ugly", false, "House");
	}
	
	/* the Sphynx class has access to this run method because it is a child of the Cat class, 
	 * which implements the Runable interface.  another example of inheritance.
	*/
	// each class implements its own version of the run method
	//this is an example of method overriding in Polymorphism
	public String run() {
		return "The Sphynx is currently running through the yard..";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Sphynx s = (Sphynx) o;
		if(s.getNumOfLegs() != this.getNumOfLegs()) {
			return false;
		}
		if(s.getHasTail() != this.getHasTail()) {
			return false;
		}
		return true;
		
	}

}
