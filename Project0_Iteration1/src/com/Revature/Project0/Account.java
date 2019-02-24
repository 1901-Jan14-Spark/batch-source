package com.Revature.Project0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Account extends InputOutput implements Serializable{
	private static final long serialVersionUID = -2799245981064758469L;
String usernameEmail;
String password;
Double balance;
static String name;
static String pass1;
static String pass2;
static boolean correctPass;
static String path = "src/com/Revature/Project0/Account.ser";

	public Account(String usernameEmail, String password) {
		this.usernameEmail=usernameEmail;
		this.password=password;
		this.balance=0.00;
	}
	public static void CreateAccount() {
		System.out.println("Please provide a Username or Email");
		name=s.nextLine();
		while(correctPass==false) {
		System.out.println("Please enter PassWord");
		pass1=s.nextLine();
		System.out.println("Please re-enter PassWord");
		pass2=s.nextLine();
		if (pass1.equals(pass2)) {
			correctPass=true;
		}else {
			System.out.println("Passwords did not match, please try again.");
		}
		}
		Account A1=new Account(name, pass1);
		StoreAccount(A1);
		System.out.println("Congratualations, you created an account with Username: "+ A1.usernameEmail + " and password:" + A1.password);
		System.out.println("Hit any button to continue");
		s.hasNextLine();
		home();
		
	}
	public static void logIn() {
		System.out.println("Please enter Username of Email");
		name=s.nextLine();
		System.out.println("Please enter password");
		pass1=s.nextLine();
		varify(name, pass1);
	}
	public static void StoreAccount(Object account) {
		try(FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(account);
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void varify(String name, String pass1) {
		try(FileInputStream fis = new FileInputStream(path); 
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Account a = (Account) ois.readObject();
			System.out.println(a.password);
			if (a.password.equals(pass1) && a.usernameEmail.equals(name)) {
				BusinessLogic.options(a);
				
			}else {System.out.println("Username or password are incorrect. Please try again.");
				home();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
