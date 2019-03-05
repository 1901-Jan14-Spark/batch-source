package bankApplication;

import java.util.Scanner;

import org.apache.log4j.Logger;


public class UserMenu {

	static Scanner scan = new Scanner(System.in);
	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		
		log.info("Welcome.");
		String option = "";
		//display menu until user selects to exit
		while(!option.equals("e")) {
			log.info("Please select an option:");
			log.info("(c) Create an account.");
			log.info("(l) Log in.");
			log.info("(e) Exit.");
			option = scan.nextLine().toLowerCase();//accept upper and lower case letters
			switch(option) {
			case "c":
				log.info("\nCreate user option selected:");
				User.createUser();
				break;
				
			case "l":
				log.info("\nLog in option selected.");
				User.verifyUser();
				break;
				
			case "e":
				log.info("\nGoodbye.\n");
				break;
				
			default:
				log.info("Invalid selection.");
				break;
			}
		}
	}

}
