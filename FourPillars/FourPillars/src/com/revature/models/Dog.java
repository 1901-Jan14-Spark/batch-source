package com.revature.models;

public class Dog extends Animal{
	private boolean isHappy = false;
	public Dog() {
		super();
		this.type = "carnivore";
	}
	//Constructor Overloading
	public Dog(boolean isHappy) {
		super();
		this.setLegs(4);
		this.setHappy(isHappy);
	}
	public static void call() {
		System.out.println("Woof");
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
	public String getType(){
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Dog d = (Dog) o;
		if(this.type!= d.getType()){
			return false;
		}
		return true;
	}
}
