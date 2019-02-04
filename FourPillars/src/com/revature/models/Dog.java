package com.revature.models;

public class Dog extends Animal{
	private boolean isHappy = false;
	public Dog() {
		super();
		this.setLegs(4);
	}
	//Constructor Overloading
	public Dog(boolean isHappy) {
		super();
		this.setLegs(4);
		this.setHappy(isHappy);
	}
	public String call() {
		return "Woof";
	}
	//Polymorphism Overloading example
	public String call(boolean isAgitated) {
		if(isAgitated == true) {
			return "Growl";
		}
		else {
			return "Lick";
		}
	}
	public boolean isHappy() {
		return isHappy;
	}
	public void setHappy(boolean isHappy) {
		this.isHappy = isHappy;
	}
	
}
