package weekC.assignment;

//Encapsulation is demonstrated on this page because the only way any other class can access or manipulate the variables in
//this class is to use the getter and setter methods created below.
public abstract class Animal implements Comunicate{
	private String species;
	private String voice;
	private boolean canFly;
	private boolean canSwim;
	
	//One form of polymorphism occurs here through method overloading, where the constructors contain the same method
	//signatures but depending on the number of arguments passed the constructors will manipulate different variables. 
	//Other forms of polymorphism can be seen in the Elephant and HoneyBee classes.
	public Animal() {
		
	}
	
	public Animal(String species, String voice) {
		this.species = species;
		this.voice = voice;
	}
	
	public Animal(String species, String voice, boolean canSwim, boolean canFly) {
		this.species = species;
		this.voice = voice;
		this.canSwim = canSwim;
		this.canFly = canFly;
	}

	//Abstraction is also demonstrated here because the Animal class leaves the show method to be implemented by its subclass.
	public abstract void show();
	
	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	public boolean isCanSwim() {
		return canSwim;
	}

	public void setCanSwim(boolean canSwim) {
		this.canSwim = canSwim;
	}
}
