public class DefaultTest{

    // we saw yesterday that we have defaults for instance variables
    // static variables also have default values 
    static boolean b;
    static byte by; // 8 bits
    static short s; // 16 bits
    static int i; // 32 bits
    static long l; // 64 bits
    static float f; // 32 bits
    static double d; // 64 bits
    static char c = 7;

    public static void main(String[] args){
        System.out.println("boolean default: "+b);
        System.out.println("byte default: "+by);
        System.out.println("short default: "+s);
        System.out.println("int default: "+i);
        System.out.println("long default: "+l);
        System.out.println("double default: "+d);
        System.out.println("float default: "+f);
        System.out.println("char default: "+c);

        // this is a local variable; local variables are not assigned default values
        // int myLocalVar;
        // System.out.println("local variable value="+myLocalVar);

        // i is a block scoped variable; they are also not assigned default values 
        // for(int i; i<5;i++){
        //     System.out.println("hello");
        // }

        by = 5;
        i = by;
        System.out.println(i);

        f = 3.6f;
        d = f;
        System.out.println(d);
        System.out.println(3.6-3.5);

        f = l;
        System.out.println(f);

    }



}