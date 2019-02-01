import  java.io.File;

public class Loops{
public static void main(String[] args){
    System.out.println("Hello world");

                int x = 43;
                        if(x>10){
                            System.out.println("The given value for x is greater than 10.");
}   
                        else{
    System.out.println("The given value for x is less than 10.");
}

                for(int i=0;i<4;i++)
                System.out.println("Greetings!");



                    int j = 0;
                        do{j++; System.out.println("Greetings! with a do-while");}
                        while(j<4);

                        int count = 1;
                        while(count<5){
                        System.out.println("Greetings from the while no do!");
                        count ++;
                                    }
        
                        String Color;
                        Color = "green";
                        switch (Color) {
                            case "green":{
                            System.out.println("blue and yellow");
                            break;
                            }
                            case "purple":{
                            System.out.println("red and blue");
                            }
                            break;
                            case "orange":{
                            System.out.println("red and yellow");
                            }
                            break;
                            default:{

                            System.out.println("color unknown");
                            }
                        }
                        

            }

}
