package animals;

public class Giraffe extends AnimalTypes{
	private boolean hasSpots;
	public int numOfLegs;

	public boolean isHasSpots() {
		return hasSpots;
	}

	public void setHasSpots(boolean hasSpots) {
		this.hasSpots = true;
	}

	@Override
	public boolean huntable() {
		return huntable(false);
	}
	public static void printNotice() {
		System.out.println("This is a Giraffe");
	}
	
	@Override
	public boolean huntable(boolean huntable) {
		return false;
	}

	public int getNumOfLegs() {
		return numOfLegs=4;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}

	@Override
	public String toString() {
		return "Giraffe [hasSpots=" + hasSpots + ", animalName=" + animalName + ", huntable()=" + huntable()
				+ ", numOfLegs()=" + getNumOfLegs() + "]";
	}
	
}
