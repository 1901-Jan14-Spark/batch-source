

public class JavaIntro{

  

public static void main(String[] args){
    //1
    System.out.println("Hellow World");

   


    //2 
     int x = 3;
     if  ( x > 10  ){
        System.out.println("x is greater than 10 ");  
     } else{

        System.out.println("x is less than or equal to 10 "); 

     }

       
      //3  questionsssss why not x var??
       for (int y = 0; y < 4; y++ ){
        System.out.println("greetings "); 
             
       }

       System.out.println("\n Using while... ");


       //4  
        int z = 0;
        while( z < 4){
          System.out.println("greetings ");
           

              z++;

        }
       

        System.out.println("\n Using do while... ");

               int i = 0;
        //5
         do{


            System.out.println("greetings ");
                 
             i++;

         } while(i < 4 );




          //6 
          String color ="" ;
          switch (color) {

            case "green": System.out.println("blue and yellow");  break;

            case "purple": System.out.println("blue and red");break;

            case "orange": System.out.println("yellow and red"); break;

            default: System.out.println("color unknown"); break;





           




          }


         //Part 2
           //2.1
          //Helper helperInstance = new Helper();
         
           //2.2
          Helper.printNums();

          //2.3
          Helper.printUpToVal(13);


          
          
          

            //2.4
         Helper.printRange(10, 24);


            //2.5
         
         System.out.println(Helper.printString("catz!", 4));


            //2.6 Try making the methods 
            //from 2-5 static. Invoke them without using an instance of the helper class.
     
          
            
          //part 3
           Customer defaultCustomerObj = new Customer();
           Customer customer1 = new Customer();
           
         
           defaultCustomerObj.setFirstName("John");
           defaultCustomerObj.setLastName("Appleseed");
           defaultCustomerObj.setCId(2345);
           System.out.print( defaultCustomerObj.getFirstName()+ "  " + defaultCustomerObj.getLastName()
           
           + "  " + defaultCustomerObj.getCId());
           System.out.println("\n" + Customer.noCustomers);







          // System.out.print(Customer.getFirstName());
               


          // customer1









   




}








}