package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import dao.BankClientsDao;
import dao.BankClientsDaoImpl;
import models.BankClients;
import util.ConnectionUtil;

public class Driver {
	public final static Logger log = Logger.getRootLogger();
	public static Scanner input = new Scanner(System.in);
	static BankClientsDao bcd = new BankClientsDaoImpl();

	
	public static void main(String[] args) {
		menu();
	
	}
	public static void makeNew() {
		
		log.info("WELCOME NEW MEMBER");
		
		log.info("Please Enter First Name: ");
		String firstname = input.nextLine() ;
		
		log.info("Please Enter Last Name: ");
		String lastname = input.nextLine();
		
		log.info("Please Enter Email: ");
		String email = input.nextLine();
		
		log.info("Please Enter Username: ");
		String username = input.nextLine();
		
		log.info("Please Enter Password: ");
		String password = input.nextLine();
		
		bcd.createClient(new BankClients(firstname, lastname, email, username,password));
		
		log.info("USER CREATED");
		menu();
		}
	
	
	public static void menu() {
		log.info("Welcome To Coders Bank");
		log.info("Please Select One of the Following Options: ");
		log.info("To Create a New User Please Type 'New'. To Login Into an Existing Account Please Type 'Login'.");
		String choice = input.nextLine();
		if(choice.matches("New")) {
			makeNew();
		}
		else if(choice.matches("Login")) {
			login();
		}
			else {
			log.error("INVAID INPUT PLEASE TRY AGAIN");
			menu();
		}
		
	}
	
	public static void login() {
		int counter = 0;
		log.info("Please Enter Username");
			String userName = input.nextLine();
		log.info("Please Enter Password");
			String passWord = input.nextLine();
			if(bcd.validation(userName, passWord)==true) {
				log.info("Login Success");
			}
			else {
				log.error("Username/Password Don't Match Please Try Again");
				counter++;
				if(counter <= 3) {
					login();

				}
				else if(counter > 3) {
					log.warn("User May Not Exist, Please Make New User");
					log.info("If You Are Certain Yout Credentials Are Correct Contact An Administrator");
					makeNew();
				}
			}

	}
}
