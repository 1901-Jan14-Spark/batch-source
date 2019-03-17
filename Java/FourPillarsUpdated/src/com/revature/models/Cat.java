package com.revature.models;

//the Cat class is a subclass of the animal class
public class Cat extends Animal implements Runable{
	
	// encapsulation continued, only these variables are private and only within this class 
	private String breed;
	private boolean hasFur;
	private String domain;

	// this first construct allows us to set new values to the variables that were initialized in the parent class, the Animal class;
	public Cat() {
		// super(4, true);
		this.setNumOfLegs(4);
		this.setHasTail(true);
		this.setName("Random Cat");
	}
	
	// this second constructor takes three new arguments to create a new Cat object
	// this is another example of method overloading in Polymorphism
	public Cat(String breed, boolean hasFur, String domain) {
		super(4, true, "Random Cat");
		this.breed = breed;
		this.hasFur = hasFur;
		this.domain = domain;
	}
	
	
	// similar to the parent animal class, the values of the Cat variables can only be accessed through get and set methods
	// an example of encapsulation
	public String getBreed() {
		return breed;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public boolean getHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	
	public String getDomainStatus() {
		return domain;
	}
	
	public void setDomainStatus(String domain) {
		this.domain = domain;
	}


	// an example of method overriding in Polymorphism, this version will retrun a different string than the version in the Cat class
	public String toString() {
		return "Cat\n---\nName: " + name + "\nNumber of Legs: " + numOfLegs + "\nHas Tail: " + hasTail + "\nDomain: " + domain + " Cat \nBreed: " + breed + "\nFur: " + hasFur;
	}

	// each class implements its own version of the run method
	
	public String run() {
		return "This cat is running..";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Cat c = (Cat) o;
		if(c.getNumOfLegs() != this.getNumOfLegs()) {
			return false;
		}
		if(c.getHasTail() != this.getHasTail()) {
			return false;
		}
		if(c.getName() != this.getName()){
			return false;
		}
		if(c.getBreed() != this.getBreed()) {
			return false;
		}
		if(c.getHasFur() != this.getHasFur()) {
			return false;
		}
		if(c.getDomainStatus() != this.getDomainStatus()) {
			return false;
		}
		return true;	
	}
	
}
