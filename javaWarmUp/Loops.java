public class Loops{
    public static void main(String[] args){
        //1
        System.out.println("Hello World");
        System.out.println();

        //2
        int x = 7;
        if(x > 10)
            System.out.println("x is greater than 10.");

        else
            System.out.println("x is equal to or less than 10.");

        System.out.println();

        //3
        for(int i=0;i<4;i++){
            System.out.println("greetings");
        }
        System.out.println();

        //4
        int count = 0;
        while(count < 4){
            System.out.println("greetings");
            count++;
        }
        System.out.println();

        //5
        count = 0;
        do{
            System.out.println("greetings");
            count++;
        }while(count < 4);
        System.out.println();

        //6
        String color = "orange";
        switch(color){
            case "green":
                System.out.println("Blue + Yellow");
                break;
            case "purple":
                System.out.println("Red + blue");
                break;
            case "orange":
                System.out.println("Yellow + Red");
                break;
            default:
                System.out.println("Color unknown");
        }
    }
}