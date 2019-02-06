public class Mammal extends Animal{//first subclass
    private boolean hasFur; 
    public void talk(){
        System.out.println("I am a mammal, a very mammaly mammal.");
    }
    Mammal(){
        setClassification( "Mammal");
        setHasWarmBlood(true);
    }
    Mammal(int numLegs, boolean hasFur){
        setClassification( "Mammal");
        setHasWarmBlood(true);
        setNumLegs(numLegs);
        this.hasFur = hasFur;
    }
    public boolean equals(Object a){
        if(a.getClass() != this.getClass())
            return false;
        Mammal o = (Mammal)a;
        if(o.getHasFur()!= this.getHasFur())
            return false;
        if(o.getNumLegs() != this.getNumLegs())
            return false;
        if(o.getHasWarmBlood() != this.getHasWarmBlood())
            return false;
        if(o.getClassification() != this.getClassification())
            return false;
        return true;
    }
    public boolean getHasFur(){
        return this.hasFur;
    }
    public void setHasFur(boolean hasFur){
        this.hasFur = hasFur;
    }
    public static void cloaked(){
        System.out.println("This function will be hidden when it the same function is implemented in the subclass");
    }
}