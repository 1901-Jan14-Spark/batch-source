package com.revature.patterns;

public class Driver {

	public static void main(String[] args) {
		/*
		MySingleton singleton1 = MySingleton.getInstance();
		MySingleton singleton2 = MySingleton.getInstance();
		System.out.println(singleton1==singleton2);
		
		
		singleton1.setValue(5);
		System.out.println(singleton2.getValue());
		 */
		
		AnimalFactory af = new AnimalFactory();
		Animal a1 = af.getAnimal("llama");
		Animal a2 = af.getAnimal("shrimp");
		Animal a3 = af.getAnimal("fox");
		
		a1.makeNoise();
		a2.makeNoise();
		a3.makeNoise();
		
	}

}
