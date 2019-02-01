public class Customer{
    String firstName;
    String lastName;
    int age;
    private int custiesmade=0;
    public static void main(String[] args){
    
    }
     Customer(){
         firstName = "Rodger";
         age = 58;
         lastName = "Dodger";
        custiesmade++;
        }
    Customer(String firstName, int age){
        lastName = "Darko";
        age = 24;

    }
        public  String getfirstName(){
            return firstName;
        }
        public void setfirstName(String firstName){
            this.firstName = "Donnie";

        }
        public int getcustiesmade(){
            return custiesmade;
               
        }
        
}
