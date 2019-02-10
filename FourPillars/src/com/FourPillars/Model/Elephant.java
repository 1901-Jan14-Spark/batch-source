package com.FourPillars.Model;

import java.util.Comparator;

//Inheritance example- class inherits from Superclass Animals
public class Elephant extends Animals, implements Comparator<Elephant>{
boolean hasTusks;
private String color;
public Elephant() {
	super();
}

public Elephant(boolean hasTusks) {
	super();
	this.hasTusks=hasTusks;
}
public Elephant(int numOfLegs, String color) {
	super();
	this.numOfLegs=numOfLegs;
	this.color=color;
}
public String getColor() {
	return color;
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
//method was hidden instead of overriden because it was  static
public static void giveTreats() {
	int moreTreats=treats+10;
}
//Equals method
@Override
public boolean equals(Object o) {
	if(o.getClass()!=this.getClass()) {
		return false;
	}
	Elephant v = (Elephant) o;
	if(v.getNumOfLegs()!=this.getNumOfLegs()) {
		return false;
	}
	return true;
}
Animals tantor= new Elephant();
// method for virtual method invocation
public void findHabitat() {
	System.out.println("Savanna");
}
}

