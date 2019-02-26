public class OperatorTest{

    public static void main(String[] args){

        int a = 10; 
        
        // System.out.println("a++: "+ a++ + " and the value of a is now "+a);
        // System.out.println("++a: "+ ++a + " and the value of a is now "+a);

        // at this point a is 12 
        // System.out.println("a--: "+ a-- + " and the value of a is now "+a);
        // System.out.println("--a: "+ --a + " and the value of a is now "+a);


        int x = 6;
        int y = 8;
        int z = 13;

        String s1 = x>y ? "Hello" : "World";
        System.out.println(s1);

        String s2 = (x<y)&&(y>z) ? "Yellow" : "Green";
        System.out.println(s2);

        // str && str.length === 5 
        // (str != null) && str.length == 5

        String s3 = (x*2>z)||(y<10) ? "Cat" : "Dog";
        System.out.println(s3);

    }

}