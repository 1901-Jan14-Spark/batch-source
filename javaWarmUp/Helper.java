public class Helper{
    //instance methods
    //1.
    Helper(){
        System.out.println("Instance method created.");
    }

    //2.
    public void printNums(){
        for(int i=1; i<=10; i++){
            System.out.println(i);
        }
    }

    //3.
    public void printUpToVal(int stopVal){
        for(int i=1; i<=stopVal; i++){
            System.out.println(i);
        }
    }

    //4.
    public void printRange(int startVal, int endVal){
        for(int i=startVal; i<=endVal; i++){
            System.out.println(i);
        }
    }

    //5.
    public String printString(String msg, int repeat){
        String output = "";
        for(int i=0; i<repeat; i++){
            output = output + msg;
        }
        return output;
    }

    //static methods
    //6.
    public static void staticPrintNums(){
        for(int i=1; i<=10; i++){
            System.out.println(i);
        }
    }

    //7.
    public static void staticPrintUpToVal(int stopVal){
        for(int i=1; i<=stopVal; i++){
            System.out.println(i);
        }
    }

    //8.
    public static void staticPrintRange(int startVal, int endVal){
        for(int i=startVal; i<=endVal; i++){
            System.out.println(i);
        }
    }

    //9.
    public static String staticPrintString(String msg, int repeat){
        String output = "";
        for(int i=0; i<repeat; i++){
            output = output + msg;
        }
        return output;
    }

    public static void main(String[] args){
        Helper h = new Helper();//1
        System.out.println();
        h.printNums();//2
        System.out.println();
        h.printUpToVal(4);//3
        System.out.println();
        h.printRange(9, 17);//4
        System.out.println();
        System.out.println(h.printString("hello", 6));//5
        System.out.println();
        System.out.println("Static methods:");
        staticPrintNums();//6
        System.out.println();
        staticPrintUpToVal(7);//7
        System.out.println();
        staticPrintRange(3, 11);//8
        System.out.println();
        System.out.println(staticPrintString("yay", 3));
    }
}