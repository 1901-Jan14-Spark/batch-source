package pillar.java.exersice;
///This abstract class which is implementing the interface EarthLife representing
//abstraction. 
public abstract class Animal implements EarthLife {
	abstract void eats();
	//abstract void drinks();
	static int earthlings;
	static int animals;
	 
	public Animal() {
		super();
	}
	
	abstract void drinks();
		
	
//	public void eat{
//		
//	}
	
	public abstract void communicate();
}
