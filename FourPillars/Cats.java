public class Cats extends Animals implements CanPurr{ 
//Cats inherits many traits from Animals and implements the restrictions form Can Purr

private int purringVolume;

public Cats(){ 
    this.movementSpeed = 0;
    this.running = false; 
    this.sleeping = false;
    this.hungry = true;
    this.breed = "unknown";
}

public Cats(String breed){ //constructor overloading
    this.movementSpeed = 0;
    this.running = false; 
    this.sleeping = false;
    this.hungry = true;
    this.breed = "breed";
}


public void startle(){
    sleeping = false;
    running = true;
    movementSpeed = 5;
}

public void purring(){
    System.out.println("*purring sounds*");
}

public void setPurringVolume(int volume){
    purringVolume = volume;
}

public int getPurringVolume(){
    return purringVolume;
}

}