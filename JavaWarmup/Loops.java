public class Loops{

    public static void main(String[] args){
    //1. print hello world to console
    System.out.println("hello world");
    //2. Varible x
    int x = 5;
    if(x > 10 ){
        System.out.println( x + " is greater than 10");
    }
    else{
        System.out.println( x + " is less than or equal to 10");

    }
    //3. for loop
    String greeting = "greetings";
    for(int i = 0; i< 4; i++){
        System.out.print(greeting + ", ");
    }
    System.out.println();
    //4. while loop
    int condition = 0;
    while(condition <4){
    System.out.print(greeting + ", ");
    condition++;
    }
    System.out.println();
    //5. do while loop
    condition = 0;
    do{
    System.out.print(greeting + ", ");
    condition++;
    }while(condition <4);
    System.out.println();
    //6. Swtich statement

    String color = "orange";
    switch(color){
        case "orange": System.out.println("Yellow and Red") ;
                        break;
        case "purple": System.out.println("Blue and Red");
                        break;
        case "green": System.out.println("Yellow and Blue");
                        break;
        default: System.out.println("color unknown");
                        break;
    }

    }

}