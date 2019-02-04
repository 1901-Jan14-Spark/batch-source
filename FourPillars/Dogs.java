public class Dogs extends Animals{

    boolean barking; 

    public Dogs(){ 
        this.movementSpeed = 0;
        this.running = false; 
        this.sleeping = false;
        this.hungry = true;
        this.breed = "unknown";
    }

    public Dogs(String breed){
        this.movementSpeed = 0;
        this.running = false; 
        this.sleeping = false;
        this.hungry = true;
        this.breed = "breed";
    }

    public void startle(){ //overrides 'startle' in Animals
        sleeping = false;
        running = true;
        movementSpeed = 5;
        barking = true;
    }

}