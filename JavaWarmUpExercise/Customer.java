public class Customer{

    private String firstName;
    private String lastName;
   private double cId;
    static double noCustomers = 4000;



public Customer(){

    this.firstName = "default first name entry";
     
    this.lastName = "default last name entry";
    this.cId = 0000;


}

public Customer( double id, String fname, String lname ){

     this.firstName = fname;
     
     this.lastName = lname;
     this.cId = id;


}


 public String getFirstName(){



return firstName;


 };
    
   public String getLastName(){



 return lastName;


    }

    public double getCId(){

 return cId;


    }
    
    public void setFirstName(String fname){

     this.firstName = fname;

    }
    public void  setLastName(String lname){

           this.lastName = lname;
  
    }
    public void  setCId(double idN ){
        this.cId = idN;

    }
    


}