public class Main {
	public static void main(String[] args) {
		Animal a = new Fox("Brown", "Yellow", 15);
		System.out.println(a.toString());
		System.out.println(a.warCry());
		Fox f = (Fox)a;
		System.out.println(f.writeInfo());
		a = new Tiger();
		System.out.println(a.toString());
		System.out.println(a.warCry());
		System.out.println(a.warCry(true));
		Tiger t = (Tiger)a;
		System.out.println(t.writeInfo());
		System.out.println(Animal.likesFood());
		System.out.println(Fox.likesFood());
		System.out.println(Tiger.likesFood());
	}
}
