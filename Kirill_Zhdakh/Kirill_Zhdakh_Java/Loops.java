public class Loops{

public static void main(String[] args)
{
    System.out.println("hello world");
    int x = (int)(15 - Math.floor(Math.random() * 10));
    if (x > 10)
    {
        System.out.println("x is greater than 10");
    }
    else
    {
        System.out.println("x is less than or equal to 10");
    }
    int i;
    for(i = 0; i < 4; ++i)
    {
        System.out.println("greetings");
    }
    i = 0;
    while(i < 4)
    {
        System.out.println("greetings");
        ++i;
    }
    i = 0;
    do
    {
        System.out.println("greetings");
        ++i;
    } while(i < 4);
    String[] colors = {"green", "purple", "orange", "", "", ""};
    x = (int)(Math.floor(Math.random() * colors.length));
    switch(colors[x])
    {
        case "green":
        {
            System.out.println("Color is green");
        }
        break;
        case "purple":
        {
            System.out.println("Color is purple(blue + red)");
        }
        break;
        case "orange":
        {
            System.out.println("Color is orange(red + yellow)");
        }
        break;
        default:
        {
            System.out.println("Color is unknown");
        }
        break;
    }
}

}