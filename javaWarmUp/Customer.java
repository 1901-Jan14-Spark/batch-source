public class Customer{
    private String firstName;
    private String lastName;
    private String purchase;

    static int custCount = 0;

    Customer(){
        this.firstName = "John";
        this.lastName = "Doe";
        this.purchase = "chips";
        custCount++;
    }

    Customer(String firstName, String lastName, String purchase){
        this.firstName = firstName;
        this.lastName = lastName;
        this.purchase = purchase;
        custCount++;
    }

    public String getFirst(){
        return firstName;
    }

    public void setFirst(String name){
        firstName = name;
    }

    public String getLast(){
        return lastName;
    }

    public void setLast(String name){
        lastName = name;
    }

    public String getPurch(){
        return purchase;
    }

    public void setPurch(String item){
        purchase = item;
    }

    public static void main(String[] args){
        Customer c1 = new Customer();
        Customer c2 = new Customer("Brad", "Smith", "Batteries");
        Customer c3 = new Customer("Jimmy", "Neutron", "bolts");
        Customer c4 = new Customer("Sally", "Tenn", "Books");
        System.out.println(c1.getFirst() + " " + c1.getLast() + " purchased: " + c1.getPurch());
        c1.setFirst("restuko");
        c1.setLast("shimura");
        c1.setPurch("Soda");
        System.out.println(c1.getFirst() + " " + c1.getLast() + " purchased: " + c1.getPurch());     
        System.out.println(c2.getFirst() + " " + c2.getLast() + " purchased: " + c2.getPurch());
        c2.setPurch("Milk");
        System.out.println(c2.getFirst() + " " + c2.getLast() + " purchased: " + c2.getPurch());  
        System.out.println(c3.getFirst() + " " + c3.getLast() + " purchased: " + c3.getPurch());  
        c3.setLast("Southhal");
        System.out.println(c3.getFirst() + " " + c3.getLast() + " purchased: " + c3.getPurch());  
        System.out.println(c4.getFirst() + " " + c4.getLast() + " purchased: " + c4.getPurch());  
        System.out.println("Customer count: " + custCount);
    }
}