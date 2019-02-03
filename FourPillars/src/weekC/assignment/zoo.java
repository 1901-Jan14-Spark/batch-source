package weekC.assignment;

public class zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Elephant e = new Elephant("elephant", "Pvvvvvt");
		e.show();
		System.out.println();
		HoneyBee h = new HoneyBee();
		h.show();
		System.out.println();
		//Example of covariant type, treats the elephant as an animal
		Animal he = new Elephant();
		he.show();
	}

}
