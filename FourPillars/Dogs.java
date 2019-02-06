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

    public boolean equals(Object a){
        if(a.getClass() != this.getClass()) return false;
        Dogs a2 = (Dogs)a;
        if (this.breed == a.breed && this.sleeping == a.sleeping && this.running == a.running && this.barking == a.barking) return true;
        else return false;
    }
}