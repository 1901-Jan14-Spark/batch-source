package bankApplication;

import org.apache.log4j.*;

import dao.UserDao;
import dao.UserDaoImpl;
import model.UserObj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
	private static String userName;
	private static String password1;
	private static String password2;
	
	private static Logger log = Logger.getRootLogger();
	static Scanner scan = new Scanner(System.in);
	
	public User() {
		super();
	}
	
	public static void verifyUser() {
		log.info("\nEnter user name: ");
		userName = scan.nextLine().toLowerCase();
		log.info("\nEnter password: ");
		password1 = scan.nextLine();
		
		//ensure correct password is associated with each user
		if(confirmLogin(userName, password1)) {
			UserAccount(userName);
		}
		else {
			log.info("\nUser name and/or password is incorrect.");
		}
	}
	
	public static void createUser() {
		//allows user to choose another user name if first choice already exists
		do {
			log.info("\nEnter user name: ");
			userName = scan.nextLine().toLowerCase();
			//check if user already exists in DB
			if(doesUserExist(userName))
				log.info("User name already exists.");
		}while(doesUserExist(userName));
		
		//if passwords don't match allow user to try again
		do {
			log.info("\nEnter password: ");
			password1 = scan.nextLine();
			
			log.info("\nConfirm password: ");
			password2 = scan.nextLine();
			
			if(!password1.equals(password2))
				log.info("\nPasswords do not match.");
		}while(!password1.equals(password2));
		store(userName, password1);
	}
	
	//returns true if user already exists in database
	public static boolean doesUserExist(String userName) {
		UserDao ud = new UserDaoImpl();
		List<UserObj> users = ud.getUsersList();
		//convert list of UserObj to list of String
		List<String> userNames = new ArrayList<>();
		//store only the user names into this list, ignore other fields
		for(int i=0;i<users.size();i++) {
			userNames.add(users.get(i).getUsername());
		}
		if(userNames.contains(userName))
			return true;
		
		return false;
	}
	
	public static boolean confirmLogin(String userName, String password1) {
		UserDao ud = new UserDaoImpl();
		UserObj credential = ud.getUserAndPass(userName);
		String storedUserName = credential.getUsername();
		String storedPassword = Cipher.decode(credential.getPassword());
		if(userName.equals(storedUserName) && password1.equals(storedPassword))
			return true;
					
		return false;
	}
	
	public static double getBalance(String userName) {
		UserDao ud = new UserDaoImpl();
		UserObj balance = ud.getUserBalance(userName);
		return balance.getBalance();
	}
	
	public static void store(String userName, String password1) {
		String encriptedPass = Cipher.encode(password1);
		UserDao ud = new UserDaoImpl();
		boolean created = ud.createUser(new UserObj(userName, encriptedPass));
		if(created)
			log.info("User created.");
		
		else
			log.error("User could not be created.");
	}
	
	public static void UserAccount(String userName) {
		log.info("\nSuccessfully logged in.");
		String option="";
		while(!option.equals("l")) {
			log.info("Welcome "+userName);
			double balance = getBalance(userName);
			log.info("Current balance: $"+balance);
			
			log.info("\nPlease select an option:");
			log.info("(d) Deposit.");
			log.info("(w) Withdraw.");
			log.info("(l) Log out.");
			option = scan.nextLine().toLowerCase();
			switch(option) {
			case "d":
				log.info("\nDeposit option selected.");
				Transaction.deposit(userName);
				break;
				
			case "w":
				log.info("\nWithdraw option selected.");
				Transaction.withdraw(userName);
				break;
				
			case "l":
				log.info("\nSuccessfully logged out.\n");
				break;
			default:
				log.info("Invalid selection.");
				break;
			}
		}
	}
}
