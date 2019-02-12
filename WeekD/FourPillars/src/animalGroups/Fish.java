package animalGroups;

public class Fish extends Animal implements Comparable<Fish>{

	private int size;
	private Strting fishName;


	public Fish() {
		// TODO Auto-generated constructor stub
	}


	public Fish( int size) {
		// TODO Auto-generated constructor stub

		this.size = size;
	}
	
	
	public void fishTalk() {
		
		System.out.println("Blob blob");
		
	}
     public int getSize(){


		return this.size;
	 }

	 public String getFishName(){


		return this.fishName;
	 }


	@Override
	public String breathsWith() {
		
		return "gills";
	}


public static boolean havefins() {
		
		return true;
		
	}
	public int compareTo(Fish  compareFish) {
	
		int compareSize = ((Fish) compareFish).getQuantity(); 
		
		//ascending order
		return this.size - compareSize;
		
		//descending order
		//return compareQuantity - this.quantity;
		
	}	
	
	public static Comparator<Fish> FishNameComparator 
                          = new Comparator<Fish>() {

	    public int compare(Fish fish1, Fish fish2) {
	    	
	      String fishOne = fish1.getFishName().toUpperCase();
	      String fishTwo = fish2.getFishName().toUpperCase();
	      
	      //ascending order
	      return fishOne.compareTo(fishTwo);
	      
	      //descending order
	      //return fruitName2.compareTo(fruitName1);
	    }

	};
	
	
	
}
