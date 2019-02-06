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
	public void MakeNoise() {
		System.out.println("RAAARRRR");
	}
	
	public static void thisIS() {
		System.out.println("This is an animal");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != this.getClass()) {
			return true;
		}
		Animals a = (Animals) o;
		if(this.numOfLegs != a.getNumOfLegs()) {
			return false;
		}
		if(this.Noise != a.getAnimalNoise()) {
			return false;
		}
		return false;
	}
}
