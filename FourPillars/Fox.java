public class Fox extends Mammal {

//I want to make it that if hasLegs == true THEN numLegs = 4


	public Fox(){
		super();	
	}
    //overriding
	public void makeNoise() {
		System.out.println("Ring-ding-ding-ding-ding-dingading");
	}
	
	public static drinksWater(){
		counter*2;
	}
	
	//overloading
	public Fox(String furColor, int numLegs) {
		this.furColor = furColor;
		makeNoise();
	}
	
	
	public String getFurColor() {
		return furColor;
	}
	
	public int drinksWater() {
		System.out.println("Ahhhhhhh");
		return 1;
	}
	
	public boolean equals (Object o) {
		Animals a1 = (Animals) o;
		If(o.getClass() != this.getClass()) {
			return false;
		}
		If(this.furColor() != a1.furColor()) {
			return false;
		}
}
