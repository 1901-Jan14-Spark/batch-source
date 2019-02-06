package animalGroups;

public class Insects extends Animal implements CanFly  {

	public Insects() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String breathsWith() {
		// TODO Auto-generated method stub
		return "spiracles";
	}

	
	
	
	/*here insect is extends from Animal object, but also implements the the fly interface.
	 * 
	 *   */
	@Override
	public void fly() {
		System.out.println("flutter,flutter");
		// TODO Auto-generated method stub
		
	}

	@Override
	public String wingType() {
		
		return "insecty wings";
		// TODO Auto-generated method stub
		
	}

	

}
