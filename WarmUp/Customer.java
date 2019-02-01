public class Customer{


    private String firstName;
    private String lastName;
    private int idNumber;
    private boolean  isRewardsMember;
    private double yearsRegistred;

    // I was going to try to create an array of the customers created
    // public static String[] customers;
    // public static int listOfCustomers = 0;


    Customer(){
        firstName = "Random";
        lastName = "Customer";
        idNumber = 352;
        isRewardsMember = false;
        yearsRegistred = 4.3;

    }

    Customer(String firstName, String lastName, int idNumber,boolean isRewardsMember, double yearsRegistred){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.isRewardsMember = isRewardsMember;
        this.yearsRegistred = yearsRegistred;
    }


    public static void main(String[] args){

        Customer cust1 = new Customer();
        System.out.println(cust1.printCustomer());
        System.out.println();
        cust1.setRewardsStatus(true);
        cust1.setIdNumber(202);
        System.out.println(cust1.printCustomer());
        System.out.println();
        Customer cust2 = new Customer("Skizzy", "Mars", 2006, true, 6.7);
        System.out.println(cust2.printCustomer()); 
        // addCustomerToList(cust1);


    }


    // Getter Setter Methods
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

    public int getIdNumber(){
        return idNumber;
    }

    public void setIdNumber(int idNumber){
        this.idNumber = idNumber;
    }

    public boolean getRewardsStatus(){
        return isRewardsMember;
    }

    public void setRewardsStatus(boolean isRewardsMember){
        this.isRewardsMember = isRewardsMember;
    }

    public double getYearsRegistered(){
        return yearsRegistred;
    }

    public void setYearsRegistered(double yearsRegistred){
        this.yearsRegistred = yearsRegistred;
    }

    // Print method to print the customer object as a string
    public String printCustomer(){
        // using '\n' within the contents of a string will create a new line for whatever follows.
        return "Customer: " + firstName + " " + lastName + " \nID: " + idNumber + "\nRewards Status: " + printRewardsStatus() + "\nYears a Member: " + yearsRegistred;
    }

    // evaluates the boolean value of the customer's reward status and returns an equivalent string
    public String printRewardsStatus(){
        String rewardStatus = "";
        if(isRewardsMember == true){
            rewardStatus = "Currently a registered member.";
        } else {
            rewardStatus = "Not a member";
        }
        return rewardStatus;
    }

    // This section was supposed to be the method to add each customer to an array of customers

    
    // public static void addCustomerToList(){
    //     String newCustomer;
    //     newCustomer = Customer();

    //     customers[listOfCustomers] = newCustomer;
    //     listOfCustomers++;

    //     System.out.println()


    //     System.out.println("You added " + newCust.firstName + " " + newCust.lastName + " to the list.");
    //     System.out.println("New List\n--------");
    //     for(int i = 0; i < customers.lenght; i++){
    //         System.out.println(customers[i].printCustomer());
    //     }
    // }


}