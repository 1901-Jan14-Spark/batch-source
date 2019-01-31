public class Customer{

String name;
String item;
int price;
static String cashier;


Customer(){
    name="John";
    item="Movie";
    price=5;
}

Customer(String name, String item, int price){
    this.name = name;
        this.item = item;
        this.price=price;
}




public static void main(String[] args) {
    Customer customer = new Customer("Tom", "Toaster", 20);
    System.out.println(customer.toString());
    Customer c1 = new Customer("Max", "Guitar", 300);
    c1.getitem("Guitar");
    System.out.println(c1.toString());
    Customer c2 = new Customer("Jill", "Lamp", 30);
    c2.setname("Tony");
    System.out.println(c2.toString());
   
}

 



public void getname(String name){
    this.name = name;
}
public void setname(String name){
    this.name = name;
}

public void getitem(String item){
    this.item = item;
}
public void setitem(String item){
    this.item = item;
}
public void getprice(int price){
    this.price = price;
}
public void setprice(int price){
    this.price = price;
}





}