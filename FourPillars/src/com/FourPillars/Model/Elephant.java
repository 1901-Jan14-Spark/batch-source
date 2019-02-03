package com.FourPillars.Model;
//Inheritance example- class inherits from Superclass Animals
public class Elephant extends Animals{
boolean hasTusks;

public Elephant() {
	super();
}

public Elephant(boolean hasTusks) {
	super();
	this.hasTusks=hasTusks;
}

public boolean isHasTusks() {
	return hasTusks;
}

public void setHasTusks(boolean hasTusks) {
	this.hasTusks = hasTusks;
}

public String toString() {
	return "Elephant [hasTusks=" + hasTusks +", numOfLegs="+this.getNumOfLegs()+", numOfColorRods="+this.getNumOfColorRods()+"]";
}


public void isRideable() {
	
	System.out.println("An Elephant is rideable because it has "+ this.getNumOfLegs()+" and livesOnLand is " + this.isLivesOnLand());
}


}
