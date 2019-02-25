package com.revature.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Persistence {
	
	// where the member information is stored
	static String accountPath = "src/com/revature/bank/account_info.txt";

	// add a new member
	public static void addNewBankMember(Member m) {		
		try(FileWriter fw = new FileWriter(accountPath, false); 
				BufferedWriter bw = new BufferedWriter(fw)){
			String newInfo = "Username: " + m.getUserName() + "\nEmail: " + m.getEmail() + "\nAccount Number: " + m.getAccountNumber() + "\nBalance: $" + m.getAccountBalance() + "\nPassword: " + m.getPassword() + "\n";	
			bw.append(newInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// get all the user's username and account number from the text file using a try with resources
	public static void getAccountInfo() {
		try(FileReader fr = new FileReader(accountPath);
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
	
	// get the username of the account
	public static String getAccountUsername() {
		String userName = "";
		try(FileReader fr = new FileReader(accountPath);
				BufferedReader br = new BufferedReader(fr);){			
			for(int i = 0; i < 4; ++i) {
				if(i != 0) {  
					br.readLine();
				} else {
					userName = br.readLine().substring(10);			
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userName;
	}

	// retrieve the user's password for validation
	public static String getAccountPassword() {
		String password = "";
		try(FileReader fr = new FileReader(accountPath);
				BufferedReader br = new BufferedReader(fr);){
			for(int i = 0; i < 4; ++i) {
				br.readLine();
			}
			password = br.readLine().substring(10);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return password;
	}
	
	// get the account number for display
	public static String getAccountNumber() {
		String accountNum = "";
		try(FileReader fr = new FileReader(accountPath);
				BufferedReader br = new BufferedReader(fr);){
			for(int i = 0; i < 4; ++i) {
				if(i != 2) {
					br.readLine();
				} else {
					accountNum = br.readLine().substring(16);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accountNum;
	}
	
	public static String getAccountEmail() {
		String accountEmail = "";
		try(FileReader fr = new FileReader(accountPath);
				BufferedReader br = new BufferedReader(fr);){
			for(int i = 0; i < 4; ++i) {
				if(i != 1) {
					br.readLine();
				} else {
					accountEmail = br.readLine().substring(7);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accountEmail;
	}
	
	// get the user's account number and balance from he text file
	public static double retrieveAccountBalance() {
		double balance = 0.0;
		try(FileReader fr = new FileReader(accountPath);
				BufferedReader br = new BufferedReader(fr);){
			for(int i = 0; i < 4; ++i) {
				if(i != 3) {  
					br.readLine();
				} else {
					String accountBalance = br.readLine();
					String balanceAmount = accountBalance.substring(10);
					balance = Double.parseDouble(balanceAmount);			
				}
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	public static void adjustAccountBalance(double amount) {
		String username = getAccountUsername();
		String email = getAccountEmail();
		String accountNum = getAccountNumber();
		String password = getAccountPassword();
		
		try(FileWriter fw = new FileWriter(accountPath, false); 
				BufferedWriter bw = new BufferedWriter(fw)){
			String newBalance = Double.toString(amount);
			String newInfo = "Username: " + username + "\nEmail: " + email + "\nAccount Number: " + accountNum + "\nBalance: $" + newBalance + "\nPassword: " + password + "\n";	
			bw.append(newInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		adjustAccountBalance(3456.26);
		
		
	}
}
