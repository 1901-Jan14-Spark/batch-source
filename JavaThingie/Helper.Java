   import java.util.Scanner;
//1
public class Helper{
    Helper(){

    }   
   
        public static void  printNums(){
        for(int i= 1; i <=10; i++){
        System.out.println(i);
    }
} 

    public static void stringPrint(String user, int numT){
        String word = "";
        for (int i = 0; i < numT; i++){
            word += user;
        }
        System.out.println(word);
    }

    public static void main(String[] args) {
//2
        // Helper num1= new Helper();
        // num1.printNums();

        printNums();
  
      

//3         
        

        Scanner printUpToVal= new Scanner(System.in);
           System.out.println("Please enter a Number ^.^");
        int a;
        a=printUpToVal.nextInt();

           for(int i= 1; i <= a; i++){
            System.out.println(i);
        }

      
 //4   
        Scanner printRange= new Scanner(System.in);  
        System.out.println("Please Enter 2 Numbers ^.^");

        int n1, n2;
        n1= printRange.nextInt();
        n2=printRange.nextInt();

        for(int i = n1; i <= n2; i++){
            System.out.println(i);
        }
//5
        // Helper num5= new Helper();
        //     num5.stringPrint("pink", 3);
            stringPrint("step6",4);

// 6

        
    }
}