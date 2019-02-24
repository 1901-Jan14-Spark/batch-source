package com.Revature.Project0;

import java.util.Scanner;

public class InputOutput {
	static Scanner s =new Scanner(System.in);
	public static void main(String[] args) {
		home();
		
	}
	public static void home() {
		System.out.println("Welcome to Revature Banks.");
		System.out.println("Do you have an account with us. Y/N");
		
		boolean YN=false;
		while(YN==false) {
		String x = s.nextLine();
		if (x.equals("N")) {
			YN=true;
			Account.CreateAccount();
			
			
		}else if (x.equals("Y")) {
			YN=true;
			Account.logIn();
		
		}else {
			System.out.println("Please only enter Y for yes or N for no.");
		}
		}
	}

}
