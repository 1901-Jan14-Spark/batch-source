package com.revature.models;

public class Car extends Vehicle {
	
	private String make;
	private String model;
	
	public Car() {
		super(4);
	}
	
	public Car(String make, String model) {
		super(4);
		this.make = make;
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model +", isMoving="+this.getIsMoving()+", numOfWheels="+this.getNumOfWheels()+"]";
	}
	
	

}
