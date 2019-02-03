package weekC.assignment;

//Inheritance occurs in this class as it inherits the existence of the states species, voice, canSwim, and canFly.
//This class also inherits the methods to manipulate all states
public class Elephant extends Animal{
	public Elephant() {
		this.setSpecies("elephant");
		this.setVoice("trumpeting");
		this.setCanSwim(true);
	}
	
	public Elephant(String species, String voice) {
		this.setSpecies(species);
		this.setVoice(voice);
		this.setCanFly(false);
		this.setCanSwim(true);
	}
	
	@Override
	public String speak() {
		return this.getVoice();
	}
	
	//One form of polymorphism, method overriding, can be found here in the show method. When compared to the show method in the 
	//HoneyBee class the second line differs by only outputting the boolean value of the isCanSwim variable instead of the 
	//isCanFly variable. 
	public void show() {
	System.out.println("The " + this.getSpecies() + " says: " + this.speak() + ".");
	System.out.println("It can swim: " + this.isCanSwim() + ".");
	}
}
