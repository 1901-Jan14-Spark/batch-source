
import java.util.Scanner;

public class Scann {

  public static int interest(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Principal: ");
    int principal = Integer.parseInt(scanner.nextLine());

    System.out.println("Rate: ");
    int rate = Integer.parseInt(scanner.nextLine());

    System.out.println("Years: ");
    int years = Integer.parseInt(scanner.nextLine());

    return principal * rate * years;
  }

  public static void main(String[] args){
    System.out.println(args[0].length());
    System.out.println(interest());
  }

}
