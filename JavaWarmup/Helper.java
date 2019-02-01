public class Helper{
    public static void main(String[] args){
        // Helper helper = new Helper();
        // helper.printNums();
        // helper.printUptoVal(15);
        // helper.printRange(12, 30);
        // System.out.println(helper.printString("hello", 5));
        printNums();
        printUptoVal(15);
        printRange(12, 30);
        System.out.println(printString("hello", 5));
    }
    Helper(){
        
    }
    public static void printNums(){
        for(int i = 1; i <= 10 ; i++){
            System.out.println(i);
        }
    }
    public static void printUptoVal(int x){
        for(int i=1; i<=x; i++){
            System.out.println(i);
        }
    }
    public static void printRange(int x, int y){
        if( x < y){
            for(int i = x; i<= y; i++){
                System.out.println(i);
            }
        }
        else{
            for(int i = y; i<= x; i++){
                System.out.println(i);
            }
        }
    }
    public static String printString(String string, int times){
        String finalString = "";
        for(int i =0; i< times; i++){
            finalString += string;
        }
        return finalString;
    }

}