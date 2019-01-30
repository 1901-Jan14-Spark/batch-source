public class Loops{
  public static void main(String[] args){
    System.out.println("Hello World");

    int x = 11;
    if(x > 10){
      System.out.println("x is greater than 10");
    } else{
      System.out.println("x is equal to or less than 10");
    }

    for(int i = 0; i < 4; i++){
      System.out.println("greetings");
    }
    System.out.println("\n");

    int count = 0;
    while(count < 4){
      count++;
      System.out.println("greetings");
    }
    System.out.println("\n");

    count = 0;
    do{
      count++;
      System.out.println("greetings");
    }while(count < 4);
    System.out.println("\n");

    String color = "green";
    switch(color){
      case "green":
        System.out.println("Yellow and Blue");
        break;
      case "purple":
        System.out.println("Blue and Red");
        break;
      case "orange":
        System.out.println("Yellow and Red");
      default:
        System.out.println("Color Unknown");
        break;
    }
  }
};
