
public abstract class Mammal extends Animals {
	
	//Instance Variables
	private int numLegs;
	public String noise;
	public String furColor;

	public Mammal() {
		super();
	}
	
	//Mammal Constructor
	public Mammal(int numLegs, String noise, String furColor) {
		super();
		this.numLegs = numLegs;
		this.noise = noise;
		this.furColor = furColor;
	}
	
	//Getter/setter for number of legs	
	public int getNumLegs() {
		return numLegs;
	}
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	
	public boolean equals (Object o) {
		Animals a1 = (Animals) o;
		If(o.getClass() != this.getClass()) {
			return false;
		}
		If(this.noise != a1.noise()) {
			return false;
		}
		If(this.furColor != a1.furColor()) {
			return false;
		}
		If(o.getClass() != this.getClass()) {
			return false;
		}
	
}