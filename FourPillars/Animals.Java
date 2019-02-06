public class Animals{

    //Variables set to private as part of encapsulation and abstraction. They can't be accessed directly, but can be accessesd in a limited sense by the public getters and setters.
    private int movementSpeed; 
    private boolean running; 
    private boolean sleeping;
    private boolean hungry;
    private String breed;

    public Animals(){ //No-args constructor replaces default.
        super();
    }

    //get functions allow user uninhibited 'read' access to private variables
    public int getMovementSpeed(){  
        return movementSpeed;
    }

    public boolean getRunning(){
        return running;
    }

    public boolean getSleeping(){
        return sleeping;
    }

    public boolean getHungry(){
        return hungry;
    }

    public String getBreed(){
        return breed;
    }

    //set functions restrict user's 'write' access to private variables as part of encapsulation/abstraction
    public void setMovementSpeed(int speed){
        if(sleeping == true && speed == 0){ //sanitize speed input to match if animal is sleeping or running
            this.movementSpeed = 0;
        }
        elseif(running == true && speed > 5){
            this.movementSpeed = speed;
        }
        elseif(running == false && speed <= 5){
            this.movementSpeed = speed;
        }
    }

    public void setRunning(boolean run){
        this.running = run;
        this.sleeping = !run; //Running and sleeping are mutually exclusive
    }

    public void setSleeping(boolean sleep){
        this.running = !sleep;
        this.sleeping = sleep; //Running and sleeping are mutually exclusive
    }

    public void setHungry(boolean hunger){
        this.hungry = hunger;
    }

    public void setBreed(String newBreed){
        this.breed = newBreed;
    }

    public Animal(){ //replaces default constructor

    }
    
    public void startle(){
        sleeping = false;
        running = true;
    }

    public static void feed(){
        this.setHungry(false);
    }

    public boolean equals(Object a){ //override the default equals function
        if(a.getClass() != this.getClass()) return false;
        Animals a2 = (Animals)a;
        if (this.breed == a.breed && this.sleeping == a.sleeping && this.running == a.running) return true;
        else return false;
    }
}