public class Helper {

    public static void main(String[] args) {
        Helper myHelper = new Helper();
        printNums();
        printUpToVal(3);
        printRange(1, 3);
        printString("Hello", 5);
    }

    public static void printNums() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public static void printUpToVal(int max) {
        for (int i = 1; i <= max; i++) {
            System.out.println(i);
        }
    }

    public static void printRange(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }

    public static void printString(String string, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.print(string);
        }
    }
}
