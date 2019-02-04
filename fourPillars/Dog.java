public class Dog extends Mammal implements Walkable{ //second subclass
    
    public void walk(){
        System.out.println("Im a dog, and I walk, with my four legs!");
    }
    public static void main(String[] args){
        Mammal mammy = new Mammal();
        mammy.talk();
        Mammal mDawg = new Dog(); //Covarience
        mDawg.talk(); // using an overridden method
        Dog snoop = new Dog();
        snoop.talk();
        snoop.talk("myshizzle"); //overloaded method
        snoop.talk("foshizzle","mynizzle");
        snoop.walk(); //implemented interface method
    }
    Dog(){
        super(4,true);
    }
    public void talk(){
        System.out.println("Bark, bark, bark, bark!");
    }
    public void talk(String bark){
        for(int i = 0; i<10; i++){
            System.out.println(bark);
        }
    }
    public void talk(String bark1 , String bark2){
        for(int i = 0; i<10; i++){
            if( i%2 == 0)
                System.out.println(bark1);
            else
                System.out.println(bark2);
        }
    }
    
}