package com.revature.models;

public class Driver {
	public static void main(String[] args) {
		
		Animal a = new Animal();
		System.out.println(a.getLegs());
		a.setLegs(4);
		System.out.println(a.getLegs());
		
		//Covarient Types Example
		Animal d = new Dog();
		System.out.println(d.call());
		System.out.println(d.getType());
		
		Dog d2 = new Dog(true);
		System.out.println(d2.isHappy());
		d2.setType("Carnivore");
		System.out.println(d2.getType());
		
		Eagle e = new Eagle();
		e.Fly();
		
		Bat b = new Bat();
		b.Fly();
		
		System.out.println(b.call());
		
		//Equals override example
		System.out.println(d.equals(d2));
		
		Dog d3 = new Dog();
		d3.setType("Carnivore");
		System.out.println(d2.equals(d2));
		
	}
}
