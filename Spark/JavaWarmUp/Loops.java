public class Loops{
    public static void main(String[] args){
        System.out.println("Problem 1");
        System.out.println("hello world");
        System.out.println("Problem 2");
        int x = 11; //it goest to 11
        if(x>10)
            System.out.println("x is greater than 10");
        else
            System.out.println("x is less than or equal to 10");
        System.out.println("Problem 3");
        for(int i = 0; i<4; i++)
            System.out.println("greetings");
        int i = 0;
        System.out.println("Problem 4");
        while(i<4){
            System.out.println("greetings");
            i++;
        }
        System.out.println("Problem 5");
        i = 0;
        do{
            System.out.println("greetings");
            i++;
        }while(i<4);
        System.out.println("Problem 6");
        String color = "purple";
        switch(color){
            case "orange":
                System.out.println("orange is made from red and yellow");
                break;
            case "green":
                System.out.println("green is made from blue and yellow");
                break;
            case "purple":
                System.out.println("purple is made from blue and red");
                break;
            default:
                System.out.println("unknown");
        }
    }
}