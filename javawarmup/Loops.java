public class Loops {
    public static void main(String[] args) {

        // Ex 1.
        printHello();

        // Ex 2.
        int x = 13;
        isGreaterThanTen(x);

        // Ex 3.
        printGreetingsFor();

        // Ex 4.
        printGreetingsWhile();

        // Ex 5.
        printGreetingsDoWhile();

        // Ex 6.
        colorChecker("Green");

    }

    public static void printHello() {
        System.out.println("hello world");
    }

    public static void isGreaterThanTen(int x) {
        if (x > 10) {
            System.out.println("X is greater than 10.");
        } else {
            System.out.println("X is equal or smaller than 10.");
        }
    }

    public static void printGreetingsFor() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Greetings.");
        }
    }

    public static void printGreetingsWhile() {
        int x = 0;
        while (x < 4) {
            System.out.println("Greetings.");
            x++;
        }
    }

    public static void printGreetingsDoWhile() {
        int x = 1;
        do {
            System.out.println("Greetings.");
            x++;
        } while (x < 4);
    }

    public static void colorChecker(String color) {
        switch (color.toLowerCase()) {
        case "green":
            System.out.println(color + " is made of blue and yellow.");
            break;
        case "purple":
            System.out.println(color + " is made of blue and red.");
            break;
        case "orange":
            System.out.println(color + " is made of red and yellow.");
            break;
        default:
            System.out.println("color unknown");
            break;
        }
    }
}
