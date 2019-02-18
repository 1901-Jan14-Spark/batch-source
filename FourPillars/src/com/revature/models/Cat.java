package com.revature.models;

import java.io.FileNotFoundException;

import com.revature.exceptions.AgeSetValueException;

public class Cat extends Animals implements Comparable<Cat> {
	
	/*
	 * The extends keyword allows for the Cat class to inherit from Animals. This essentially
	 * allows the Cat class to adopt any states and behaviors of the superclass. Because Cat has inherited from Animals, Cat can not inherit any other states and behaviors from any other class. 
	 */
	
	@Override
	public String toString() {
		return "Cat [hasWhiskers=" + hasWhiskers + ", name=" + name + ", furColor=" + furColor + ", age=" + age
				+ ", lives=" + lives + "]";
	}

	private boolean hasWhiskers;

	private String name;
	private String furColor;
	private int age;
	private int lives;
	
	public Cat() {
	}

	//Creating a Cat constructor to accept some sort of configuration file we may use to initialize some default values/behaviors
	//for our cat. If it is found then it will successfully create our cat that way, if not it will be configured with default values
	// that we set via our exception that is caught. This is an example of a checked exception.
	public Cat(String catConfigFile) {
		if(catConfigFile.equals("catConfig.txt")) {
			System.out.println("Successfully creating the cat according to configuration specifications...");
		} else {
			try {
				getCatSpecs();
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("This file was not found, cat will be configured with default values: ");
			name = "Jax";
			furColor = "Black";
			age = 4;
			lives = 9;
		}	
		}
	}
	
	private void getCatSpecs() throws FileNotFoundException {
		//This would do some code if we had a file that had catspecs...
		throw new FileNotFoundException("Cannot find catConfig.txt");
		
	}

	public Cat(String name, String furColor, int age, int lives) {
		super();
		this.name = name;
		this.furColor = furColor;
		this.age = age;
		this.lives = lives;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void walk() {
		System.out.println("The cat is walking! Meeeeeeeow");
		
	}
	
	/*Below is an example of method overriding (polymorphism). The subclass Cat has inherited the method signature getNumLegs from the superclass
	 * Animals. However, the implementation of the method for the Cat class is different from the direct implementation
	 * of how the super class has implemented it. Thus making this a prime example of method overriding! */
	public int getNumLegs() {
		if (numLegs > 4) {
			System.out.println("Error! Cats cannot have more than 4 legs! Your cat has been set with the default value of legs which is 4.");
			return (numLegs = 4);
		} else {
			return numLegs;
	}
}
	
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	
	public boolean getHasLungs() {
		if (hasLungs == true) {
		System.out.println("Your cat has lungs!! Phew");
	} else {
		System.out.println("Ruh-roh. Doesn't look like your cat has lungs. :(");
	} 
		return hasLungs;
	}
	
	public boolean isHasWhiskers() {
		return hasWhiskers;
	}

	public void setHasWhiskers(boolean hasWhiskers) {
		this.hasWhiskers = hasWhiskers;
	}
	
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		
		Cat c = (Cat) o;
		if(c.hasLungs != this.hasLungs) {
			return false;
		}
		if (c.numHearts != this.numHearts) {
			return false;
		}
		if (c.numLegs != this.numLegs) {
			return false;
		}
		if (c.hasWhiskers != this.hasWhiskers) {
			return false;
		}
		return true;
	}
	
	public String makeNoise(String sound) {
		String s = "The cat says "+sound;
//		System.out.println(s);
		return s;
	}
	
	public static void run() {
//		System.out.println("The cat is running");
	}
	
	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public int getAge() {
		return age;
	}

	//Adding an exception to be thrown if the age set is below 0, which would be impossible.
	public void setAge(int age) {
		if (age < 0) {
			try {
				throw new AgeSetValueException("The age of the cat cannot be below 0, it would be unfortunately dead.");
			} catch (AgeSetValueException e) {
				e.printStackTrace();
				System.out.println("Please set the age to be greater than 0 if you wish for your cat object to exist.");
			}
		}
		this.age = age;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	@Override
	public int compareTo(Cat o) {
		return this.lives - o.lives;
		
	}
	


}

