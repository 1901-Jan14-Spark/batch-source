public class Customer{
    private String firstName;
    private String lastName;
    private String customerID;
    private static int numOfCustomers = 0;

    Customer() {
        firstName = "";
        lastName = "";
        customerID = "";
        numOfCustomers++;
    }

    Customer(String firstName, String lastName, String id) {
        this.fname = fname;
        this.lname = lname;
        customerID = id;
        numOfCustomers++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return customerID;
    }

    public void setFirstName(String firstName) {
        firstName = firstNname;
    }

    public void setLastName(String lastName){
        lastName = lastName;
    }

    public void setID(String ID) {
        customerID = ID;
    }

    public int numbCustomers() {
        return numOfCustomers;
    }

    public static void main(String[] args) {
        
       Customer firstCustomer = new Customer("Tommy", "Marsden", "2009");
       Customer secondCustomer = new Customer("Tanya", "Marsden", "2010");
       Customer thirdCustomer = new Customer("Timmy", "Marsden", "2007");

       System.out.println("List of Customers");

       System.out.println("First Name:" + firstCustomer.getfirstName() + ", lastName:" + firstCustomer.getLastName() + ", customerID:" + firstCustomer.getID());

       System.out.println("First Name:" + secondCustomer.getFirstName() + ", lastName:" + secondCustomer.getLastName() + ", customerID:" + secondCustomer.getID());

       System.out.println("First Name:" + thirdCustomer.getFirstName() + ", lastName:" + thirdCustomer.getLastName() + ", customerID:" + thirdCustomer.getID());

       System.out.println("number of customers:" + thirdCustomer.numbCustomers());

       System.out.println("Change(s) to the first customer:");
       firstCustomer.setFirstName("Thomas");
       firstCustomer.setLastName("MacKinnon");
       firstCustomer.setID("2011");

       System.out.println("List of Customers");
       System.out.println("firstName:" + firstCustomer.getFirstName() + ", lastName:" + firstCustomer.getLastName() + ", customerID:" + firstCustomer.getID());

       System.out.println("firstName:" + secondCustomer.getFirstName() + ", lastName:" + secondCustomer.getLastName() + ", customerID:" + secondCustomer.getID());

       System.out.println("firstName:" + thirdCustomer.getFirstName() + ", lastName:" + thirdCustomer.getLastName() + ", customerID:" + thirdCustomer.getID());

       System.out.println("number of customers:" + thirdCustomer.numbCustomers());
    }
}