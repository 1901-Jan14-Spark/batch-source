package com.revature.models;

//Inheritance: class derived from a superclass allowing access to their states and behaviors
public class Fox extends Animal {

	public boolean hasEars;

	public Fox() {
		super(4, true);
		hasEars = true;
	}

	// Abstraction/polymorphism: Implementation and overriding of the interface
	// method
	public String talk() {
		return "Ring-ding-ding-ding-dingeringeding!\r\n" + "Gering-ding-ding-ding-dingeringeding!\r\n"
				+ "Gering-ding-ding-ding-dingeringeding!";
	}

	public static void makeNoise() {
		System.out.println("Fox Noises");
	}
	
	public boolean isHasEars() {
		return hasEars;
	}

	public void setHasEars(boolean hasEars) {
		this.hasEars = hasEars;
	}

	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Fox a = (Fox) o;
		if (a.getLegs() == this.getLegs() && a.isHasFur() == this.isHasFur() && a.isHasEars() == this.isHasEars()) {
			return true;
		}
		return false;
	}
}
