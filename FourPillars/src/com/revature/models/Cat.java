package com.revature.models;

public class Cat extends Animals {
	
	/*
	 * The extends keyword allows for the Cat class to inherit from Animals. This essentially
	 * allows the Cat class to adopt any states and behaviors of the superclass. Because Cat has inherited from Animals, Cat can not inherit any other states and behaviors from any other class. 
	 */
	
	private boolean hasWhiskers;
	
	public Cat() {
	}

	@Override
	public void walk() {
		System.out.println("The cat is walking! Meeeeeeeow");
		
	}
	
	/*Below is an example of method overriding (polymorphism). The subclass Cat has inherited the method signature getNumLegs from the superclass
	 * Animals. However, the implementation of the method for the Cat class is different from the direct implementation
	 * of how the super class has implemented it. Thus making this a prime example of method overriding! */
	public int getNumLegs() {
		if (numLegs > 4) {
			System.out.println("Error! Cats cannot have more than 4 legs! Your cat has been set with the default value of legs which is 4.");
			return (numLegs = 4);
		} else {
			return numLegs;
	}
}
	
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	
	public boolean getHasLungs() {
		if (hasLungs == true) {
		System.out.println("Your cat has lungs!! Phew");
	} else {
		System.out.println("Ruh-roh. Doesn't look like your cat has lungs. :(");
	} 
		return hasLungs;
	}
	
	public boolean isHasWhiskers() {
		return hasWhiskers;
	}

	public void setHasWhiskers(boolean hasWhiskers) {
		this.hasWhiskers = hasWhiskers;
	}
	
	


}

