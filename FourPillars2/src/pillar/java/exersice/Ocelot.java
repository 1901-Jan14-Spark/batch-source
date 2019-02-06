package pillar.java.exersice;

public class Ocelot extends Leopardus{
	static int earthlings;
	public int ocelots;
	
	public String getTaxonomy() {
		return "Famliy: Felidae, Genus: Leopardus";
		
	}
	public Ocelot(int spots, String size) {
		super(12, "Medium");
		
	}
	
	public static void leoSound() {
		System.out.println("Imma ocelot");
	}
	///This method is returning this system out object which is an example of covariant 
	// return type because the Leopardus (this classes parent) is using the same method but returning a 
	//different value
	Ocelot get() {
		System.out.println("The ocelot (Leopardus pardalis) is "
				+ "a wild cat native to the southwestern United States, "
				+ "Mexico, Central and South America. ");
		return this;
	}
	///This method demonstrates polymorphism in the form of method overriding.  The 
	//implementation for this method, defined in the interface Earthlife and implemented in
	//the class Leopardus, is adding and this changing the implementation specific to this class.  
	public int reproduce() {
		leopardusPop = leopardusPop ++;
		ocelots = ocelots++;
		earthlings = earthlings ++;
		System.out.println(leopardusPop  + ":"+ocelots+":"+ earthlings );
		return ocelots;
		
		
		
	}
	///This method is an example of method overloading by changing the parameters to specifically 
	//implement parameters for this class while keeping the method
	public void numberOfDrinks(boolean doesDrink) {
		doesDrink = true;
	}

}

