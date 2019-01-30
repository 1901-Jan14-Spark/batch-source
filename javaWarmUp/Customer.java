public class Customer{
    private String fname;
    private String lname;
    private String customerID;
    private static int numOfCustomers = 0;
    Customer(){
        fname = "";
        lname = "";
        customerID = "";
        numOfCustomers++;
    }

    Customer(String fname, String lname, String id){
        this.fname = fname;
        this.lname = lname;
        customerID = id;
        numOfCustomers++;
    }

    public String getFname(){
        return fname;
    }

    public String getLname(){
        return lname;
    }

    public String getID(){
        return customerID;
    }

    public void setFirstName(String Fname){
        fname = Fname;
    }

    public void setLastName(String Lname){
        lname = Lname;
    }

    public void setID(String ID){
        customerID = ID;
    }

    public int numbCustomers()
    {
        return numOfCustomers;
    }
    public static void main(String[] args){
       Customer custA = new Customer("Bob", "Bobby", "3245");
       Customer custB = new Customer("Fred", "Burger", "5731");
       Customer custC = new Customer("Lolipop", "Guild", "8943");
       //Customer customers = new Customer[]{custA, custB, custC};
       System.out.println("List of Customers");
       System.out.println("firstName:" + custA.getFname() + ", lastName:" + custA.getLname() + ", customerID:" + custA.getID());
       System.out.println("firstName:" + custB.getFname() + ", lastName:" + custB.getLname() + ", customerID:" + custB.getID());
       System.out.println("firstName:" + custC.getFname() + ", lastName:" + custC.getLname() + ", customerID:" + custC.getID());
       System.out.println("number of customers:" + custC.numbCustomers());
       System.out.println("change to customer A");
       custA.setFirstName("Billy");
       custA.setLastName("Bangkok");
       custA.setID("4358");
       System.out.println("List of Customers");
       System.out.println("firstName:" + custA.getFname() + ", lastName:" + custA.getLname() + ", customerID:" + custA.getID());
       System.out.println("firstName:" + custB.getFname() + ", lastName:" + custB.getLname() + ", customerID:" + custB.getID());
       System.out.println("firstName:" + custC.getFname() + ", lastName:" + custC.getLname() + ", customerID:" + custC.getID());
       System.out.println("number of customers:" + custC.numbCustomers());
    }
}