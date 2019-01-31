public class Customer{

    public static void main(String[] args){
        Customer John = new Customer("John Lennin", 40, true);
        
        Customer Yoko = new Customer();
        Yoko.setAge(85);
        Yoko.setName("Yoko");
        Yoko.setisRich(false);
        
        System.out.println(John);
        System.out.println(Yoko);
    }

    private int age;
    private String name;
    private boolean isRich;
    private static String race;

    Customer (){
        age = 0;
        name = "Default";
        isRich = true;
        race = "Human";
    }

    Customer (String name, int age, boolean isRich) {
        this.name = name;
        this.age = age;
        this.race = race;
        this.isRich = isRich;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int setAge){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getRace(){
        return race;
    }

    public void setRace(String race){
        this.race = race;
    }

    public boolean getisRich(){
        return isRich;
    }

    public void setisRich(boolean isRich){
        this.isRich = isRich;
    }



}