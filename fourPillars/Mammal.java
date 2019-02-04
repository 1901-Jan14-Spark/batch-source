public class Mammal extends Animal{//first subclass
    private boolean hasFur; 
    public void talk(){
        System.out.println("I am a mammal, a very mammaly mammal.");
    }
    Mammal(){
        super.setClassification( "Mammal");
        super.setHasWarmBlood(true);
    }
    Mammal(int numLegs, boolean hasFur){
        super.setClassification( "Mammal");
        super.setHasWarmBlood(true);
        super.setNumLegs(numLegs);
        this.hasFur = hasFur;
    }
    public boolean getHasFur(){
        return this.hasFur;
    }
    public void setHasFur(boolean hasFur){
        this.hasFur = hasFur;
    }
}