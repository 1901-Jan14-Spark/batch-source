package com.Revature.Project0;

public class BusinessLogic extends InputOutput{

	
	public static void options(Account a) {
		System.out.println("Welcome back, " +a.usernameEmail+ ".");
		System.out.println("Which would you like to do:WITHDRAW, DEPOSIT, CHECK_BALANCE, OR LOG_OUT ?");
		boolean chosen=false;
		while(chosen==false) {
		String choice=s.nextLine();
		if(choice.equals("WITHDRAW")) {
			chosen=true;
			withdraw(a);
		}else if(choice.equals("DEPOSIT")) {
			chosen=true;
			deposit(a);
		}
		else if(choice.equals("CHECK_BALANCE")) {
			chosen=true;
			balance(a);
		}else if(choice.equals("LOG_OUT")) {
			chosen=true;
			home();
		}else  {
			System.out.println("Please enter option exactly as shown");
		}
		} 
	}
	public static void withdraw(Account a) {
		System.out.println("You have a balance of $"+ a.balance + ".");
		System.out.println("How much would you like to withdraw?");
		String w=s.nextLine();
		double amount=0;
		try {
			 amount=Double.valueOf(w);
		}catch (NumberFormatException e) {
			System.out.println("Please enter a numeric value.");
		}
		if (amount<a.balance) {
			a.balance=a.balance-amount;
			Account.StoreAccount(a);
			System.out.println("Current balance is now $" + a.balance);
			
		}else {
			System.out.println("Can not withdraw that much");
			withdraw(a);
		}
		System.out.println("Hit any button to continue");
		s.nextLine();
		options(a);
		
	}
	public static void deposit(Account a) {
		System.out.println("You have a balance of $"+ a.balance + ".");
		System.out.println("How much would you like to deposit?");
		String w=s.nextLine();
		double amount=0;
		try {
			 amount=Double.valueOf(w);
		}catch (NumberFormatException e) {
			System.out.println("Please enter a numeric value.");
		}
		a.balance=a.balance+amount;
		Account.StoreAccount(a);
		System.out.println("Current balance is now $" + a.balance);
		System.out.println("Hit any button to continue");
		s.nextLine();
		options(a);
	}
	public static void balance(Account a) {
	System.out.println("You have a balance of $"+ a.balance + ".");
	System.out.println("Hit any button to continue");
	s.nextLine();
	options(a);
	}
	
	
}
