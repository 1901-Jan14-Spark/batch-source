package fourPillarsExercise;

//uses inheritance to inherit the methods from Reptile.java, where it uses typeofReptile and isBitYou 
public class Snake extends Reptile{
	
	public Snake() {
		super();
		this.setNumOfLegs(0);
		this.setNoise("HISS!");
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
	
	public void itBitYou(boolean isVenemous) {
		if(isVenemous) {
			System.out.println("The snake is venemous");
		}
		
		else {
			System.out.println("the snake is non venemous");
		}
	}

}
