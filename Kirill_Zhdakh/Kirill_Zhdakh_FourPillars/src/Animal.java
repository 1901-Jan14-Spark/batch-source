
public abstract class Animal {
	//Variables
	static int animalCount;
	String eyeColor;
	String furColor;
	int legs;
	int age;
	
	//Methods
	//Polymorphism, Fox and Tiger have different returns(override)
	public abstract String warCry();
	public abstract String warCry(boolean isBaby);
	public abstract String toString();
	public static String likesFood() {
		return "Default food";
	}
	
	//Encapsulation
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getFurColor() {
		return furColor;
	}
	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}
	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		this.legs = legs;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
