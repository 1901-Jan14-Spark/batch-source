package com.FourPillars.Model;
//Inheritance example- class inherits from Superclass Animals
public class Horse extends Animals{
	String Breed;

	public Horse() {
		super();
	}

	public Horse(String Breed) {
		super();
		this.Breed=Breed;
	}

	public String getBreed() {
		return Breed;
	}

	public void setBreed(String Breed) {
		this.Breed = Breed;
	}

	public String toString() {
		return "Horse [Breed=" + Breed +", numOfLegs="+this.getNumOfLegs()+", numOfColorRods="+this.getNumOfColorRods()+"]";
	}
	public void isRideable() {
		
		System.out.println("A horse is rideable because it has "+ this.getNumOfLegs()+" and livesOnLand is " + this.isLivesOnLand());
	}
	//method was hidden instead of overriden because it was  static
	public static void giveTreats() {
		int moreTreats=treats+5;
	}
}

