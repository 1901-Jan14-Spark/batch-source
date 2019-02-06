public class Fox extends Animal implements iInfo {
	//Inheritance from Animal
	//Abstraction from Animal, have to use toString() and warCry()
	public Fox()
	{
		eyeColor = "Green";
		furColor = "Orange";
		age = 5;
		animalCount++;
	}
	public Fox(String eyeColor, String furColor, int age)
	{
		this.eyeColor = eyeColor;
		this.furColor = furColor;
		this.age = age;
		animalCount++;
	}
	public static String likesFood() {
		return "I like rabbits.";
	}
	public String toString()
	{
		return "Animal: Fox" + " Eye Color: " + eyeColor + " Fur Color: " + furColor + " Age: " + age + " Animal Count: " + animalCount;
	}
	public String warCry()
	{
		return "YEEPYEEP!";
	}
	public String warCry(boolean isBaby)
	{
		return "yeep..yeep!";
	}
	public String writeInfo()
	{
		return "Foxes are very cunning creatures. Don't get too close, even if they are cute, they are still wild animals.";
	}
	public boolean equals(Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof Fox))
			return false;
		Fox f = (Fox)o;
		return eyeColor.compareToIgnoreCase(f.eyeColor) == 0 &&
				furColor.compareToIgnoreCase(f.furColor) == 0 &&
				age == f.age;
	}
}
