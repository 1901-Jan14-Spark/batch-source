package weekC.assignment;

import java.io.FileNotFoundException;

import exceptions.CantFlyException;

//Inheritance occurs in this class as it inherits the existence of the states species, voice, canSwim, and canFly.
//This class also inherits the methods to manipulate all states
public class HoneyBee extends Elephant{
	private boolean canFly;
	
	public HoneyBee() {
		this.setSpecies("Honey bee");
		this.setVoice("Bzzzz");
		this.canFly = true;
	}
	
	public HoneyBee(String species, String voice) {
		this.setSpecies(species);
		this.setVoice(voice);
		this.canFly = true;
	}
	
	//Example of checked(compile time) exception if the standin file 'beeFile.txt' does not exist (or has been passed in as an
	//argument) then the exception handler should output the stack trace and set up a default bee.
	public HoneyBee(String honeyBeeFile) {
		if(honeyBeeFile.equals("beeFile.txt")) {
			System.out.println("Bee file found.");
		}
		else {
			try {
				throw new FileNotFoundException("beeFile.txt not found. \nDefault bee created");
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
				this.setSpecies("Honey Bee");
				this.setVoice("Buzz Buzz");
				this.canFly = true;
			}
		}
	}
	
	//example of unchecked exception should the boolean value of 'canFly' ever be changed to false then the change will be 
	//treated as an exception. 
	public void setCanFly(boolean input) {
		if(input == false) {
			throw new CantFlyException("Honey bees need to fly.");
		}
		this.canFly = input;
	}
	
	//this method is hidden by the 'panic' method in the 'Elephant' class.
	public static String panic() {
		return "Sting!";
	}
	
	@Override
	public String speak() {
		return this.getVoice();
	}

	//One form of polymorphism, method overriding, can be found in this show method. When compared to the show method in the 
	//Elephant class the second line differs by outputting the boolean state of the isCanFly variable instead of the 
	//isCanSwim variable.
	@Override
	public void show() {
		System.out.println("The " + this.getSpecies() + " says: " + this.speak() + ".");
		System.out.println("It can fly: " + this.canFly + ".");
	}
	
	//Here's the overridden equals method
	@Override
	public boolean equals(Object o) {
		if(o.getClass() == this.getClass()) {
			HoneyBee b = (HoneyBee) o;
			if(b.getSpecies() == this.getSpecies()) {
				if(b.canFly == this.canFly) {
					return true;
				}
			}
		}
		return false;
	}
}
