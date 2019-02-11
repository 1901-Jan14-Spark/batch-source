package animals;

import java.util.Collections;
import java.util.LinkedList;

public abstract class Driver implements Comparable<LegsComparator>{
	
	public static void main(String [] args) {
		
		
		Tiger white= new Tiger();
		white.setAnimalName("White Tiger");
//		white.setSpecies("Pantera tigris");
//		white.setEatsMeat(true);
		white.setNumOfLegs(3);
//		white.setEndangered(true);
		white.setHuntable(true);
		white.setHunted(true);
//		Tiger.printNotice(); //method hiding
		System.out.println(white.toString());
	
//	
		Giraffe bob = new Giraffe();
		bob.setAnimalName("Bob");
		bob.huntable(true);
		bob.setHunted(false);
		bob.setNumOfLegs(4);
		System.out.println(bob.toString());
//		Giraffe.printNotice(); //method hiding
	
//	
//	AnimalTypes tig= new Tiger(); // VMI
//	Tiger tig2=(Tiger)tig;
////	tig2.printNotice();
	
	//equals? 
//	Tiger tig4 = new Tiger();
//	tig4.getEatsMeat();
//	tig4.setNumOfLegs(4);
//	tig4.setHuntable(true);
//	
//	Tiger tig3 = new Tiger();
//	tig3.setNumOfLegs(3);
//	tig3.getEatsMeat();
//	tig3.setHuntable(true);
	//Trying To Print Comparison		
//		System.out.println(tig4.equals(tig3));
//		System.out.println(tig3.equals(tig4));
		
		//trying to configure Comparable/comparators
	LinkedList<Tiger> tigerslist = new LinkedList<Tiger>();
	tigerslist.add(new Tiger());
	tigerslist.add(new Tiger());
	
	 LegsComparator comparator = new LegsComparator();
	 Collections.sort(tigerslist, comparator);
		
	}


}