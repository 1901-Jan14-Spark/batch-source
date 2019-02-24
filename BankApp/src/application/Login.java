package application;

import java.util.Scanner;

public class Login {
	static Scanner scan = new Scanner(System.in);
	
	public Login() {
		super();
	}
	
	public static void UserAccount(String userName) {
		System.out.println("\nSuccessfully logged in.");
		double amount = 0;
		String option="",confirm;
		while(!option.equals("l")) {
			System.out.println("Welcome "+userName);
			String balance = FileEdit.readBalance(userName);
			System.out.println("Current balance: $"+balance);
			
			System.out.println("\nPlease select an option:");
			System.out.println("(d) Deposit.");
			System.out.println("(w) Withdraw.");
			System.out.println("(l) Log out.");
			option = scan.nextLine().toLowerCase();
			switch(option) {
			case "d":
				System.out.println("\nDeposit option selected.");
				amount = 0;
				System.out.println("\nEnter deposit amount: ");
				amount = Double.parseDouble(scan.nextLine());
				System.out.println("\nConfirm deposit amount: "+amount+" (y/n)?");
				confirm = scan.nextLine();
				if(confirm.equals("y")) {
					boolean adjust = FileEdit.adjustBalance(userName, amount, 'd');
					if(adjust)
						System.out.println(amount+" Successfully deposited.");
					
					else
						System.out.println("error.");
				}
				break;
				
			case "w":
				System.out.println("\nWithdraw option selected.");
				amount = 0;
				System.out.println("\nEnter withdraw amount: ");
				amount = Double.parseDouble(scan.nextLine());
				System.out.println("\nConfirm withdraw amount: "+amount+" (y/n)?");
				confirm = scan.nextLine();
				if(confirm.equals("y")) {
					if(amount > Double.parseDouble(balance)) {
						System.out.println("Unable to process: withdraw amount exceeds current balance.");
					}
					else {
						boolean adjust = FileEdit.adjustBalance(userName, amount, 'w');
						if(adjust)
							System.out.println(amount+" Successfully withdrawn.");
						
						else
							System.out.println("error.");
					}
				}
				break;
				
			case "l":
				System.out.println("\nSuccessfully logged out.\n");
				break;
			default:
				System.out.println("Invalid selection.");
				break;
			}
		}
	}
}
