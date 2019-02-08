package weekC.assignment;

//Inheritance occurs in this class as it inherits the existence of the states species, voice, canSwim, and canFly.
//This class also inherits the methods to manipulate all states
public class Elephant extends Animal implements Comparable<Elephant>{
	private boolean canSwim;
	private int weight;
	
	public Elephant() {
		this.setSpecies("elephant");
		this.setVoice("trumpeting");
		this.canSwim = true;
		this.weight = 100;
	}
	
	public Elephant(String species, int weight) {
		this.setSpecies(species);
		this.setVoice("trumpeting");
		this.canSwim = true;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Elephant(String species, String voice) {
		this.setSpecies(species);
		this.setVoice(voice);
		this.canSwim = true;
		this.weight = 100;
	}
	
	//This is one example of method hiding because it hides the 'panic' method in the 'HoneyBee' class. 
	public static String panic() {
		return "Stampede!";
	}
	
	public String drink() {
		return "I'm drinking.";
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
	System.out.println("It can swim: " + this.canSwim + ".");
	}
	
	//Here's the overridden equals method
	@Override
	public boolean equals(Object o) {
		if(o.getClass() == this.getClass()) {
			Elephant e = (Elephant) o;
			if(e.getSpecies() == this.getSpecies()) {
				if(e.canSwim == this.canSwim) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int compareTo(Elephant o) {
		return this.getSpecies().compareTo(o.getSpecies());
	}
}
