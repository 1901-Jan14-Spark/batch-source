public class Customer{
    private String name;
    private String phone;
    private String email;
    private static int numCust = 0;
    Customer(){
        name = "John Doe"+ numCust;
        phone = "unknown";
        email = "unknown";
        numCust++;
    }
    Customer(String cName, String cPhone, String cEmail){
        name = cName;
        phone = cPhone;
        email = cEmail;
        numCust++;
    }
    public void changeName(String nName){
        this.name = nName;
    }
    public String getName(){
        return this.name;
    }
    public void changePhone(String nPhone){
        this.phone = nPhone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void changeEmail(String nEmail){
        this.email = nEmail;
    }
    public String getEmail(){
        return this.email;
    }
    public void resetNumCust(){
        numCust = 0;
    }
    public int getNumCust(){
        return numCust;
    }
    public void printCust(){
        System.out.println("Customer name: "+this.name);
        System.out.println("Customer phone: "+this.phone);
        System.out.println("Customer email: "+this.email);
        //System.out.println("Customer count: "+ numCust); kinda redundant
    }
    public static void main(String[] args){
        Customer anon = new Customer();
        Customer Leroy = new Customer("Leroy Brown", "3165442020","theBaddestMan@theWholeDangTown.com");
        Customer Kanye = new Customer("Kanye East", "9879588080", "kanyeLovesKanye@Kanye.com");
        Customer Peyton = new Customer("Peyton Isacoolguy", "9688468448", "TriForcesAreCool2@IamGettingCarriedAway.com");
        Customer anon5 = new Customer();
        Customer anon6 = new Customer();
        Customer anon7 = new Customer();
        anon.printCust();
        anon.changeEmail("iDontWantToRegister@stopAsking.com");
        anon.printCust();
        System.out.println("Getting Leroy's email..... "+ Leroy.getEmail());
        Kanye.printCust();
        System.out.println("Kanye wants to change his name...");
        Kanye.changeName("Kanye West");
        Kanye.printCust();
        System.out.println(Peyton.getName());
        anon5.printCust();
        System.out.println("Customer added new phone number:");
        anon5.changePhone("2002008080");
        anon5.printCust();
        System.out.println("What is Peyton's phone number? "+ Peyton.getPhone());
        System.out.println("Number of customers..."+anon6.getNumCust());
        anon7.resetNumCust();
        System.out.println("System crashed... number of customers : "+anon.getNumCust());



    }


}