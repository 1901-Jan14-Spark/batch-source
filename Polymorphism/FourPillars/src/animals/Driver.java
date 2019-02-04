package animals;

public class Driver {

	public static void main(String [] args) {
		Tiger white= new Tiger();
		white.setAnimalName("White Tiger");
		white.setSpecies("Pantera tigris");
		white.setEatsMeat(true);
		white.setNumOfLegs(4);
		white.setEndangered(true);
		white.setHuntable(true);
		white.setHunted(true);
		System.out.println(white.toString());
	
	
		Giraffe bob = new Giraffe();
		bob.setAnimalName("Bob");
		bob.huntable(true);
		bob.setHunted(false);
		System.out.println(bob.toString());
	}
}