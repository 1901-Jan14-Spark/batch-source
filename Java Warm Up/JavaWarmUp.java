//part 1
// 1
public class JavaWarmUp{

public static void main(String[] args){
    System.out.println("hello world");

// 2
int R= 10;

if(R>10){
   System.out.println("x is greater than 10");
}
else
{
   System.out.println("x is equal to or less than 10.");

}

// 3

String y = "greetings";
for (int i = 0; i <4; i++) {
System.out.println(y);
}
// 4
String z = "greetings";
int i=0;
while (i < 4) {
  System.out.println(z);
  i++;
  
}
// 5
String A = "greetings";
int c = 0;
    do {
      System.out.println(A);
      c++;
    }
    while (c < 4);  

// 6

       String ColorName;
       ColorName="orange";
       switch (ColorName){
       case "orange" :{
          System.out.println("yellow and red!");
          break;       
       }
       case "red" :{
          System.out.println("blue and white!");
          break;
       }
       case "blue" :{
          System.out.println("blue and white!");
          break;
       }    
       case "green" :{

          
       }      
       default :{
               System.out.println("unknown!");    
   }

}  
  }
}
