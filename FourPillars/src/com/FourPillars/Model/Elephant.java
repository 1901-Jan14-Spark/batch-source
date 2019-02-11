package com.FourPillars.Model;

import java.util.Comparator;

//Inheritance example- class inherits from Superclass Animals
public class Elephant extends Animals implements Comparable<Elephant>{
boolean hasTusks;
private String color;
public Elephant() {
	super();
}
// comparable
@Override
public int compareTo(Elephant o) {
	if(this.numOfLegs == o.numOfLegs) {
		return this.getColor().compareTo(o.getColor());
	}
	return this.numOfLegs - o.numOfLegs;
}
// hascode
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((color == null) ? 0 : color.hashCode());
	result = prime * result + numOfLegs;
	return result;
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

