package com.revature.models;

public abstract class Bird extends Animal implements Flyable{
	
	protected int wings = 2;
	//Abstraction example in superclass
	public abstract void Soar();
	
	public Bird() {
		super();
		this.setLegs(2);
	}
	public String call() {
		return "Chirp";
	}
	
	public int wings() {
		return wings;
	}

	public int getWings() {
		return wings;
	}
	public void setWings(int wings) {
		this.wings = wings;
	}

	@Override
	public void Fly() {
		System.out.println("Birds can soar throught the sky with " + wings() + " Wings");
	}
	
	
}
