public class JavaE1{
private int x;



    public static void main(String[] args){
        System.out.println("Hello World");
        int x=0;
        if(x>10){
            System.out.println("x is greater than 10");
        }else{
            System.out.println("x is less than 10");
        }
        for(x=0; x<4;x++){
            System.out.println("Greetings!");
        }
        while(x<8){
            System.out.println("Greetings");
            x++;
        }
        do{
            System.out.println("Greeeetings");
            x++;
        }while(x<12);

    
    String color = "orange";
    String colorString;
    switch(color){
        case "orange": colorString= "Yellow and Red";
        break;
        case "Purple": colorString = "Red and Blue";
        break;
        case "Green": colorString = "Yellow and Blue";
        break;
        default: colorString ="Not a proper Color";
        break;
    }
    System.out.println(colorString);
    }
    
}