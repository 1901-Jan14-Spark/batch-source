package pillar.java.exersice;
///This abstract class which is implementing the interface EarthLife representing
//abstraction. 
public abstract class Animal extends Exeption implements EarthLife,Comparable<Animal> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;





	abstract void eats();
	//abstract void drinks();
	static int earthlings;
	static int animals;
	 
	
	
	
	
	public Animal() {
		super();
	}
	
	public static int getEarthlings() {
		return earthlings;
	}

	public static void setEarthlings(int earthlings) {
		if(earthlings<0) {
			throw new Exeption("Impposible Bro");
		}
		Animal.earthlings = earthlings;
		
	}

	public static int getAnimals() {
		return animals;
	}

	public static void setAnimals(int animals) {
		Animal.animals = animals;
	}

	abstract void drinks();
		
	
//	public void eat{
//		
//	}
	
	public abstract void communicate();
}
