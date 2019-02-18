package com.revature.models;

public abstract class Animals implements Walkable {
	
	/* Using the keyword abstract in this class is utilizing the property of abstraction in OOP. This allows us to
	 * focus on functionality rather than implementation. The abstract class Animals serves as a template for 
	 * all Animal objects that we can create. We cannot instantiate any Animals objects, but we can instantiate any subclass that inherits from Animals.
	 */

	protected int numLegs;
	protected int numHearts;
	protected boolean hasLungs;
	
	public Animals() {
		super();
	}
	
	public Animals(int numLegs, int numHearts, boolean hasLungs) {
		this.numLegs = numLegs;
		this.numHearts = numHearts;
		this.hasLungs = hasLungs;
	}
	
	/* The following are examples of encapsulation. By using methods which are known as getters/setters, and changing the access modifiers on the 
	 * instance variables for Animals, we have encapsulated the protected variables to only be accessed by members of this package. By providing
	 * methods to access these variables, any class which inherits from Animals can set these variables to a different value, but cannot change the value directly.
	 * */
	public int getNumLegs() {
		return numLegs;
	}
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	public int getNumHearts() {
		return numHearts;
	}
	public void setNumHearts(int numHearts) {
		this.numHearts = numHearts;
	}
	public boolean getHasLungs() {
		return hasLungs;
	}
	public void setHasLungs(boolean hasLungs) {
		this.hasLungs = hasLungs;
	}
	
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Animals a = (Animals) o;
		if(a.hasLungs != this.hasLungs) {
			return false;
		}
		if (a.numHearts != this.numHearts) {
			return false;
		}
		if (a.numLegs != this.numLegs) {
			return false;
		}
		return true;
	}
	
	public String makeNoise(String sound) {
		String s = "The animal says "+sound;
		System.out.println(s);
		return s;
	}
	
	public static void run() {
//		System.out.println("The animal is running");
	}

}
