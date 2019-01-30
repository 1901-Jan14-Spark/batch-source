public class Helper{

    public static void printNums(){
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }
    }

    public static void printUpToVal(int val){
        for(int i = 1; i <= val; i++){
            System.out.println(i);
        }
    }

    public static void printRange(int val, int val2){
        for(int i = val; i <= val2; i++){
            System.out.println(i);
        }
    }

    public static String printString(String word, int val){
        String newWord = "";
        for(int i = 0; i < val; i++){
            newWord = newWord + word;
        }
        return newWord;
    }

    public static void main(String[] args){
        printNums();
        printUpToVal(5);
        printRange(7, 14);
        System.out.println(printString("bob", 5));
    }
}