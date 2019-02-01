//part3
public class Customer{
    
    public static void main(String args[]){     
    Customer customer1 = new Customer("tom");
    Customer customer2 = new Customer("sam");
    Customer customer3 = new Customer("ram");
    Customer customer4 = new Customer("cam");
    Customer customer5 = new Customer("dom");
    
     System.out.println(customer1.getName());
     System.out.println(customer2.getName());
     System.out.println(customer3.getName());
     System.out.println(customer4.getName());
}
// Getter
public String getCustomer() {
    return Customer;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;
  }

}


