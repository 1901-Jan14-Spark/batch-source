// Create a MyClass class
public class Customer {
    public String CustomerName;
    public String itemName;
    public double price;
    static int id;

   Customer() {
    CustomerName = "R kelly";
    itemName = "dvd";
    price = 39.9;
    id= 001;
    }
    Customer(String CustomerName, String itemName, double price, int id) {
      this.CustomerName = CustomerName;
      this.itemName = itemName;
      this.price = price;
      this.id = id;
  
  }

    public String getCustomerName(){
        return this.CustomerName;
    } 
    public String getItemName(){
      return this.itemName;
    }
    public double getPrice(){
      return this.price;
    }
    public void setCustomerName(String CustomerName) {
      this.CustomerName = CustomerName;
    }
   public void setItemName(String itemName) {
    this.itemName = itemName;
    }
   public void setPrice(double price) {
    this.price = price;
    } 
    
    public static void main(String[] args) {
      Customer Cstmr = new Customer();
      Customer NewCstmr = new Customer("joan carlos", "cookies", 3.29 ,005);
      System.out.println(NewCstmr.getItemName());
      System.out.println("bought by "+NewCstmr.getCustomerName());  
      Cstmr.setPrice (9.99);
      System.out.println(Cstmr.getItemName()+" On Sale,Sold for "+Cstmr.getPrice());  

    }
  }
  