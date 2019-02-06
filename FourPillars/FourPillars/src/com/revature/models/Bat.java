package com.revature.models;

public class Bat extends Animal implements Flyable{
	private int wings = 2;
	public Bat() {
		super();
		this.setLegs(2);
		
	}
	
	public int getWings() {
		return wings;
	}


	public void setWings(int wings) {
		this.wings = wings;
	}

	@Override
	public void Fly() {
		System.out.println("A Bat is the only mammal with sustained flight and has " + wings + " Wings and " + getLegs() + " Legs");
	}
	public static void call() {
		System.out.println("Screeeh");
	}
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Bat b = (Bat) o;
		if(this.wings!=b.getWings()) {
			return false;
		}
		return true;
	}

}
