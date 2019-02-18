package com.revature.models;

import com.revature.exceptions.NumLegsException;
import com.revature.interfaces.Talkable;
// Abstraction: Animal super class implements interface and is abstracted to push the user to implement subclasses
public abstract class Animal implements Talkable, Comparable<Animal> {
	// Inheritance/Encapsulation: protected states to allow direct access to subclasses 
	protected int legs;
	protected boolean hasFur;
	//Polymorphism: overloaded constructors 
	protected Animal() {
	}
	
	protected Animal(int legs, boolean hasFur) {
		this.legs = legs;
		this.hasFur = hasFur;
	}

	//Polymorphism: method to be overriden by subclasses
	public String talk() {
		return "Animal sound!";
	}
	
	public int getLegs() {
		return legs;
	}

	//throws unchecked exception if the number of legs is less than 0
	public void setLegs(int legs) {
		if(legs < 0) {
			throw new NumLegsException("Invalid number of legs");
		}
		this.legs = legs;
	}

	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	
	// Declare static method for method hiding
	public static void makeNoise() {
		System.out.println("Animal Noises");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Animal a = (Animal) o;
		if (a.getLegs() == this.getLegs() && a.isHasFur() == this.isHasFur()) {
			return true;
		}
		return false;
	}
	
	// compareTo Implementation
	public int compareTo(Animal o) {
		return this.getLegs() - o.getLegs();
	}

	@Override
	public String toString() {
		return "Animal [legs=" + legs + ", hasFur=" + hasFur + "]";
	}
}
