public class Helper{

    public static void printNums()
    {
        for(int i = 1; i < 11; ++i)
        {
            System.out.println(i);
        }
    }
    public static void printUpToVal(int val)
    {
        for(int i = 0; i < val + 1; ++i)
        {
            System.out.print(i);
            if (i != val)
                System.out.print(", ");
        }
        System.out.println();
    }
    public static void printRange(int min, int max)
    {
        for(int i = min; i < max + 1; ++i)
        {
            System.out.print(i);
            if (i != max)
                System.out.print(", ");
        }
        System.out.println();
    }
    public static void printString(String str, int count)
    {
        String result = str;
        for(int i = 0; i < count - 1; ++i)
        {
            result += str;
        }
        System.out.println(result);
    }
    public static void main(String[] args)
    {
        /*If not static
        Helper halp = new Helper();
        halp.printNums();
        halp.printUpToVal(20);
        halp.printRange(5, 15);
        halp.printString("hello", 5);
        */
        //If static
        Helper.printNums();
        Helper.printUpToVal(20);
        Helper.printRange(5, 15);
        Helper.printString("hello", 5);
    }
}