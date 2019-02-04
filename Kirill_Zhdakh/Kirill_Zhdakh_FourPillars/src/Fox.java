public class Fox extends Animal implements iInfo {
	//Inheritance from Animal
	//Abstraction from Animal, have to use toString() and warCry()
	public Fox()
	{
		eyeColor = "Green";
		furColor = "Orange";
		age = 5;
	}
	public Fox(String eyeColor, String furColor, int age)
	{
		this.eyeColor = eyeColor;
		this.furColor = furColor;
		this.age = age;
	}
	public String toString()
	{
		return "Animal: Fox" + " Eye Color: " + eyeColor + " Fur Color: " + furColor + " Age: " + age;
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
}
