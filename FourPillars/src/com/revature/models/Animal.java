package com.revature.models;
import java.io.FileNotFoundException;

import com.revature.exceptions.NotValidAnimalTypeException;
import com.revature.exceptions.NumberOfFeetNotValidException;
public class Animal implements Comparable<Animal> {
	protected String type = "omnivore";
	protected int legs = 0;
	
	public Animal() {
		super();
	}
	//Example of Checked exception 
	public Animal(String animalBehaviorsFile) {
		if(animalBehaviorsFile.contentEquals("AnimalBehaviors.txt")) {
			System.out.println("Animal Behaviors where accessed");
		}
		else {
			try {
				throw new FileNotFoundException("Animal Behaviors from AnimalBehaviors.txt was not found");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				this.legs = 2;
			}
		}
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
	//Example of Unchecked exception for negative legs
	public void setLegs(int legs) {
		if(legs < 0) {
			throw new NumberOfFeetNotValidException("Animals need 0 or more feet");
		}
		else {
		this.legs = legs;
		}
	}
	//second example of checked exception
	public void setType(String type) {
		if(type != "omnivore" || type != "herbivore"|| type !="carnivore") {
			throw new NotValidAnimalTypeException("this is not a proper type of animal");
		}
		else {
			this.type = type;
		}
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
