package com.revature.models;

public abstract class Bird extends Animal implements Flyable{
	
	protected int wings = 2;
	//Abstraction example in superclass
	public abstract void Soar();
	
	public Bird() {
		super();
		this.wings = 2;
		
	}
	public static void call() {
		System.out.println("Chrip");
	}

	public int getWings() {
		return wings;
	}
	public void setWings(int wings) {
		this.wings = wings;
	}

	@Override
	public void Fly() {
		System.out.println("Birds can soar throught the sky with " + wings + " Wings");
	}
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Bird br = (Bird) o;
		if(this.wings!= br.getWings()) {
			return false;
		}
		return true;
	}
	
}
