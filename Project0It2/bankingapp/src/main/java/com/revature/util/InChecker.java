package com.revature.util;
import org.apache.commons.validator.routines.EmailValidator;
import java.util.Scanner;
// helper functions for getting good inputs from the user
import org.apache.log4j.Logger;
public class InChecker {
	private static Logger log =  Logger.getRootLogger();
	private static Scanner sc = new Scanner(System.in);
	public static int getGoodInt(int min,int max) {
		int output = -1;
		try {
			log.info("Enter number between "+min+" and "+ max );
			output = sc.nextInt();
		}
		catch(IllegalArgumentException e) {
			log.info("Enter number between "+min+" and "+ max );
			return getGoodInt(min,max);
		}
		finally {
			if(output>max || output<min ) {
				log.info("Enter number between "+min+" and "+ max );
				return getGoodInt(min,max);
			}
		}
		return output;
	}
	public static double getGoodAmount() {
		double output = -1;
		try {
			log.info("Please enter an amount greater than zero: ");
			output = sc.nextDouble();
					
		}catch(IllegalArgumentException e) {
			log.info("Wrong input! Please enter a positive number!");
			return getGoodAmount();
		}
		finally {
			if(output<0) {
				log.info("Negative number! Please enter a positive number!");
				return getGoodAmount();
			}
		}
		return output;
	}
	public static String getGoodName() {
		String name = "";
		try {
			log.info("Please enter a name: ");
			name = sc.next();
					
		}catch(IllegalArgumentException e) {
			log.info("Please enter a name!");
			return getGoodName();
		}
		finally {
			if(name.length()<1) {
				log.info("Please enter a name!");
				return getGoodName();
			}
		}
		return name;
	}
	public static String getGoodEmail() {
		String email = "";
		try {
			log.info("Please enter an email: ");
			email = sc.next();
					
		}catch(IllegalArgumentException e) {
			log.info("Please enter an email!");
			return getGoodEmail();
		}
		finally {
			if(!EmailValidator.getInstance().isValid(email)) {
				log.info("Invalid email! Please enter an email!");
				return getGoodEmail();
			}
		}
		return email;
	}
	public static String getGoodPassword() {
		String pw = "";
		try {
			log.info("Please enter a password of 8 or more alphanumeric characters: ");
			pw = sc.next();
					
		}catch(IllegalArgumentException e) {
			log.info("!!!");
			return getGoodName();
		}
		finally {
			if(pw.length()<7) {
				log.info("Invalid password, try again!");
				return getGoodName();
			}
		}
		return pw;
	}
	
	

}
