package com.revature.giles;

public abstract class Animals implements livingOrganism {
	private boolean hasFur;
	private boolean hasLegs;
	
	public static void drinksWater() {
		System.out.println("Ahhhhhhh");
	}
	
	//equals
	public boolean equals (Object o) {
	Animals a1 = (Animals) o;
		if(o.getClass() != this.getClass()) {
			return false;
		}
		
		if(this.hasFur != a1.getHasFur()) {
			return false;
		}
		
		if(this.hasLegs != a1.getHasLegs()) {
			return false;
		}
		else return true;
	}
	
	
	public void makeNoise() {
		System.out.println("Makes Noise");
	}
	
	public void eats(String food) {
		System.out.println("Eats Something");
	}
	
	//Getter
	public boolean getHasLegs() {
		return hasLegs;
	}
	//setter for hasLegs
	public void setHasLegs(boolean hasLegs) {
		this.hasLegs = hasLegs;
		if (hasLegs == true) {
			System.out.println("I have legs!");
		}
	}
	
	//Getter for hasFur
	public boolean getHasFur() {
		return hasFur;
	//setter for hasFUR
	}
	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	
	public String toString() {
		return "Animal: hasLegs = "+hasLegs+", hasFur = "+hasFur;
	}
	
			
}




