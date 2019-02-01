public class Helper {

    //private Helper() {}
    public static void main(String[] args) {
        printNums();
        System.out.println();
        printUpToVal(6);
        System.out.println();
        printUpToVal(2,9);
        System.out.println();
        System.out.print(printString("hello",5));

     }

    public static void printNums() 
        {
        for(int i=1 ; i<=10 ; i++){
            System.out.println(i);}
        }

    public static void printUpToVal(int n)
        {for(int i=1 ; i<=n ; i++){
            System.out.println(i);}
        }
        
        
    public static void printUpToVal(int n,int m)
        {for(int i=n ; i<=m ; i++){
            System.out.println(i);}
        }
        

   public static String printString(String word, int number){
       String helloExt="";
        for(int i=0 ; i<number ; i++){
            helloExt += word;
        }
        return helloExt;
    }
   
        
 }
    

