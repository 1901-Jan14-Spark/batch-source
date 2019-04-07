package com.rev.patterns;

public class Driver {

	public static void main(String[] args) {
		
		
		
		AnimalFactory af = new AnimalFactory();
		Animal a1 = af.getAnimal("Llama");
		Animal a2 = af.getAnimal("shrimp");
		
		a2.makeNoise();
		a2.makeNoise();
		
		
		
		
		
		
		
		
		
		
		
		
		
//		MySingleton singleton1 = MySingleton.getInstance();
//		MySingleton singleton = MySingleton.getInstance();
//		System.out.println(singleton==singleton1);
//		
//		
//		singleton.setValue(5);
//		System.out.println(singleton1.getValue());
//		
	}

}
