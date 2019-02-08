package weekC.assignment;
import java.util.*;

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
		
		System.out.println();
		ArrayList<Elephant> eList = new ArrayList<Elephant>();
		eList.add(new Elephant("african", 500));
		eList.add(new Elephant("indian", 350));
		eList.add(new Elephant("asian", 200));
		Collections.sort(eList);
		System.out.println("Elephants sorted by location:");
		for(Elephant eOutput : eList) {
			System.out.println(eOutput.getSpecies());
		}
		
		System.out.println();
		System.out.println("Elephants sorted by weight:");
		WeightComp wComp = new WeightComp();
		Collections.sort(eList, wComp);
		for(Elephant eOutput : eList) {
			System.out.println(eOutput.getSpecies() + " weighs " + eOutput.getWeight() );
		}
	}

}
