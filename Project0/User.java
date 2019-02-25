import java.io.PrintStream;

public class User {
    private double accountBal;
    private String email;
    private String password;

    User() {
    }

    User(String string, String string2) {
        this.email = string;
        this.password = string2;
        this.accountBal = 0.0;
    }

    public void deposit(double d) {
        if (d < 0.0) {
            System.out.println("Cannot deposit a negative amount!");
        } else {
            this.accountBal += d;
            System.out.println("Transaction Successful! Current balance:" + this.accountBal);
        }
    }

    public void withdraw(double d) {
        if (d < 0.0) {
            System.out.println("Cannot withdraw a negative amount!");
        } else if (d > this.accountBal) {
            System.out.println("Insufficient funds!");
        } else {
            this.accountBal -= d;
            System.out.println("Transaction Successful! Current balance:" + this.accountBal);
        }
    }

    public void printBalance() {
        System.out.println("Your current balance is: " + this.accountBal);
    }

    public String toString() {
        return "email:" + this.email + ",password:" + this.password + ",balance:" + this.accountBal;
    }
}