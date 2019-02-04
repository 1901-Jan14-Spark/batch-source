public class Loops {

    public static void main(String[] args) {

        System.out.println("hello world");

        int x = 8;
        if(x > 10) {
            System.out.println("x is greater than 10");
        } else {
            System.out.println("x is less than 10");
        }
        
        for(int i = 0; i < 4; i++){
            System.out.println("greetings");
        }

        int counter = 0;
        while(counter < 4){
            System.out.println("greetings");
            counter++;
        }

        int counter2 = 0;
        do {
            System.out.println("greetings");
            counter2++;
        } while(counter2 != 4);

        String color = "purple";
        switch(color){
            case "green":
            System.out.println("blue and yellow");
            break;

            case "orange":
            System.out.println("red and yellow");
            break;

            case "purple":
            System.out.println("blue and red");
            break;

            default: System.out.println("unknown color");
            break;
        }
    }
}