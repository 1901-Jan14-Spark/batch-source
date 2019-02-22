package bank;
import bank.Info;
import java.util.Scanner;

public class Console extends Info{
	static Scanner scan1= new Scanner(System.in);





public static void main(String[] args) {
	//CreateAccount();
	Login();

}
public static void Login() {
	System.out.println("\t\t\t\t\t\t\tAre you logining in or signing up?");
	System.out.println("Type: Login or Sign");
	String ans = scan1.nextLine();
	if(ans.equals("Login")||ans.equals("login")||ans.equals("l")){
		System.out.println("Please enter your credentials");
	}
	if(ans.equals("Sign")||ans.equals("sign")||ans.equals("s")) {
		CreateAccount();
	}
	
	System.out.println(getInfo());
}


public static void CreateAccount() {
	System.out.println("\t\t\t\t\t\t\tCreate an account");
	System.out.println("\t\t\t\tPlease Create a username");
	System.out.println();
	String username = scan1.nextLine();
	System.out.println(username+"?"+" Are you sure?");
	System.out.println();
	String ans = scan1.nextLine();
	if(ans.equals("yes")||ans.equals("Yes")||ans.equals("y")||ans.equals("Y")||ans.equals("yea")||ans.equals("yep")) {
		System.out.println("Alright "+username+". Your username is set. Please Enter your password.");
		
	}else{System.out.println("Well, what would you like your username to be?");
			username = scan1.nextLine();
			System.out.println("You're right. That is better");
			System.out.println("Alright "+username+". Your username is set. Please Enter your password.");
	}
	String password = scan1.nextLine();
	char[] pw = new char[password.length()];
	//System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.print("Ok "+username+" your password: ");
	for(int i = 0; i<password.length(); i++) {
		System.out.print("x");
	}
	System.out.println(" and username are both set and will be saved.");
	setUser(username, password);
	//System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();

}



}
