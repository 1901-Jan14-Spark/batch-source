package com.revature.driver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import com.revature.exceptions.NumLegsException;
import com.revature.models.Animal;
import com.revature.models.Bird;
import com.revature.models.Cat;
import com.revature.models.Cow;
import com.revature.models.Dog;
import com.revature.models.Duck;
import com.revature.models.Elephant;
import com.revature.models.Fish;
import com.revature.models.Fox;
import com.revature.models.Frog;
import com.revature.models.Mouse;
import com.revature.models.Seal;
import com.revature.models.TalkComparator;

public class Driver {

	public static void main(String[] args) {
		// Polymorphism: Covariant allows access to parent's methods while using child's
		// implementation
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal bird = new Bird();
		Animal mouse = new Mouse();
		Animal cow = new Cow();
		Animal frog = new Frog();
		Animal elephant = new Elephant();
		Animal duck = new Duck();
		Animal fish = new Fish();
		Animal seal = new Seal();
		Animal fox = new Fox();

		Animal[] myZoo = { dog, cat, bird, mouse, cow, frog, elephant, duck, fish, seal, fox };
//		//Method hiding, the static method of the subclass is hidden by the Animal superclass static method
//		for(Animal animal : myZoo) {
//			animal.makeNoise();
//		}
		
		Fish f = (Fish) fish;
		String input = "";

				try {
					f.makeNoise(input);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Caught fish noises.");
				}

		ArrayList<Animal> myAnimal = new ArrayList<Animal>();

		myAnimal.add(dog);
		myAnimal.add(fish);
		myAnimal.add(duck);
		myAnimal.add(cat);
		// sorting using comparable interface
//		Collections.sort(myAnimal);

		// Sorting by noise animals make(alphabetically)
		TalkComparator c = new TalkComparator();
		Collections.sort(myAnimal, c);

		try {
			fox.setLegs(-1);
		} catch (NumLegsException e) {
			e.printStackTrace();
			fox.setLegs(4);
		}

		
		System.out.println("\nFoxes have " + fox.getLegs() + " legs.");
		
		System.out.println(myAnimal);

		// Overriden equals method.
		System.out.println("\n\nAre dog and cat the same?" + dog.equals(cat) + "\n\n");

		// Virtual method invocation, the animal talk() method is invoked with the
		// subclasses implementation
		String whatDoAnimalsSay = "Dog goes " + dog.talk() + "\n" + "Cat goes " + cat.talk() + "\n" + "Bird goes "
				+ bird.talk() + "\n" + "And mouse goes " + mouse.talk() + "\n" + "Cow goes " + cow.talk() + "\n"
				+ "Frog goes " + frog.talk() + "\n" + "And the elephant goes " + elephant.talk() + "\n" + "Ducks say "
				+ duck.talk() + "\n" + "And fish go " + fish.talk() + "\n" + "And the seal goes " + seal.talk() + "\n\n"
				+ "But there's one sound\nThat no one knows\nWhat does the fox say?\n\n" + fox.talk() + "\n";

		System.out.println(whatDoAnimalsSay);

	}
}
