public class Customer {
    public static void main(String[] args) {
        Customer Mike = new Customer(36, "Mike", false);
        Customer Doug = new Customer();
        Doug.setAge(15);
        Doug.setAwake(true);
        Doug.setName("Doug");

        System.out.println(Mike.toString());
        System.out.println(Doug);
    }

    private int age;
    private String name;
    private boolean isAwake;
    private static int numberOfCustomers = 0;

    Customer() {
        age = 0;
        name = "Default";
        isAwake = false;
        numberOfCustomers++;
    }

    Customer(int age, String name, boolean isAwake) {
        this.age = age;
        this.name = name;
        this.isAwake = isAwake;
        numberOfCustomers++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAwake() {
        return isAwake;
    }

    public void setAwake(boolean isAwake) {
        this.isAwake = isAwake;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    private void setNumberOfCustomers(int numberOfCustomers) {
        Customer.numberOfCustomers = numberOfCustomers;
    }

    public String toString() {
        String description = "Customer's name: " + name + "\nCustomer's age: " + age + "\nCustomer is awake: " + isAwake
                + "\nNumber of customers: " + numberOfCustomers;
        return description;
    }
}
