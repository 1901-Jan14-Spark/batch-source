package pillar.java.exersice;

///This class, Leopardus, which extends Animal is representative of inheritance.
//
public class Leopardus extends Animal {
	static int earthlings;
	public int spots;
	private String size;
	public int leopardusPop;

	public String getTaxonomy() {
		return "Family: Felidae Genus: Leopardus";
	}
	
	public Leopardus(int spots, String size) {
	super();
	this.setSpots(spots);
	this.setSize(size);
	reproduce();
	}
	public static void leoSound() {
		System.out.println("All Hail King LEO!");
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leopardusPop;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + spots;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leopardus other = (Leopardus) obj;
		if (leopardusPop != other.leopardusPop)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (spots != other.spots)
			return false;
		return true;
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

	@Override
	public int compareTo(Animal arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
