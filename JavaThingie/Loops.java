public class Loops{
    public static void main(String[] args) {

 //1       
        System.out.println("hello world");
//2      
       int x =14;
        if(x >= 10){
System.out.println("x is greater than 10");
        }
        else{
            if(x <= 10){
                System.out.println("x is equal to or less than 10");
            }
        }
            
//3

        for(int i=0; i < 4; i++){
                System.out.println("greetings0");
        }
//4
        int i=0;
        while(i<4){
            System.out.println("greetings1");
            i++;
        }
//5
        int a=0;
        do{
            System.out.println("greetings2");
            a++;
        } while(a<4);

//6
        String [] color={"green", "purple", "orange"};
        String green;
        String purple;
        String orange;

            switch ("color") {
                case "green":
                    System.out.println("Blue and Yellow");
                    break;

                case "purple":
                    System.out.println("Blue and Red");
                break;    
                
                case "orange":
                    System.out.println("Yellow and Red");
                    break;
                
                default: System.out.println("Color Unknown");
    
            }
    
    
        }
}