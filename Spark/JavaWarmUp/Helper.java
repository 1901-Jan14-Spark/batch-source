public class Helper{
    public static void main(String[] args){
        //Helper help = new Helper();
        //help.printNums();
        printNums();
        //help.printUpToVal(5);
        printUpToVal(5);
        //help.printRange(30,40);
        printRange(30, 40);
        //help.printString("Ha", 10);
        printString("Ha", 10);
    }
    public static void printNums(){
        for(int i = 1; i<11; i++)
            System.out.println(i);
    }
    public static void printUpToVal(int up2){
        for(int i= 1; i<up2; i++)
            System.out.println(i);
    }
    public static void printRange(int low, int high){
        for(int i = low; i <= high; i++)
            System.out.println(i);
    }
    public static void printString(String input, int num){
        String output = "";
        for(int i = 0; i<num; i++)
            output+= input;
        System.out.println(output);
    }
}