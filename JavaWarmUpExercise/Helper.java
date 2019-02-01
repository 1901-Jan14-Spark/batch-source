public class Helper{


    static void  printNums(){
    System.out.println("\n printNums....");
    for (int y = 1; y < 11; y++ ){
        System.out.println(y); 
             
       }






} 









static void printUpToVal( int val){

   int x = 1;
   System.out.println("\n printUpToVal...."); 
    while (x <= val ){
        System.out.println(x); 
             

        x++;
       }


       

    
}


static void printRange( int val, int val2 ){

       
    System.out.println("\n printRange...."); 
     while (val <= val2 ){
         System.out.println(val); 
              
 
         val++;
        }
    }




    public static  String printString (String stringMultiply, int times){

    String sContainer="";
    int x = 0;
    System.out.println("\n printString...."); 
     while (x < times ){
              
         sContainer += stringMultiply;
 
         x++;
        }
 

         return sContainer; 


  }



}