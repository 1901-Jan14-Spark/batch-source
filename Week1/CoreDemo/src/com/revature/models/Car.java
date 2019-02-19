package com.revature.models;

import java.io.FileNotFoundException;
import java.io.Serializable;

import com.revature.exceptions.NegativeWheelValueException;

public class Car implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private int numOfWheels;
	private int speed;
	private String color;
	private boolean isTruck;
	
	public Car() {
		super();
	}
	
	public Car(String carConfigFile) {
		if(carConfigFile.equals("CarConfig.txt")) {
			System.out.println("successfully configured car");
		} else {
			try {
				// getCarInfo(); this method can throw FileNotFoundException
				throw new FileNotFoundException("Cannot find CarConfig.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				numOfWheels = 4;
				speed = 0;
				color = "Black";
				isTruck = false;
			}
		}
	}


	public Car(int numOfWheels, int speed, String color, boolean isTruck) {
		super();
		this.numOfWheels = numOfWheels;
		this.speed = speed;
		this.color = color;
		this.isTruck = isTruck;
	}


	public int getNumOfWheels() {
		return numOfWheels;
	}

	// we can surround any code with a try catch, but checked exceptions are the only things that will make us
	public void setNumOfWheels(int numOfWheels) {
		if(numOfWheels < 0) {
//			try {
				throw new NegativeWheelValueException("Car must have 0 or more wheels");

//			} catch (Exception e) {
//				this.numOfWheels = 0;
//			}
//		} else {
		}
			this.numOfWheels = numOfWheels;
//		}
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public boolean isTruck() {
		return isTruck;
	}


	public void setTruck(boolean isTruck) {
		this.isTruck = isTruck;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (isTruck ? 1231 : 1237);
		result = prime * result + numOfWheels;
		result = prime * result + speed;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (isTruck != other.isTruck)
			return false;
		if (numOfWheels != other.numOfWheels)
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Car [numOfWheels=" + numOfWheels + ", speed=" + speed + ", color=" + color + ", isTruck=" + isTruck
				+ "]";
	}
	
	
}
