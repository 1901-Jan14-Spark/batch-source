package com.revature.driver;

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

public class Driver {

	public static void main(String[] args) {
		//Polymorphism: Covariant allows access to parent's methods while using child's implementation
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
		
		Animal[] myZoo = {dog, cat, bird, mouse, cow, frog, elephant, duck, fish, seal, fox};
		//Method hiding, the static method of the subclass is hidden by the Animal superclass static method
		for(Animal animal : myZoo) {
			animal.makeNoise();
		}
		//Overriden equals method.
		System.out.println("\n\nAre dog and cat the same?" + dog.equals(cat)+"\n\n");
		
		//Virtual method invocation, the animal talk() method is invoked with the subclasses implementation
		String whatDoAnimalsSay = 	"Dog goes " + dog.talk() + "\n" +
									"Cat goes " + cat.talk() + "\n" +
									"Bird goes " + bird.talk() + "\n" +
									"And mouse goes " + mouse.talk() + "\n" +
									"Cow goes " + cow.talk() + "\n" +
									"Frog goes " + frog.talk() + "\n" +
									"And the elephant goes " + elephant.talk() + "\n" +
									"Ducks say " + duck.talk() + "\n" +
									"And fish go " + fish.talk() + "\n" +
									"And the seal goes " + seal.talk() + "\n\n" +
									"But there's one sound\nThat no one knows\nWhat does the fox say?\n\n" +
									fox.talk() + "\n";
		
		System.out.println(whatDoAnimalsSay);
		
	}
}
