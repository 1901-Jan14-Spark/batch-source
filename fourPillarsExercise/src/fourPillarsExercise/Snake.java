package fourPillarsExercise;

//uses inheritance to inherit the methods from Reptile.java, where it uses typeofReptile and isBitYou 
public class Snake extends Reptile{
	private boolean isVenemous;
	public Snake() {
		super();
		this.setNumOfLegs(0);
		this.setNoise("HISS!");
		isVenemous = true;
	}
	
	public boolean isthisVenemous() {
		return isVenemous;
	}

	public void setVenemous(boolean isVenemous) {
		this.isVenemous = isVenemous;
	}

	//overwrites the method typeOfReptile since the animal is a snake
	public void typeOfReptile() {
		System.out.println("This reptile is a snake");
	}
	
	public String hasFur() {
		return "this creature is scaly not furry";
	}
	
	public void whatItEats(String food) {
		System.out.println("This animal eats " + food);
	}
	
	public void itBitYou(boolean youBitten) {
		if(youBitten && isVenemous) {
			System.out.println("The reptile has bitten you and is venemous");
		}
		else if(youBitten && !isVenemous){
			System.out.println("You have been bitten, but the reptile is not venemous");
		}
		
		else if(!youBitten && isVenemous){
			System.out.println("You have not been bitten.  That is good because the reptile is venemous");
		}
		else {
			System.out.println("You have not been bitten.");
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return true;
		}
		Snake r = (Snake) o;
		if(this.getNumOfLegs() != r.getNumOfLegs()) {
			return false;
		}
		if(this.getAnimalNoise() != r.getAnimalNoise()) {
			return false;
		}
		
		if(this.isVenemous != r.isthisVenemous()) {
			return false;
		}
		return false;
	}

}
