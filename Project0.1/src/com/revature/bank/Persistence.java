package com.revature.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Persistence {

	static String usernamePath = "src/com/revature/bank/account_info.txt";
	static String balancePath = "src/com/revature/bank/account_balance.txt";

	public static void addNewBankMember(Member m) {
		try(FileWriter fw = new FileWriter(usernamePath); 
				BufferedWriter bw = new BufferedWriter(fw)){
			bw.append(m.toString());			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
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
	public static double retrieveAccountBalance() {
		double balance = 0.0;
		try(FileReader fr = new FileReader(usernamePath);
				BufferedReader br = new BufferedReader(fr);){
			for(int i = 0; i < 3; ++i) {
				br.readLine();
			}
			String accountBalance = br.readLine();
			System.out.println(accountBalance);
			String balanceAmount = accountBalance.substring(10);
			balance = Double.parseDouble(balanceAmount);
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
	
	public static void main(String[] args) {
		retrieveAccountBalance();
		
	}
}
