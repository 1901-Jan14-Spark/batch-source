public class Pizza{

    String crustType;
    String sauceType;
    boolean hasCheese;
    int size;

    static int pizzasMade = 0;

    Pizza(){
        crustType = "thin";
        sauceType = "red";
        hasCheese = true;
        size = 16;
        pizzasMade++;
    }

    Pizza(String sauceType, boolean hasCheese){
        this.sauceType = sauceType;
        this.hasCheese = hasCheese;
        pizzasMade++;
    }

    // including our main method 
    public static void main(String[] args){
        Pizza p = new Pizza("white",false);
        p.crustType = "cheese stuffed";
        System.out.println(p.toString());
        Pizza p2 = new Pizza();
        System.out.println(p2.toString());
        System.out.println(pizzasMade);
        Pizza.resetCounter();
        System.out.println(pizzasMade);
    }

    // converting our object to a readable string, describing the states of that object
    // this is an instance method, it will apply to each object specifically
    public String toString(){
        return "My Pizza: crustType="+crustType+", hasCheese="+hasCheese+", sauceType="+sauceType;
    }

    static void resetCounter(){
        pizzasMade = 0;
    }


}