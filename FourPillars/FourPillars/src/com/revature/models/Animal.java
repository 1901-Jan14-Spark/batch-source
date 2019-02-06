package com.revature.models;

public class Animal {
	protected String type = "omnivore";
	
	private int legs = 0;
	public Animal() {
		super();
		this.legs = 4;
		this.type = "omnivore";
	}
	public static void call() {
		System.out.println("Animal");
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
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Animal a = (Animal) o;
		if(this.legs!= a.getLegs()) {
			return false;
		}
		if(this.type!=a.getType()) {
			return false;
		}
		return true;
	}
}
