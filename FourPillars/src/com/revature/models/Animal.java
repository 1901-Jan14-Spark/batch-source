package com.revature.models;

import com.revature.interfaces.Talkable;
// Abstraction: Animal super class implements interface and is abstracted to push the user to implement subclasses
public abstract class Animal implements Talkable {
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

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	
}
