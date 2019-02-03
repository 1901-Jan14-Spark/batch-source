package weekC.assignment;

//Inheritance occurs in this class as it inherits the existence of the states species, voice, canSwim, and canFly.
//This class also inherits the methods to manipulate all states
public class HoneyBee extends Animal{
	public HoneyBee() {
		this.setSpecies("Honey bee");
		this.setVoice("Bzzzz");
		this.setCanFly(true);
	}
	
	public HoneyBee(String species, String voice) {
		this.setSpecies(species);
		this.setVoice(voice);
		this.setCanFly(true);
		this.setCanSwim(false);
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
		System.out.println("It can fly: " + this.isCanFly() + ".");
	}
}
