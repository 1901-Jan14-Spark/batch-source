package com.revature.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Driver {
	
	public static void main(String[] args) {
		
		System.out.println("FOUR PILLARS");
		System.out.println("------------\n");
		
		//Basic Animal
		/* Animal a1 = new Animal(); // this no arguments constructor creates an Animal object using the default constructor, which has default values as well
		System.out.println(a1.toString()); */
		
		// Aniaml with paramaterized constructor
		/* System.out.println();
		Animal a2 = new Animal(2, false);
		System.out.println(a2.toString());
		System.out.println();
		a2.setNumOfLegs(4); // change the number of legs on animal 2 with is access modifier
		System.out.println(a2.toString());
		System.out.println(); */
		
		// Using Covarient Types to create a new object.  A third type of polymorphism.
		/*Animal a3 = new Cat(); // because it is an Animal, it does not have access to the methods of the Cat class
		System.out.println(a3.toString());
		System.out.println(); */
		
		
		//Cat objects
		/* Cat c1 = new Cat(); // creating a Cat object with the null constructor
		System.out.println(c1.toString());
		System.out.println();
		Cat c2 = new Cat("Lion", true, "African Safari"); // Cat object using the constructor with parameters
		System.out.println(c2.toString());
		System.out.println(c2.run());
		System.out.println(); */
		
		
		// Panther objects
		/* Cat p1 = new Panther(); // the Panther class only has one constructor
		System.out.println(p1.toString());
		Panther p2 = new Panther();// 
		p2.setDomainStatus("Wakanda"); // changes the domain of the created p2 object
		System.out.println(p2.toString());
		System.out.println(p2.run()); // invokes the run method specified in the panther class
		System.out.println(); */
		
		// Sphynx objects
		/* Cat s1 = new Sphynx();  // another Covarient type
		System.out.println(s1.toString());
		System.out.println();
		Sphynx s2 = new Sphynx(); // a pure Sphynx objet
		s2.setBreed("Egyptian"); // change the breed of the stander Sphynx object
		System.out.println(s2.toString());
		System.out.println(s2.run()); // invoke the run method of the object
		System.out.println(); */
		
		// Monkey object
		/* Animal m1 = new Monkey(); // this covarient type will not have access to the methods of the Monkey class
		System.out.println(m1.toString());
		// m1.setBreed("Orangutan"); does not work because it is a Covarient type
		System.out.println();
		Monkey m2 = new Monkey("Chimpanzee");
		System.out.println(m2.toString());
		System.out.println(m2.swing());
		m2.setBreed("Gorilla"); // m2 is a pure monkey object, so the values can be accessed through the access modifiers
		m2.setHasTail(false);
		System.out.println();
		System.out.println(m2.toString());
		System.out.println(m2.run()); */
		
		
		
		// PART TWO
		
		
		//Cats
		System.out.println("Comparison using overridden .equals() method.");
		Cat cat1 = new Cat();
		Cat cat2 = new Cat();
		System.out.println(cat1.toString());
		System.out.println(cat2.toString());
		System.out.println("These cats are equal: " + (cat1.equals(cat2)));
		System.out.println();
		
		Monkey mon1 = new Monkey("Chimp");
		Monkey mon2 = new Monkey("Baboon");
		System.out.println(mon1.toString());
		System.out.println(mon2.toString());
		System.out.println("These monkeys are equal: " + (mon1.equals(mon2)));
		
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("Method Hiding");
		
		
		System.out.println("Virtual Method Invocation");
		Animal a1 = new Animal();
		// this will invoke the static method from the Animal class
		a1.staticMethod();
		a1.instanceMethod();
		Monkey m1 = new Monkey();
		// this is method hiding, there are static methods in both the superclass and sub class, so the method from the super class will be hidden
		m1.staticMethod();
		//because this method is an instance of the Monkey class, it will override the same method in the parent Animal class
		m1.instanceMethod();
		Animal a2 = new Monkey();
		// because we are casting a Monkey object as an Animal, when we call to the function, it is an example of Virtual Method Invocation
		a2.instanceMethod();
		// we could also have Virtual Method Invocation in this way
		Animal a3 = (Monkey) a2;
		a3.instanceMethod();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("IMPLEMENTATION OF COMPARABLE AND COMPARATOR");
		System.out.println("-------------------------------------------");
		System.out.println();
		//create a new list of animals
		LinkedList<Animal> animalList = new LinkedList<Animal>();
		animalList.add(new Animal(4, false, "Spongebob"));
		animalList.add(new Animal(5, false, "Dove"));
		animalList.add(new Animal(8, true, "Squidward"));
		animalList.add(new Animal(4, false, "Eugene"));
		
		System.out.println("Unsorted animals:");
		for(Animal a : animalList) {
			System.out.println(a);
		}
		System.out.println();
		System.out.println();
		//sort the animals by their respective number of legs
		Collections.sort(animalList);
		System.out.println("Animals Sorted as a Comparable");
		for(Animal a : animalList) {
			System.out.println(a);
		}
		
		System.out.println();
		System.out.println();
		// implementation of comparator
		// create a new list of cats
		LinkedList<Cat> catList = new LinkedList<Cat>();
		catList.add(new Cat("Siamese", true, "House"));
		catList.add(new Cat("Jaguar", true, "Jungle"));
		catList.add(new Cat("Munchkin", true, "House"));
		
		// using the CatComparator to sort the cats by their name and put them in their natural order (alphabetical)
		CatComparator comparator = new CatComparator();
		Collections.sort(catList, comparator);
		System.out.println("Cats sorted with CatComparator:");
		for(Cat kitty : catList) {
			System.out.println(kitty);
		}
		
		System.out.println();
		System.out.println();
		
		// comparing two animals to each other directly
		Animal firstAnimal = new Animal(4, false, "Pete");
		Animal secondAnimal = new Animal(4, true, "Pete");
		Animal thirdAnimal = new Animal(2, true, "Chuck");
		
		System.out.println(firstAnimal.toString());
		System.out.println(secondAnimal.toString());
		System.out.println(thirdAnimal.toString());
		System.out.println();
		
		System.out.println("The first two animals are equal: " + firstAnimal.equals(secondAnimal));
		System.out.println("The first and third animals are equal: " + firstAnimal.equals(thirdAnimal));
		
		
		
	}

}
