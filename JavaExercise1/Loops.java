public class Loops{

public static int x = 5;
public static int i;
public static String color = "orange";

    public static void main(String[] args){

        //#1//
        System.out.println("hello world"); 

        //#2//
        if(x>10){
            System.out.println("x is greater than 10");
        }
        else{
            System.out.println("x is equal to or less than 10.");
        }

        //#3//
        for(i=0;i<4;i++){
            System.out.println("greetings");
        }

        //#4//
        while(x<9){
            System.out.println("greetings");
            x++;
        }

        //#5//
        x = 5;
        do{
            System.out.println("greetings");
            x++;
        } while(x<9);

        //#6//

        switch(color){
            case "orange":
                System.out.println("red and yellow");
                break;
            case "purple":
                System.out.println("red and blue");
                break;
            case "green":
                System.out.println("blue and yellow");
                break;
            default: System.out.println("color unknown");
        }




    }
}