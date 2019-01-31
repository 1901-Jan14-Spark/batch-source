public class Helper{
    
    public static void main(String [] args){ 
        Helper helper = new Helper(); 
        helper.printNums();
        helper.printUpToVal(5);
        helper.printRange(2, 7);
        helper.printString("hello", 5);
        Helper.printNums();
        Helper.printUpToVal(8);
        Helper.printRange(1, 8);
        Helper.printString("yaaay",4);
    }

    public static void printNums(){
        for(int i=0; i<=10; i++){
            System.out.println(i);
        }
    }

    public static void printUpToVal(int number){
        for(int j=1; j<=number; j++){
            System.out.println(j);
        }
    }

    public static void printRange(int x, int y){
        
        for (int j = x; x<y; x++){
            System.out.println(x);
        }
    }

    static String ourstring = "";
    public static void printString(String inputstring, int concatnum){
        for (int m=0; m < concatnum; m++){
            ourstring += inputstring;
        }
        System.out.println(ourstring);

    }
        
}

