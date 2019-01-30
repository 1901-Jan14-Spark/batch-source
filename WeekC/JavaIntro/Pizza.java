public class Pizza{

    private String crustType;
    private String sauceType;
    private boolean hasCheese;
    private int size;

    private static int pizzasMade = 0;

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
        // System.out.println(pizzasMade);
        // Pizza.resetCounter();
        // System.out.println(pizzasMade);
        p2.setCrustType("thick");
        p2.setSize(18);
        System.out.println(p2.toString());
        p2.setCrustType("cheese stuffed");
        System.out.println(p2.toString());

    }

    // converting our object to a readable string, describing the states of that object
    // this is an instance method, it will apply to each object specifically
    public String toString(){
        return "My Pizza: crustType="+crustType+", hasCheese="+hasCheese+", sauceType="+sauceType+", size="+size;
    }

    private static void resetCounter(){
        pizzasMade = 0;
    }

    public static int getPizzasMade(){
        return pizzasMade;
    }

    public String getCrustType(){
        return crustType;
    }

    public void setCrustType(String crustType){
        if("cheese stuffed".equals(crustType)||"thin".equals(crustType)){
            this.crustType = crustType;
        } else {
            System.out.println("Invalid crust");
        }
    }

    public String getSauceType(){
        return sauceType;
    }

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


}