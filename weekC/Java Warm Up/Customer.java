public class Customer{
  private static String firstName;
  private static String lastName;
  private int age;

  Customer(){
    firstName = "Alfonzo";
    lastName = "Shimothy";
    age = 600;
  }

  Customer(String first, String last, int age){
    firstName = first;
    lastName = last;
    this.age = age;
  }

  public String getFirstName(){
    return this.firstName;
  }
  public void setFirstName(String newName){
    this.firstName = newName;
  }

  public String getLastName(){
    return this.lastName;
  }
  public void setLastName(String newName){
    this.lastName = newName;
  }

  public int getAge(){
    return this.age;
  }
  public void setAge(int newAge){
    this.age = newAge;
  }

  public static void main(String[] args){
    Customer myself = new Customer();
    System.out.println(myself.getFirstName());
    myself.setLastName("HAHAHA");
    System.out.println(myself.getLastName());
    Customer ben = new Customer("Ben", "Jamin", 25);
    System.out.println(ben.getLastName());
    ben.setAge(300);
    System.out.println(ben.getAge());

  }

}
