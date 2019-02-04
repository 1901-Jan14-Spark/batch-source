public abstract class Animal{
    private String classification; //abstract class at the top of the higherarchy
    private int numLegs;
    private boolean hasWarmBlood;
    Animal(){
    }
    Animal(String classification, int numLegs, boolean hasWarmBlood){
        this.hasWarmBlood = hasWarmBlood;
        this.numLegs = numLegs;
        this.classification = classification;
    }
    public abstract void talk();
    public void setClassification(String classification){
        this.classification = classification;
    }
    public String getClassification(){
        return this.classification;
    }
    public void setNumLegs(int num){
        this.numLegs = num;
    }
    public int getNumLegs(){
        return this.numLegs;
    }
    public void setHasWarmBlood(boolean hasWB){
        this.hasWarmBlood = hasWB;
    }
    public boolean getHasWarmBlood(boolean hasWB){
        return this.hasWarmBlood;
    }


}