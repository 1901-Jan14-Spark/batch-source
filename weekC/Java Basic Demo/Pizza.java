public class Pizza {

    private String crushType;
    private String sauceType;
    private boolean hasCheese;
    private int size;
    private static int pizzaMade = 0;
    private static String[] topping;

    Pizza() {
        crushType = "thin";
        sauceType = "red";
        hasCheese = true;
        size = 16;
        pizzaMade++;
    }

    Pizza(String sauceType, boolean hasCheese) {
        this.sauceType = sauceType;
        this.hasCheese = hasCheese;
        pizzaMade++;
    }

    public static void main(String[] args) {
        Pizza p = new Pizza("red", true);
        p.crushType = "cheese stuffed";
        System.out.println(p.toString());
        Pizza p2 = new Pizza();
        System.out.println(p2.toString());
        // System.out.println(pizzaMade);
        // Pizza.resetCounter();
        // System.out.println(pizzaMade);
        p2.setCrushType("thick");
        p2.setSize(18);
        System.out.println(p2.toString());
        p2.setCrushType("cheese stuffed");
        System.out.println(p2.toString());
        Pizza[] p3 = new Pizza[3];
    }

    public String[] getTopping() {
        return getTopping();
    }

    public void setTopping(String[] topping){
        this.topping = topping;
    }

    public String toString() {
        return "My Pizza: crustType=" + crushType + ", hasCheese=" + hasCheese + ", sauseType=" + sauceType + ", size=" + size;
    }

    private static void resetCounter() {
        pizzaMade = 0;
    }

    public static int getPizzasMade() {
        return pizzaMade;
    }

    public String getCrushType() {
        return crushType;
    }

    public void setCrushType(String crushType) {
        if ("cheese stuffed".equals(crushType) || "thin".equals(crushType)) {
            this.crushType = crushType;
        } else {
            System.out.println("Invalid crust");
        }
    }

    public String getSauceType() {
        return sauceType;
    };

    public void setSauceType(String sauceType) {
        this.sauceType = sauceType;
    }

    public boolean getHasCheese() {
        return hasCheese;
    }

    public void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size > 6 && size < 25) {
            this.size = size;
        } else {
            System.out.println("Invalid size");
        }
    }



}
