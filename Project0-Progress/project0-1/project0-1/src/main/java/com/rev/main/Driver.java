package com.rev.main;

import java.util.List;
import java.util.Scanner;

import com.rev.util.Customer;
import com.rev.util.CustomerDao;
import com.rev.util.CustomerDaoImpl;

public class Driver {

	static Scanner scan1 = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		
		CustomerDao cus1 = new CustomerDaoImpl();
		
//		int creat = cus1.addCustomer(new Customer(1,"George",200.01,"GG","fancypants1"));
//		System.out.println(creat);
		Login();
		
		
		
//		List<Customer> customers = cus1.getCustomers();
//		for(Customer c: customers) {
//			System.out.println(c);
//		}
		
	}
	
	
	public static  void Login() {
		System.out.println("\t\t\t\t\t\t\tAre you logining in or signing up?");
		System.out.println("Type: Login or Sign");
		String ans = scan1.nextLine();
		
		if(ans.equals("Login")||ans.equals("login")||ans.equals("l")){
			System.out.println("Please enter your credentials");
		}
		if(ans.equals("Sign")||ans.equals("sign")||ans.equals("s")) {
			//CreateAccount();
		}
		
		CustomerDao cus1 = new CustomerDaoImpl();
		System.out.println("Username: ");
		String ans2 = scan1.nextLine();
		if(cus1.getCustomerCredentials().containsKey(ans2)) {
			System.out.println("Password: ");
			String ans3 = scan1.nextLine();
			if(cus1.getCustomerCredentials().get(ans2).equals(ans3)) {
				System.out.println("You're Login Has Been Succesful");
				//operations();
				return;
			}
		}
		//System.out.println(getInfo());
	}
	
	
	
	
	
}
