package animalGroups;

import java.util.Arrays;

public class creator {

	public creator() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// dynamic polymorphism where the JVM decides which process to use at runtime 
		Animal fishType = new Fish();
		fishType.breathsWith();
		System.out.print(fishType.breathsWith());
		
		Insects insectType = new Insects();
		insectType.fly();
	   
		
		//static polymorphism where Java knows which method to invoke during compile time - overloading
		Birds birdType = new Birds();
      	birdType.diet("doughnuts");
      	birdType.diet();
      	
        /*In this inheritance, the owl object changes the value of the variable that it 
      	inherited from the Birds class */
      	Owl bird= new Owl();
        System.out.print(bird.beaktype);
		
        
        
        
        /*here we are using getter and setter to set the value of a private inherited property of 
         * the Animal class which is part of encapsulation */
        Animal anotherFishType = new Fish();
        anotherFishType.setLocomotionType("fins");
        System.out.print(fishType.getLocomotionType());
        
        
        /* The vulture class redefines diet to meat instead of insect. Even though the reference  
            variable is of a bird class, we still invoke the behaviors of the culture class definition. 
         this is call virtual method invocation */
        Birds vulture = new Vulture();
        vulture.diet();
       
       
        /*even though hagfish redefines the havefins() method to false, the implementations of Fish class is called
         * since the methods are static. This is called method hiding. Also, it is not a good practice to call
         * static methods from their instances.  */
        Fish hagfish = new Hagfish();
         System.out.print(hagfish.havefins());
        
        
         
         /* here, .equals method is implemented to check specific values of the objects instead of checking 
          * Reference, therefore the equals comparison gives us true while the == comparison gives as false since the 
          * reference variable is pointing to two different objects    */
         Birds bird1 = new Birds();
         Birds bird2 = new Birds();
 		System.out.println("with reference: " + (bird1==bird2));
 		System.out.println("with value: " + (bird1.equals(bird2)));
 		
         

     Fish[] multiFishes = new Fruit[4];





     Fish Fish1 = new Fish(1);
     Fish Fish2 = new Fish(2);
     Fish Fish3 = new Fish(3);
     Fish Fish4 = new Fish(4);

     multiFishes[0] = Fish4;
     multiFishes[1] = Fish2;
     multiFishes[2] = Fish1;
     multiFishes[3] = Fish3;
      
 

      //comparable  
     Arrays.sort(multiFishes);
//Comparator
  Arrays.sort(multiFishes, FishNameComparator);








	}

}
