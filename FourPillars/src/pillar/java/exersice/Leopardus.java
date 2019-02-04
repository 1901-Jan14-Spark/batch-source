package pillar.java.exersice;

///This class, Leopardus, which extends Animal is representative of inheritance.
//
public class Leopardus extends Animal {
	static int earthlings;
	private int spots;
	private String size;
	public int leopardusPop;

	
	
	public Leopardus(int spots, String size) {
	super();
	this.setSpots(spots);
	this.setSize(size);
	reproduce();
	}
	
	
	
	
	Leopardus get() {
		System.out.println("Leopardus is a genus of spotted "
				+ "small cats mostly native to Middle and South America,"
				+ " with a very small range extending"
				+ " into the southern United States.");
		return this;
	}
	//this method, communicate, is inherited from the parent class Animal
	public void communicate() {
		System.out.println("Grawl");
		
		
	}
	///this method is implemented from the interface Earthlife, which is implemented 
	// in this classes parent class Animal and whose exstension is applied in this class.
	// this would be an example of abstraction as well as inheritance 
	public int reproduce() {
		earthlings =  earthlings++;
		leopardusPop =  leopardusPop++;
		System.out.println(earthlings);
		return leopardusPop;
		
	}
		
		public void drinks(int numberOfDrinks) {
			numberOfDrinks = 12;
		}
		


	@Override
	void eats() {
		// TODO Auto-generated method stub
		
	}


	@Override
	void drinks() {
		// TODO Auto-generated method stub
		
	}


	public int getSpots() {
		return spots;
	}


	public void setSpots(int spots) {
		this.spots = spots;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}
}
