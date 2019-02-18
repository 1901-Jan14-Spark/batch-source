import sun.launcher.resources.launcher;

public class Customer {
    private String fName;
    private String lName;
    private String purchase;

    static int custCount = 0;
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer("John", "Smith", "Pepsi");
        Customer c3 = new Customer("Jake", "Statefarms", "Car");
        Customer c4 = new Customer("Lionel", "Messi", "soccer boot");
        System.out.println(c1.getfName() + " " + c1.getlName() + " purchased: " + c1.getPurch());
        c1.setfName("Dat");
        c1.setlName("Tran");
        c1.setPurch("Soda");
        System.out.println(c1.getfName() + " " + c1.getlName() + " purchased: " + c1.getPurch());     
        System.out.println(c2.getfName() + " " + c2.getlName() + " purchased: " + c2.getPurch());
        c2.setPurch("Chocolate");
        System.out.println(c2.getfName() + " " + c2.getlName() + " purchased: " + c2.getPurch());  
        System.out.println(c3.getfName() + " " + c3.getlName() + " purchased: " + c3.getPurch());  
        c3.setlName("Martinez");
        System.out.println(c3.getfName() + " " + c3.getlName() + " purchased: " + c3.getPurch());  
        System.out.println(c4.getfName() + " " + c4.getlName() + " purchased: " + c4.getPurch());  
        System.out.println("Customer count: " + custCount);
    }

    Customer() {
        this.fName = "John";
        this.lName = "Doe";
        this.purchase = "Kit Kat";
        custCount++;
    }

    Customer(String fName, String lName, String purchase) {
        this.fName = fName;
        this.lName = lName;
        this.purchase = purchase;
        custCount++;
    }
    
    public String getfName(){
        return fName;
    }

    public void setfName(String name){
        fName = name;
    }

    public String getlName(){
        return lName;
    }

    public void setlName(String name){
        lName = name;
    }

    public String getPurch(){
        return purchase;
    }

    public void setPurch(String item){
        purchase = item;
    }

}