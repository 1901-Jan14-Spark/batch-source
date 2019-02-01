public class Customer{

private String cName;
private boolean goodCustomer;
private boolean regular;
private String pName;
private boolean hasPet;
private boolean goodOwner;
private String dogType; 
private static int newCustomers = 0;
private static int newPets = 0;


Customer(){
    cName = "";
    goodCustomer=false;
    regular=false;
    hasPet=false;
    newCustomers++;

}

Customer(String cName, boolean goodCustomer, boolean regular, String pName, String dogType){
    this.cName = cName;
    this.goodCustomer = goodCustomer;
    this.regular = regular;
    this.pName = pName;
    this.dogType = dogType;
    newCustomers++;
}

Customer(boolean hasPet, boolean goodOwner){
    this.hasPet = hasPet;
    this.goodOwner = goodOwner;
    newCustomers++;
    if (this.hasPet == true){
        newPets++;
    }
}
//  public void customerPet(){
//     pName = "Lucky";
//     dogType = "Lab";
//     newPet++;
// }

// Customer(String cName, boolean goodCustomer, boolean regular){
//     this.cName = cName;
//     this.goodCustomer = goodCustomer;
//     this.regular = regular;

// }
// public void customerPet(String pName, String dogType){
//     this.pName = pName;
//     this.dogType = dogType;
// }

// Customer(String cName, boolean goodCustomer, boolean regular){

// }

// public void customerPet(String pName, String dogType){

// }



public static void main(String[] args){
Customer c = new Customer();
c.cName = "louse";
System.out.println(c.cName);
Customer c2 = new Customer(true, true);
Customer c3 = new Customer("Mike", true, true, "Fluffy","Lab");
System.out.println(c2.hasPet);
System.out.println(newCustomers);
System.out.println()
//Instance Method
System.out.println(c.toString());
System.out.println(c2.toString());
System.out.println(c3.toString());

//getNewPets();


}
public static int getNewCustomers(){
    return newCustomers;
}

public static int getNewPets(){
    return newPets;
}

public String getCustomerName(){
return this.cName;
}

public void setCustomerName(String cName){
 this.cName= cName;
}

public boolean getGoodCustomer(){
   return this.goodCustomer;
}

public void setGoodCustomer(boolean goodCustomer){
    this.goodCustomer = goodCustomer;
}

public boolean GetRegular(){
    return this.regular;
}

public void setRegular(boolean regular){
    this.regular = regular;
}

public String GetPName(){
    return this.pName;
}

public void setPName(String pName){
    this.pName = pName;
}

public boolean getHasPet(){
    return hasPet;
}

public void setHasPet(boolean hasPet){
    this.hasPet = hasPet;
}

public String getDogType(){
    return this.dogType;
}

public void setDogType(String dogType){
    this.dogType = dogType;
}



///Instance Method
public String toString(){
    return "Customer Name: "+ cName+ "Customer is a Good customer: " + goodCustomer + ". This Customer has a pet: "+ hasPet;
}

}