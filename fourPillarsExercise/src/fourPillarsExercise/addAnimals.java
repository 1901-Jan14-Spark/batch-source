package fourPillarsExercise;

public class addAnimals {

	public static void main(String[] args) {
		Reptile anin1 = new Reptile();
		Reptile snake1 = new Snake();
		System.out.println("Reptile 1 makes the " + anin1.getAnimalNoise() + " noise");
		anin1.hasFur();
		anin1.typeOfReptile();
		anin1.setNoise("RAARRR");
		System.out.println("Reptile 1 makes the " + anin1.getAnimalNoise() + " noise");
		snake1.typeOfReptile();
		System.out.println("this reptile has " + snake1.getNumOfLegs() + " legs");
		anin1.itBitYou(false);
		snake1.itBitYou(true);
		snake1.itBitYou(true, true);

	}

}
