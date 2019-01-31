public class Loops {
    public static void main(String[] args) {
        System.out.println("Hello World!"); 

        int x = 7; 
        if (x > 10) {
            System.out.println("x is greater than 10");
        } else {
            System.out.println("x is equal to or less than 10");
        }

        for (int i=0; i<4; i++) {
            System.out.println("Greetings!");
        }

        int i =0;
        while (i<4) {
            System.out.println("Greetings!");
            i++;
        }
        
        do {
            System.out.println("Greetings!");
            i--;
        } while (i>0);

        String color = "purple";
        switch(color) {
            case 1: color = "orange";
                System.out.println("orange = red + yellow");
                break;
            case 2: color = "purple";
                System.out.println("purple = red + blue");
                break;
            case 3: color = "green";
                System.out.println("green = yellow + blue");
                break;
            default:
                System.out.println("color unknown");
                break;
        }
    }
}

