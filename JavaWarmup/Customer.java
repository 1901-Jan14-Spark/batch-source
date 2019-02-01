public class Customer{
    private String firstName;
    private String lastName;
    private static boolean isHuman;
    private int age;
    private String bDay;
    public static void main(String[] args){
        Customer jeff = new Customer("Jeff", "Jefferson");
        Customer duke = new Customer("Duke", "The Dog");
        // Customer john = new Customer("John", "Doe");
        //print firstname, and change
        System.out.println(jeff.getFirstName());
        jeff.setFirstName("Bill");
        System.out.println(jeff.getFirstName());

        //print and change last name
        System.out.println(jeff.getLastName());
        jeff.setLastName("Young");
        System.out.println(jeff.getLastName());

        //Set and check if human
        System.out.println(jeff.getIsHuman());
        System.out.println(duke.getIsHuman());
        //will change all customers isHuman to true
        jeff.setIsHuman();
        System.out.println(jeff.getIsHuman());
        System.out.println(duke.getIsHuman());

        //assign age and print
        jeff.setAge(27);
        System.out.println(jeff.getAge());

        //Assign birthday and print out
        jeff.setBDay("1992-02-20");
        System.out.println(jeff.getBDay());
    }
    Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        isHuman = false;
        age = 0;
        bDay = "";
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public boolean getIsHuman(){
        return isHuman;
    }
    public void setIsHuman(){
        isHuman = true;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getBDay(){
        return bDay;
    }
    public void setBDay(String bDay){
        this.bDay = bDay;
    }
}