package com.revature.bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Persistence {

	static String path = "src/com/revature/bank/account_data.txt";
	
	// get all the user's information from the text file using a try with resources
	public static void getAccountInfo() {
		try(FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);){			
			String accountInfo = br.readLine();
			while(accountInfo != null) {
				System.out.println(accountInfo);
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void getAccountBalance(String userInfo) {
		double accountBalance = Double.parseDouble(userInfo);
		
			
			
			
		
	}
	
	
}
