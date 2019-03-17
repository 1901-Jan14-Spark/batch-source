package com.revature.models;

// when a interface inherites from another interface, the "extends" keyword is used
// this is the same as when a class inherits from a superclass
public interface Swingable extends Runable{
	
	// all methods created in interfaces and implicitly abstract;
	// because abstraction focuses on functionalty rather than implementation, the method is not required to be defined
	public String swing();
	

}
