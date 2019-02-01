package com.revature.models;

public class Boat extends Vehicle {
	
	private boolean hasSail;
	
	public Boat() {
		super(0);
	}
	
	public Boat(boolean hasSail) {
		super(0);
		this.hasSail = hasSail;
	}

	public boolean isHasSail() {
		return hasSail;
	}

	public void setHasSail(boolean hasSail) {
		this.hasSail = hasSail;
	}

	@Override
	public String toString() {
		return "Boat [hasSail=" + hasSail +", isMoving="+this.getIsMoving()+", numOfWheels="+this.getNumOfWheels()+"]";
	}
	

}
