package com.revature.scanner;

import java.util.Scanner;

public class Driver {
	
	static Scanner sc = new Scanner(System.in);

	//create a method "createUser" which will print a welcome message and their username
	//username = first initial of their first name and their full last name
	public static void createUser() {
		System.out.println("Enter first and last name:");
		String name = sc.nextLine();
		System.out.println(name);
		while(name.split(" ").length != 2) {
			System.out.println("Incorrect input. Enter first and last name");
			name = sc.nextLine();
		}
		String[] splitName = name.split(" ");
		String firstName = splitName[0];
		String lastName = splitName[1];
		System.out.println("Welcome "+firstName);
		String username = (firstName.charAt(0)+lastName).toLowerCase();
		System.out.println("Your username is "+username);
	}
	
	// write a method which will sum comma separated ints
	public static int addNums() {
		int sum = 0;
		
		System.out.println("Input numbers separated by a comma:");
		String numString = sc.nextLine();
		String[] strArr = numString.split(",");
		
		for(String str: strArr) {
			try {
				sum += Integer.parseInt(str);				
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. "+str+" cannot be parsed");
				return addNums();
			}
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		createUser();
//		System.out.println(addNums());
	}

}
