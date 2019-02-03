package com.FourPillars.Model;
//Inheritance example- class inherits from Superclass Animals
public class MantisShrimp extends Animals{
	Double punchSpeed;

	public MantisShrimp() {
		super();
	}

	public MantisShrimp(Double punchSpeed, int colorNum) {
		super();
		this.punchSpeed=punchSpeed;
		this.numOfColorRods=colorNum;
	}

	public Double getPunchSpeed() {
		return  punchSpeed;
	}

	public void setPunchSpeed(Double punchSpeed) {
		this.punchSpeed = punchSpeed;
	}
	// example of overriding since setNumberOfColorRods() implementation has changed
	public void setNumOfColorRods(int numOfColorRods){
		numOfColorRods=12;
	}

	public String toString() {
		return "MantisShrimp [punchSpeed=" + punchSpeed +", numOfLegs="+this.getNumOfLegs()+", numOfColorRods="+this.getNumOfColorRods()+"]";
	}
	public void isRideable() {
		
		System.out.println("A Mantis Shrimp is not rideable because it has "+ this.getNumOfLegs()+" and livesOnLand is " + this.isLivesOnLand());
	}

}
