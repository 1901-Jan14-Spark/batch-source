// our class name must match our file name
public class Pizza{

    // defining instance variables
    private String crustType;
    private String sauceType;
    private boolean hasCheese;
    private int size;
    // previous instance variables will have the value of their type's default value
    // assigning toppings to an array of 3 null values
    private String[] toppings = new String[3];

    // static variable is shared across all of our Pizzas (and is accessible without any)
    private static int pizzasMade = 0;

    // no argument constructor 
    Pizza(){
        // providing values for each instance, when we create using this constructor
        crustType = "thin";
        sauceType = "red";
        hasCheese = true;
        size = 16;
        // increment static variable
        pizzasMade++;
    }

    // create a constructor taking values to set the instance's sauce and cheese
    Pizza(String sauceType, boolean hasCheese){
        this.sauceType = sauceType;
        this.hasCheese = hasCheese;
        pizzasMade++;
    }

    // can have multiple constructors taking different variables
    Pizza(String sauceType, boolean hasCheese, String[] toppings){
        this.sauceType = sauceType;
        this.hasCheese = hasCheese;
        if(toppings.length==3){
            this.toppings = toppings;
        }
        pizzasMade++;
    }

    // including our main method 
    public static void main(String[] args){
        Pizza p = new Pizza("white",false);
        p.crustType = "cheese stuffed";
        System.out.println(p.toString());
        Pizza p2 = new Pizza();
        System.out.println(p2.toString());
        // System.out.println(pizzasMade);
        // Pizza.resetCounter();
        // System.out.println(pizzasMade);
        // p2.setCrustType("thick");
        // p2.setSize(18);
        // System.out.println(p2.toString());
        // p2.setCrustType("cheese stuffed");
        // System.out.println(p2.toString());
        String[] arr = new String[3];

        Pizza p3 = new Pizza("bbq",true,new String[]{"mushrooms", null, null});
        System.out.println(p3.toString());
        p3.addTopping("spinach");
        p3.addTopping("onion");
        System.out.println(p3.toString());
        p3.removeTopping("onion");
        System.out.println(p3.toString());
        p3.removeTopping("tomato");


    }

    // converting our object to a readable string, describing the states of that object
    // this is an instance method, it will apply to each object specifically
    public String toString(){
        return "My Pizza: crustType="+crustType+", hasCheese="+hasCheese+", sauceType="+sauceType+", size="+size+", toppings="+printToppings();
    }

    // static method need not be invoked on an instance of the class, belongs to the class itself not an object
    private static void resetCounter(){
        pizzasMade = 0;
    }

    // our getters and setters are all instance methods, applying to the single instance they are invoked on
    public static int getPizzasMade(){
        return pizzasMade;
    }


    // getter methods return the instance variable of the object, so they are declared of that variable's type
    public String getCrustType(){
        // we could use the "this" keyword here but we don't need to (no risk of variable shadowing)
        return crustType;
    }

    // setter methods are void, as they don't return anything but they take a parameter of the type of the variable you are setting
    public void setCrustType(String crustType){
        // we can perform validation, allowing exactly how our data can be accessed and modified
        if("cheese stuffed".equals(crustType)||"thin".equals(crustType)){
            this.crustType = crustType;
        } else {
            System.out.println("Invalid crust");
        }
    }

    public String getSauceType(){
        return sauceType;
    }

    // we do use the "this" keyword with our setters to prevent variable shadowing (if we named our parameter something else we wouldn't need to)
    public void setSauceType(String sauceType){
        this.sauceType = sauceType;
    }

    public boolean getHasCheese(){
        return hasCheese;
    }

    public void setHasCheese(boolean hasCheese){
        this.hasCheese = hasCheese;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        if(size>6 && size<25){
            this.size = size;
        } else {
            System.out.println("invalid size");
        }
    }

    public String[] getToppings(){
        return toppings;
    }

    // in this method we iterate ove the toppings seeing if we have availability of a topping (if an index's value is null)
    // if that's the case we add the topping, and break out of the method with the return statement
    // otherwise we cannot add the topping and print the statement 
    public void addTopping(String newTopping){
        for(int i=0; i<toppings.length;i++){
            if(toppings[i] == null){
                toppings[i] = newTopping;
                return;
            }
        }
        System.out.println("too many toppings!");
    }

    // this method iterates over the array of toppings, checking for the topping passed in as a parameter
    // if the topping is in the array, the value in the array is set to null and the method completes with a return
    // otherwise the toppings remains the same and the statement below is printed
    public void removeTopping(String topping){
        for(int i=0; i<toppings.length;i++){
            if(topping.equals(toppings[i])){
                toppings[i] = null;
                return;
            }
        }
        System.out.println("topping not found");

    }
    
    // this method concatenates the toppings into one string to print nicely (doesn't include null values)
    public String printToppings(){
        String toppingsStr = "";
        for(int i=0;i<toppings.length;i++){
            if(toppings[i]!=null){
                toppingsStr+=toppings[i]+" ";
            }
        }
        return toppingsStr;
    }
}