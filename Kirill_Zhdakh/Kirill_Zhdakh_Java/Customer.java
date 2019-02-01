public class Customer{
    int id;
    String username;
    boolean isMale;
    static int customerCount;

    public String toString()
    {
        return new String("ID: " + this.id + " Username: " + this.username + " Male? " + this.isMale + " Total customers: " + customerCount);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isIsMale() {
        return this.isMale;
    }

    public boolean getIsMale() {
        return this.isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }
    Customer()
    {
        id = 0;
        username = "blank";
        isMale = true;
        customerCount++;
    }
    Customer(int id, String username, boolean isMale)
    {
        this.id = id;
        this.username = username;
        this.isMale = isMale;
        customerCount++;
    }
    public static void main(String[] args)
    {
        Customer c = new Customer();
        c.setId(213123);
        c.setIsMale(false);
        c.setUsername("uhhhbye");
        Customer c2 = new Customer(1114, "freddie223", true);
        System.out.println(c.toString());
        System.out.println(c2.toString());
    }
}