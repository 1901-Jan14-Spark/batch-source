package main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import dao.AccountsDao;
import dao.AccountsDaoImpl;
import dao.BankClientsDao;
import dao.BankClientsDaoImpl;
import models.BankClients;

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
		
		bcd.createClient(new BankClients(4, firstname, lastname, email, username,password));
		
		log.info("USER CREATED");
		}
	public static void menu() {
		log.info("Welcome To Coders Bank");
		log.info("Please Select One of the Following Options: ");
		log.info("To Create a New User Please Type 'New'. To Login Into an Existing Account Please Type 'Login'.");
		String choice = input.nextLine();
		if(choice.matches("New")) {
			makeNew();
		}else {
			log.error("INVAID INPUT PLEASE TRY AGAIN");
			menu();
		}
		
	}
}
