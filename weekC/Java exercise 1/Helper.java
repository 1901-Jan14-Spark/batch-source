import com.sun.org.apache.xpath.internal.SourceTree;

public class Helper {

    public static void main(String[] args) {
        // printNums();
        // printUpToVal();
        // printRange(10, 3);
        // printString("hello", 5);
    }


    public static void printNums() {
        for(int i = 1; i < 11; i++) {
            System.out.println(i);
        }
    }

    public static void printUpToVal(int num) {
        for(int i = 1; i < num; i++) {
            System.out.println(i);
        }
    }

    public static void printRange(int num1, int num2) {
        if(num1 < num2) {
            for(int i = num1; i < num2; i++) {
                System.out.println(i);
            }
        } else {
            for(int i = num2; i < num1; i++) {
                System.out.println(i);
            }
        }
    }

    public static void printString(String str, int num) {
        String myStr = "";
        for(int i = 0; i < num; i++) {
            myStr += str;
        }
        System.out.println(myStr);
    }

}