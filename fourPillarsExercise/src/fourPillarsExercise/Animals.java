package fourPillarsExercise;

//use of an absract class
public abstract class Animals implements additionaFacts {
	private int numOfLegs;
	private String Noise;
	
	public int getNumOfLegs()
	{
		return numOfLegs;
	}
	public void setNoise(String noise) {
		Noise = noise;
	}
	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}
	public String getAnimalNoise() {
		return Noise;
	}
}
