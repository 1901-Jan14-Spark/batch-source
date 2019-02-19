package com.revature.models;

public abstract class Animal implements Predator{
	
	private int numOfLegs;
	
	public Animal() {
		super();
	}

	public int getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}
	
}
