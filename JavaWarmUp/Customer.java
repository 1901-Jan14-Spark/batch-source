public class Customer{

    static String RevGrocers;
    String name;
    String carName;
    int age;
    int groceryNum;


    public Customer(String name, int age, int groceryNum){
        this.name = name;
        this.age = age;
        this.groceryNum = groceryNum;
    }

    public Customer(String RevGrocers, String name, String carName, int age, int groceryNum){
        this.RevGrocers = RevGrocers;
        this.name = name;
        this.carName = carName;
        this.age = age;
        this.groceryNum = groceryNum;
    }

    static Customer secondCustomer = new Customer("RevGrocers", "Bob", "Honda", 70, 3);
    static Customer firstCustomer = new Customer("Vijay", 25, 10);
    static Customer thirdCustomer = new Customer("RevGrocers", "Billy", "Mustang", 50, 901);

    public static void main(String [] args){
        System.out.println(firstCustomer.toString());
        System.out.println(secondCustomer.toString());
        secondCustomer.setCarName("Volvo");
        firstCustomer.setAge(81);
        firstCustomer.setGroceryNum(2);
        secondCustomer.setGroceryNum(8);
        System.out.println(thirdCustomer.toString());
        System.out.println(thirdCustomer.getGroceryNum());
        System.out.println(secondCustomer.getAge());
        System.out.println(thirdCustomer.getCarName());
}

    public String toString(){
        return "Welcome to "+RevGrocers+ "! Hello "+name+", you are "+age+ " years old! You also have "+groceryNum+ " groceries. Buy more please.";
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCarName(){
        return carName;

    }

    public void setCarName(String carName){
        if("Honda".equals(carName) || "Audi".equals(carName) || "Tesla".equals(carName)){
        this.carName = carName;
        } else {
            System.out.println("HEY! "+name+ ", only Honda, Audi, and Tesla owners may shop here. Please come back when you are driving one of those vehicles. Sorry I don't make the rules.");
        }
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        int oldAge = 70;
        if(age > oldAge){
            System.out.println("HEY!!! "+name+ ", your age ("+age+") is creeping up there. Make sure to get some milk to keep those bones strong and healthy!");
        }
        this.age = age;
    }

    public int getGroceryNum(){
        return groceryNum;
        
    }

    
    public void setGroceryNum(int groceryNum){
        int minGroceryNum = 5;
        if (groceryNum < minGroceryNum){
            int addedGroceryNum = minGroceryNum - groceryNum;
            this.groceryNum = minGroceryNum;
            System.out.println("UH-OH. Tsk tsk "+name+", you didn't meet the minimum required amount of groceries to check out. We added "+addedGroceryNum+ " items to your cart to make sure you had at least "+minGroceryNum+" items!");
        } else {System.out.println(name+ " checked out with "+groceryNum+ " groceries.");
        }
        
    }

}