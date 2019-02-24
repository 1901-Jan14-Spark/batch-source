package com.revature.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Persistence {

	static String usernamePath = "src/com/revature/bank/account_username.txt";
	static String balancePath = "src/com/revature/bank/account_balance.txt";

	
	
	// get all the user's username and account number from the text file using a try with resources
	public static void getAccountInfo() {
		try(FileReader fr = new FileReader(usernamePath);
				BufferedReader br = new BufferedReader(fr);){			
			String accountInfo = br.readLine();
			while(accountInfo != null) {
				System.out.println(accountInfo);
				accountInfo = br.readLine();
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	// get the user's account number and balance from he text file
	public static void getAccountBalance() {
		try(FileReader fr = new FileReader(balancePath);
				BufferedReader br = new BufferedReader(fr);){			
			String accountBalance = br.readLine();
			while(accountBalance != null) {
				System.out.println(accountBalance);
				accountBalance = br.readLine();
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void adjustAccountBalance(double amount) {	
		try(FileWriter fw = new FileWriter(balancePath); 
				BufferedWriter bw = new BufferedWriter(fw)){
			String newBalance = Double.toString(amount);
			bw.append("$" + newBalance);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		//getAccountInfo();
		getAccountBalance();
		adjustAccountBalance(56345);
		getAccountBalance();
		adjustAccountBalance(34456);
		getAccountBalance();
		
	
	
	}
}
