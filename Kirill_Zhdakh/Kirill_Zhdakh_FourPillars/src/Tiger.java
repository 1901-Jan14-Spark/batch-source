public class Tiger extends Animal implements iInfo {
	//Inheritance from Animal
	//Abstraction from Animal, have to use toString() and warCry()
	String pattern;
	String patternColor;
	public Tiger()
	{
		eyeColor = "Blue";
		furColor = "White";
		age = 10;
		pattern = "Stripped";
		patternColor = "Black";
		animalCount++;
	}
	public Tiger(String eyeColor, String furColor, String pattern, String patternColor, int age)
	{
		this.eyeColor = eyeColor;
		this.furColor = furColor;
		this.pattern = pattern;
		this.patternColor = patternColor;
		this.age = age;
		animalCount++;
	}
	public static String likesFood() {
		return "I just love meat, nice and tender.";
	}
	public String warCry()
	{
		return "GRAAAAAWWWWRRRRRR!";
	}
	//Overloading warCry
	public String warCry(boolean isBaby)
	{
		return "Grawwwr...?";
	}
	public String writeInfo()
	{
		return "Tigers are a proud feline species that are not afraid to assert their dominance within an environment. Gorgeous creature, but definitely intimidating.";
	}
	public String toString()
	{
		return "Animal: Tiger" + " Eye Color: " + eyeColor + " Fur Color: " + furColor + " Pattern: " + pattern + " Pattern Color: " + patternColor + " Age: " + age + " Animal Count: " + animalCount;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getPatternColor() {
		return patternColor;
	}
	public void setPatternColor(String patternColor) {
		this.patternColor = patternColor;
	}
	public boolean equals(Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof Tiger))
			return false;
		Tiger t = (Tiger)o;
		return eyeColor.compareToIgnoreCase(t.eyeColor) == 0 &&
				furColor.compareToIgnoreCase(t.furColor) == 0 &&
				age == t.age &&
				pattern.compareToIgnoreCase(t.pattern) == 0 &&
				patternColor.compareToIgnoreCase(t.patternColor) == 0;
	}
}
