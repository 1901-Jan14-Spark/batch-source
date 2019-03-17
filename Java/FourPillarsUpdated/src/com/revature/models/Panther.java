package com.revature.models;

// the extends keyword denotes that the Panther class is a subclass of the Cat class
// through inheritance, a Panther object would contain all the same variables and methods of the parent Cat class
public class Panther extends Cat{
	
	//this constructor is a reference to the parent constructor in the Cat class that takes 3 arguments
	public Panther() {
		super("Panther", true, "Jungle");
	}
	
	/* the Panther class has access to this run method because it is a child of the Cat class, 
	 * which implements the Runable interface.  another example of inheritance.
	*/
	// each class implements its own version of the run method
	//this is an example of method overriding in Polymorphism
	public String run() {
		return "The Black Panther is currently running through the jungle..";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Panther p = (Panther) o;
		if(p.getNumOfLegs() != this.getNumOfLegs()) {
			return false;
		}
		if(p.getHasTail() != this.getHasTail()) {
			return false;
		}
		return true;	
	}

}
