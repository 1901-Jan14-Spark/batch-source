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
		//Example of covariant type, treats the elephant as an animal.
		Animal he = new Elephant();
		he.show();
		System.out.println();
		Elephant bee = new HoneyBee();
		System.out.println("When bee panics it: " + bee.panic());
		System.out.println();
		//Example of virtual method invocation because the 'bee' object is calling a method from its' super class .
		System.out.println(bee.drink());
		System.out.println();
		Animal elephant1 = new Elephant();
		Animal elephant2 = new Elephant();
		Animal bee3 = new HoneyBee();
		System.out.println(elephant1.getSpecies() + " and " + elephant2.getSpecies() + " are the same: " + elephant1.equals(elephant2));
		System.out.println(elephant1.getSpecies() + " and " + bee3.getSpecies() + " are the same: " + elephant1.equals(bee3));

	}

}
