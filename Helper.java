public class Helper{

    public static void printNums() {
        for(int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public static void printUpToVal(int upTo) {
        for(int i = 1; i <= upTo; i++) {
            System.out.println(i);
        }
    }

    public static void printRange(int upTo2, int upTo3) {
        for(int i = upTo2; i <= upTo3; i++) {
            System.out.println(i);
        }
    }

    public static String printString(String spaceHolder, int number) {
        String newSpaceHolder = "";
        for(int i = 0; i < number; i++) {
            newSpaceHolder = newSpaceHolder + spaceHolder;
        }
        return newSpaceHolder;
    }

    public static void main(String[] args) {
        printNums();
        printUpToVal(11);
        printRange(12, 24);
        System.out.println(printString("Tommy", 28));
    }
}