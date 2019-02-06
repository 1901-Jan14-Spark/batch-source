package com.revature.models;

public class Driver {
	
	public Driver() {
	}
	
	/*
	 * The following two methods of add are examples of method overloading (polymorphism). By 'overloading'
	 * the parameters of the same method signature, we are able to access the behavior of this method in different ways.
	 * One way adds two integer values as the parameter, the other method can utilize 3 integer values as the parameters. 
	 */
	public int add(int a, int b) {
		return a + b;
	}
	
	public int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public static void main(String[] args) {
		Cat c = new Cat();
		c.setNumHearts(2);
		c.setNumLegs(5);
		System.out.println(c.getNumHearts());
		System.out.println(c.getNumLegs());
		
		Cat d = new Cat();
		d.setNumLegs(3);
		System.out.println(d.getNumLegs());
		d.setHasLungs(true);
		System.out.println(d.getHasLungs());
		d.walk();
		
		/*
		 *  Below is an example of using covariant types (polymorphism). We used the superclass Animals to refer to a subclass Cat and instantiated a new Cat object 
		 *  but limited it to only the constructor of the superclass, thus allowing the Cat object to adapt the behavior of the Animals class in a different context.
		 */
		
		Animals animal = new Cat();
		animal.setNumLegs(2);
		System.out.println(animal.getNumLegs());
		
		Driver driv = new Driver();
		System.out.println(driv.add(1, 2));
		System.out.println(driv.add(5, 6, 7));
		
		// This is an example of virtual method invocation
		Animals anim = new Cat();
		String sound = "Meow";
		c.makeNoise(sound);
		anim.makeNoise(sound);
		Base bingo = new Child();
		bingo.printThis();
		
		//This is an example of using the .equals method
		Cat thiscat = new Cat();
		thiscat.setHasLungs(false);
		thiscat.setNumLegs(3);
		thiscat.setNumHearts(1);
		thiscat.setHasWhiskers(true);
		
		Cat othercat = new Cat();
		othercat.setHasLungs(false);
		othercat.setNumLegs(3);
		othercat.setNumHearts(1);
		othercat.setHasWhiskers(true);
		
		System.out.println(thiscat.equals(othercat));
		
		//This is an example of method hiding
		new Child().printThis();
		new Base().printThis();
		Animals.run();
		Cat.run();
		
		
	
		
		
		
	}
	
}
