package animalGroups;

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
       

	}

}
