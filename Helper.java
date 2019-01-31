public class Helper {

    public static void main(String[] args) {
        printNums();
        printUpToVal(7);
        printRange(1,3);
        byte x = 7;
        printString("seven", x);
    }

    public static void printNums(){
        for(int i=1; i<=10; i++){
            System.out.println(i);
        }
    }

    public static void printUpToVal(int num){
        for (int i=1; i<=num; i++){
            System.out.println(i);
        }
    }

    public static void printRange(int a, int b){
        for (int start = a; start <= b; start++){
            System.out.println(start);
        }
    }

    public static void printString(String word, byte quant){
        String x = "";
        for (byte i=0; i<=quant; i++){
            System.out.print(word);
        }
    }
}