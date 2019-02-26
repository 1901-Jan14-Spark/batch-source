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
	
	// this isn't considered to be method overriding as it's a static method 
	// instead it is "method hiding"
	public static void myStaticMethod() {
		System.out.println("static method from Car");
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model +", isMoving="+this.getIsMoving()+", numOfWheels="+this.getNumOfWheels()+"]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Car v = (Car) o;
		if(v.getIsMoving()!=this.getIsMoving()) {
			return false;
		}
		if(v.getNumOfWheels()!=this.getNumOfWheels()) {
			return false;
		}
		if(v.getMake()!=this.getMake()) {
			return false;
		}
		if(v.getModel()!=this.getModel()) {
			return false;
		}
		return true;
	}
	
	

}
