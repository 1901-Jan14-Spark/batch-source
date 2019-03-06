package bankApplication;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;

import util.ConnectionUtil;

public class Transaction {
	public static double amount;
	public static String confirm;
	public static boolean valid;
	
	private static Logger log = Logger.getRootLogger();
	static Scanner scan = new Scanner(System.in);
	
	public static void deposit(String userName) {
		int adjust = 0;
		amount = validateDouble();
		log.info("\nConfirm deposit amount: "+amount+" (y/n)?");
		confirm = scan.nextLine();
		if(confirm.equals("y")||confirm.equals("yes")) {
			log.info("Processing, please wait.");
			String sql = "{call DEPOSIT(?,?,?)}";
			try(Connection con = ConnectionUtil.getConnection();
					CallableStatement cs = con.prepareCall(sql)){
				
				cs.setString(1, userName);
				cs.setDouble(2, amount);
				cs.registerOutParameter(3, java.sql.Types.INTEGER);
				cs.execute();
				
				adjust = (int)cs.getObject(3);
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(adjust==1)
				log.info("\n"+amount+" Successfully deposited.");
			
			else {
				log.info("\ndeposit error");
				log.info("Failed to deposit "+amount);
			}
		}
	}
	
	public static void withdraw(String userName) {
		int overdraft = 0;
		amount = validateDouble();
		log.info("\nConfirm withdraw amount: "+amount+" (y/n)?");
		confirm = scan.nextLine();
		if(confirm.equals("y")||confirm.equals("yes")) {
			log.info("Processing, please wait.");
			String sql = "{call WITHDRAW(?,?,?)}";
			try(Connection con = ConnectionUtil.getConnection();
					CallableStatement cs = con.prepareCall(sql)){
				
				cs.setString(1, userName);
				cs.setDouble(2, amount);
				cs.registerOutParameter(3, java.sql.Types.INTEGER);
				cs.execute();
				overdraft = (int)cs.getObject(3);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(overdraft==1)
				log.info("\nUnable to process: withdraw amount exceeds current balance.");
				
			else
				log.info("\n"+amount+" Successfully withdrawn.");
		}
	}
	
	//validate user deposit and withdraw input 
	public static double validateDouble() {
		//required to prevent user input errors
		Scanner scanIt = new Scanner(System.in);
		//allow user to try again if negative number is entered
		do {
			log.info("Enter amount: ");
			//allow user to try again if invalid input is entered
			while(!scanIt.hasNextDouble()) {
				//in case user enters a string
				String input = scanIt.next();
				log.info("Invalid input.");
				log.info("Enter a number: ");
			}
			//format output to limit number to hundredth place
			amount = Double.parseDouble(String.format("%.2f", scanIt.nextDouble()));
			if(amount < 0)
				log.info("Enter a positive number: ");
			
		}while(amount < 0);
		return amount;
	}
}
