package com.revature.patterns;

public class AnimalFactory {
	
	public Animal getAnimal(String a) {
		if("fox".equals(a)) {
			return new Fox();
		} else if ("shrimp".equals(a)) {
			return new MantisShrimp();
		} else if ("llama".equals(a)){
			return new Llama();
		}
		return null;
	}

}
