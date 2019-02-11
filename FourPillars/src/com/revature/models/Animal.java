package com.revature.models;

public class Animal implements Comparable<Animal> {
	protected String type = "omnivore";
	protected int legs = 0;
	
	public Animal() {
		super();
	}
	public Animal(int legs) {
		this.legs = legs;
	}
	public String call() {
		return "Animal";
	}
	public int legs() {
		return legs;
	}
	//Encapsulation through getters and setters
	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		this.legs = legs;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	@Override
	public int compareTo(Animal o) {
		// TODO Auto-generated method stub
		if(this.legs == o.legs) {
			return this.getType().compareTo(o.getType());
		}
		return this.legs - o.legs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + legs;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Animal other = (Animal) obj;
		if (legs != other.legs)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
		
}
