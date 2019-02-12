package animalGroups;


// we making this an abstract class as a general definition of what animals should have
public abstract class Animal {

	private String locomotionType = "temp locomotion valiue \n";
	
	
	
	
	
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}





	public String getLocomotionType() {
		return locomotionType;
	}





	public void setLocomotionType(String locomotionType) {
		this.locomotionType = locomotionType;
	}

	
	public abstract String breathsWith();
		
		
		
		

	
	
	
	
	
}
