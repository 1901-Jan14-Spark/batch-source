package com.FourPillars.Model;
//this class is an example of Abstraction
public abstract class Animals implements Rideable{
protected String habitat;
protected int numOfColorRods;
protected int numOfLegs;
private boolean livesOnLand;
private boolean oftenInWater;
public static int treats;

public Animals() {
	super();
}

public Animals(boolean oftenInWater, boolean livesOnLand) {
	super();
	this.oftenInWater=oftenInWater;
	this.livesOnLand=livesOnLand;
}
// constructor is overloaded because the parameters for Animals() has changed
public Animals(int numOfColorRods, int numofLegs) {
	super();
	this.numOfColorRods=numOfColorRods;
	this.numOfLegs=numOfLegs;
}

public int getNumOfColorRods() {
	return numOfColorRods;
}

public void setNumOfColorRods(int numOfColorRods) {
	this.numOfColorRods = numOfColorRods;
}

public int getNumOfLegs() {
	return numOfLegs;
}

public void setNumOfLegs(int numOfLegs) {
	this.numOfLegs = numOfLegs;
}
//getters and setters are an example of Encapsulation.
public boolean isLivesOnLand() {
	return livesOnLand;
}

public void setLivesOnLand(boolean livesOnLand) {
	this.livesOnLand = livesOnLand;
}

public boolean isOftenInWater() {
	return oftenInWater;
}

public void setOftenInWater(boolean oftenInWater) {
	this.oftenInWater = oftenInWater;
}

public String toString() {
	return "Vehicle: numOfLegs="+numOfLegs+", numOfColorRods="+numOfColorRods;
}
//method will be hidden
public static void giveTreats() {
	int moreTreats=treats+1;
}
//method for virtual method invocation
public void findHabitat() {
	System.out.println("Anywhere");
}

}
