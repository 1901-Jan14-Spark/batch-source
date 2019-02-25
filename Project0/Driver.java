import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Driver {
    private static Scanner sc = new Scanner(System.in);
    private static DataHandler dh = new DataHandler();

    public static void main(String[] arrstring) {
        block6 : do {
            Object object;
            String string;
            String[] arrstring2;
            System.out.println("Welcome to National Bank of No-Sleep!");
            System.out.println("Please choose an option... 1: Register, 2: Login!, 3: Quit");
            int n = sc.nextInt();
            if (n != 1 && n != 2 && n != 3) {
                System.out.println("Please select an option by typing '1' or '2' or '3'!");
                continue;
            }
            if (n == 3) break;
            if (n == 1) {
                System.out.print("Enter username: ");
                arrstring2 = sc.next();
                System.out.print("Enter password: ");
                string = sc.next();
                object = new User((String)arrstring2, string);
                System.out.println(object.toString());
                dh.newAndUpdateUser((User)object);
            }
            if (n != 2) continue;
            arrstring2 = dh.getUser().split(",");
            string = arrstring2[0].split(":")[1];
            object = arrstring2[1].split(":")[1];
            double d = Double.parseDouble(arrstring2[2].split(":")[1]);
            System.out.println(string + (String)object + d);
            String string2 = "";
            String string3 = "";
            int n2 = 3;
            string.trim();
            object.trim();
            while (!string2.contains(string) && !string3.contains((CharSequence)object)) {
                System.out.println("" + n2 + " login attempts remaining!");
                System.out.print("Enter username: ");
                string2 = sc.next();
                System.out.print("Enter password: ");
                string3 = sc.next();
                if (--n2 < 1) {
                    System.out.println("Login attempts reached! Goodbye!");
                    return;
                }
                string2.trim();
                string3.trim();
            }
            User user = new User(string, (String)object);
            user.deposit(d);
            n2 = 0;
            block8 : do {
                if (n2 == 4) continue block6;
                System.out.println("Please choose an option... 1: Deposit , 2: Withdraw, 3: Check Balance, 4: Quit");
                n2 = sc.nextInt();
                switch (n2) {
                    double d2;
                    case 1: {
                        System.out.print("Enter amount to deposit: ");
                        d2 = sc.nextDouble();
                        user.deposit(d2);
                        continue block8;
                    }
                    case 2: {
                        System.out.print("Enter amount to withdraw: ");
                        d2 = sc.nextDouble();
                        user.withdraw(d2);
                        continue block8;
                    }
                    case 3: {
                        user.printBalance();
                        continue block8;
                    }
                    case 4: {
                        dh.newAndUpdateUser(user);
                        continue block6;
                    }
                }
                System.out.println("Invalid option... please type '1','2','3','4'");
            } while (true);
            break;
        } while (true);
    }
}