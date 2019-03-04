import java.io.FileNotFoundException;

public class Dog extends Mammal implements Walkable{ //second subclass
    
    public void walk(){
        System.out.println("Im a dog, and I walk, with my four legs!");
    }
    public static void main(String[] args){
        Mammal mammy = new Mammal();
        mammy.talk();
        Mammal mDawg = new Dog(); //Covarience
        mDawg.talk(); // using an overridden method, also is an example of virtual method invocation;
        Dog snoop = new Dog();
        snoop.talk();
        snoop.talk("bark"); //overloaded method
        snoop.talk("ruff","bork");
        snoop.walk(); //implemented interface method
        Dog snoopy = new Dog();
        if(snoopy.equals(snoop))
            System.out.println("Snoop and Snoopy are both equivalent dogs.");
        Mammal.cloaked(); // method that will be hidden in the sub class
        Dog.cloaked(); // method that hides the superclass implementation
        //snoopy.setNumLegs(-1); //checked
        Dog borker = new Dog("doggy.txt");//unchecked
        borker.talk();
    }
    Dog(){
        super(4,true);
    }
    Dog(String dogConfig){
        if(dogConfig.equals("dogConfig.txt"))
            System.out.println("Dog is configured.");
        else{
            try{
                throw new FileNotFoundException("cannot find dogConfig.txt");}
            catch(FileNotFoundException e){
                e.printStackTrace();
                this.setClassification("Mammal");
                this.setHasFur(true);
                this.setNumLegs(4);
                this.setHasWarmBlood(true);
            }

        }
    }
    public boolean equals(Object a){
        if(a.getClass() != this.getClass())
            return false;
        Dog o = (Dog)a;
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
    public void talk(){
        System.out.println("Bark, bark, bark, bark!");
    }
    public void talk(String bark){
        for(int i = 0; i<10; i++){
            System.out.print(bark+"! ");
        }
    }
    public void talk(String bark1 , String bark2){
        for(int i = 0; i<10; i++){
            if( i%2 == 0)
                System.out.print(bark1+"! ");
            else
                System.out.print(bark2+"! ");
        }
    }
    public static void cloaked(){
        System.out.println("This function hides Mammal.cloaked()");
    }
    
}