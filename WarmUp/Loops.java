public class Loops{

    public static void main(String[] args){

        // - Question 1
        System.out.println("Hello world!!");
        System.out.println();
        // - Question 2
        int x = 1;
        if(x > 10){
            System.out.println("X = " + x + ": X is greater than 10.");
        } else {
            System.out.println("X = " + x + ": X is less than or equal to 10");
        }
        System.out.println();
        // - Question 3
        for(int i = 0; i < 4; i++){
            System.out.println("Greetings!");
        }
        System.out.println();
        // - Question 4
        int d = 0;
        while(d < 4){
            d += 1;
            System.out.println("Greetings!!");
        }
        System.out.println();
        // - Question 5
        int j = 0;
        do {
            
            System.out.println("Greetings!!!");
            j++;
        } while (j < 4);
        System.out.println();
        // - Question 6
        String color = "Royal Blue";
        switch(color){
            case "Green":
                System.out.println("Yellow and blue make green.");
                break;
            case "Purple":
                System.out.println("Red and blue make purple.");
                break;
            case "Orange":
                System.out.println("Red and yellow make orange.");
                break;
            default:
                System.out.println("Error, color unknown!!");
        }
    }
}