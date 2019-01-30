public class HelloWorld {

    public static void main(String[] args) {

        String name = "World";
        if(args.length > 0) {
            name = args[0];
        }
        
        System.out.println("Hello " + name);
        // System.out.println("First argument: " + args[0]);
        // System.out.println("Second argument: " + args[1]);
        // System.out.println("Third argument: " + args[2]);

        for(int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }
    }

}

