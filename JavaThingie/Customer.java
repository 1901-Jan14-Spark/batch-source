public class Customer{
   private String name;
   private static int idNum;
   private int budget;
//    we do not have to set nor get this
   private int idGen=1;
   
    public Customer(){
      String name;
      int budget;  
      this.idNum=idGen;
      idGen++;
    }

    public Customer(String name, int budget) {
    
           this.name = name;

        // idGeneration
       this.idNum=idGen;
       idGen++;

       this.budget=budget;

    }
// Getter Funcs return a value
    public String getName(){
        return name;
    }

    public int getidNum(){
        return idNum;
    }

   public int getBudget(){
        return budget;
    }
// Setter Functions take a value
    public void setName(String setName){
        name=setName;
    }

    public void setidNum(){
        // This generates new id thus is not a standard setter
        idNum=idGen; //for procedurally generating new and unique id's
        idGen++;
    }

    public void setbudget(int setBudget){
        budget=setBudget;
    }

    public static void main(String[] args) {
        
        Customer raven = new Customer("raven", 100);
        
        raven.setName("Raven"); //Raven insisted her name be capitalized
        raven.getName();

        raven.setidNum();
        raven.getidNum();

        raven.getBudget();
            System.out.println(raven.name);
            System.out.println(raven.budget);
            System.out.println(raven.idGen);

        Customer crow = new Customer("crow", 10);

        crow.setName("Crow"); //Crow spent 10 cents for a capital
        crow.getName();

        crow.setidNum();
        crow.getidNum();

        crow.getBudget();

        System.out.println(crow.name);
        System.out.println(crow.budget);
        System.out.println(raven.idGen);

    }
}