package fourPillarsExercise;

public class Reptile extends Animals{
	
	public Reptile(){
		super();
		this.setNumOfLegs(4);
		this.setNoise("HISS!");
	}
	
	public Reptile(int numOfLegs, String Noise){
		super();
		this.setNumOfLegs(numOfLegs);
		this.setNoise(Noise);
	}
	
	
	public String hasFur() {
		return "this creature is scaly not furry";
	}
	
	public void whatItEats(String food) {
		System.out.println("This animal eats " + food);
	}
	
	//polymorphisms overwritten example
	public void typeOfReptile() {
		System.out.println("This animal is a Lizard");
	}
	
	public void itBitYou(boolean youBitten) {
		if(youBitten) {
			System.out.println("The reptile has bitten you");
		}
		else {
			System.out.println("You have not been bitten");
		}
	}
	public void MakeNoise() {
		System.out.println("HIIISSSS");
	}
	
	public static void thisIS() {
		System.out.println("This is a reptile");
	}
//polymorphism overloading example where another parameter is added for a case where the reptile is venemous
	public void itBitYou(boolean youBitten, boolean isVenemous) {
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
			return false;
		}
		Reptile r = (Reptile) o;
		if(this.getNumOfLegs() != r.getNumOfLegs()) {
			return false;
		}
		if(this.getAnimalNoise() != r.getAnimalNoise()) {
			return false;
		}
		return true;
	}

}
