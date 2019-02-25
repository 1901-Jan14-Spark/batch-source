package com.revature.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Persistence {

	static String accountPath = "src/com/revature/bank/account_info.txt";
	static String balancePath = "src/com/revature/bank/account_balance.txt";

	public static void addNewBankMember(Member m) {
		try(FileWriter fw = new FileWriter(accountPath); 
				BufferedWriter bw = new BufferedWriter(fw)){
			bw.append(m.toString());			
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
	
	// get the user's account number and balance from he text file
	public static double retrieveAccountBalance() {
		double balance = 0.0;
		try(FileReader fr = new FileReader(accountPath);
				BufferedReader br = new BufferedReader(fr);){
			for(int i = 0; i < 4; ++i) {
				if(i < 3 || i > 3) {  
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
		try(FileWriter fw = new FileWriter(balancePath); 
				BufferedWriter bw = new BufferedWriter(fw)){
			String newBalance = Double.toString(amount);
			bw.append("$" + newBalance);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void adjustAccountBalance2(double amount) {
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
		
		
		try(FileWriter fw = new FileWriter(accountPath); 
				BufferedWriter bw = new BufferedWriter(fw)){
			String newBalance = Double.toString(amount);
			for(int i = 0; i < 3; i++) {
				bw.append("info");
			}
			bw.append("Balance: $" + newBalance);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		getAccountInfo();
		System.out.println();
		System.out.println(getAccountUsername());
		System.out.println(getAccountNumber());
		System.out.println(retrieveAccountBalance());
		System.out.println(getAccountPassword());
		
		
	}
}
