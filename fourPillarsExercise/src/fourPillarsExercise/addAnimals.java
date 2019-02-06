package fourPillarsExercise;

public class addAnimals {

	public static void main(String[] args) {
		Animals anin = new Reptile();
		Animals anin2 = new Reptile();
//		anin.MakeNoise();
//		anin.thisIS();
//		Reptile anin1 = new Reptile();
//		anin1.thisIS();
//		Reptile snake1 = new Snake();
//		System.out.println("Reptile 1 makes the " + anin1.getAnimalNoise() + " noise");
//		anin1.hasFur();
//		anin1.typeOfReptile();
//		anin1.setNoise("RAARRR");
//		System.out.println("Reptile 1 makes the " + anin1.getAnimalNoise() + " noise");
//		snake1.typeOfReptile();
//		System.out.println("this reptile has " + snake1.getNumOfLegs() + " legs");
//		anin1.itBitYou(false);
//		snake1.itBitYou(true);
//		Reptile snake2 = new Snake();
//		Snake snakeA = (Snake) snake1;
//		Snake snakeB = (Snake) snake2;
		System.out.println(anin.getNumOfLegs());
		System.out.println(anin2.getNumOfLegs());
		System.out.println(anin.getAnimalNoise());
		System.out.println(anin2.getAnimalNoise());
		System.out.println(anin.getClass());
		System.out.println(anin2.getClass());
		if(anin.equals(anin2)) {
			System.out.println("these animals are the same");
		}
		else {
			System.out.println("these animals are different");
		}

	}

}
