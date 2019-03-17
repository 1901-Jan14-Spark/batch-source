package com.revature.models;


// the Monkey class is a subclass of the Animal class, which is an example of inheritance
public class Monkey extends Animal implements Swingable {
	
	private String breed;
	
	
	public Monkey() {
		// using the set methods in this instance give us the ability to change the variables that were established in the parent (Animal) class
		this.setNumOfLegs(4);
		this.setHasTail(true);
		this.setName("Random Monkey");
	}
	
	public Monkey(String breed) {
		super(4, true,"George");
		this.breed = breed;
	}

	// the Monkey class implements the Swingable interface, which extends the Runable interface
	// this example of inheritance is why the Monkey class has access to both the run and swing methods
	
	
	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	// an example of method overriding in Polymorphism, this version will retrun a different string than the version in the Cat class
	public String toString() {
		return "Monkey\n------\nName: " + name + "\nBreed: " + breed + "\nNumber of Legs: " + numOfLegs + "\nHas Tail: " + hasTail;
	}

	
	// each class implements its own version of the run method
	//this is an example of method overriding in Polymorphism;
	public String run() {	
		return "This " + breed + " is currently running throught the jungle...";
	}

	// only the Monkey class can swing
	public String swing() {
		return "This " + breed + " is currently swinging through the trees..";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Monkey m = (Monkey) o;
		if(m.getNumOfLegs() != this.getNumOfLegs()) {
			return false;
		}
		if(m.getHasTail() != this.getHasTail()) {
			return false;
		}
		if(m.getName() != this.getName()) {
			return false;
		}
		if(m.getBreed() != this.getBreed()) {
			return false;
		}
		return true;		
	}
	
	// this is a static method within a subclass
	public static void staticMethod() {
		System.out.println("This static method is from a child (Monkey) class");
	}
	
	public void instanceMethod() {
		System.out.println("This is a non-static method in the child (Monkey) class.");
	}
}
