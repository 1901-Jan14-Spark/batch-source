package com.revature.models;

public class Animal {
	protected String type = "omnivore";
	private int legs = 0;
	
	public Animal() {
		super();
	}
	public String call() {
		return "Animal";
	}
	public int legs() {
		return legs;
	}
	//Encapsulation through getters and setters
	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		this.legs = legs;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
		
}
