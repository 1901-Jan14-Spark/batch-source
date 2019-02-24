package com.revature.bankapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//import com.revature.bankapp.exceptions.OverdraftException;

public class User implements BankLogic, ReadWriteManager {

	private String name;
	private String username;
	private String email;
	private String password;
	private double balance;
	
	public User() {
		super();
	}
	
	public User(String name, String username, String email, String password, double balance) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (!name.matches("[A-Za-z]+")) {
			this.name = null;
		} else {
			this.name = name;
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if (username.matches("[A-Za-z0-9]+") && (username.length() > 4) && (username.length() < 12)) {
			this.username = username;
		} else {
			this.username = null;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")) {
			this.email = email;
		} else {
		this.email = null;
		}
	}	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if (password.matches("^(?=.*\\d).{4,10}$")) {
			this.password = password;
		} else {
			this.password = null;
		}
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public double addDeposit(double depositAmount) {
		User user = new User();
		String[] activeUserArr = user.readUser();
		double userCurrentBal = Double.parseDouble(activeUserArr[4]);
		return userCurrentBal+depositAmount;
	}
	
	public double processWithdrawal(double withdrawalAmount) {
		User user = new User();
		String[] activeUserArr = user.readUser();
		double userCurrentBal = Double.parseDouble(activeUserArr[4]);
		double newBalance = userCurrentBal - withdrawalAmount;
			if (newBalance < 0) {
					System.out.println("You cannot withdraw an amount that will cause your account to overdraft. Please  try again.");
					return newBalance;
				} 
		return newBalance;
	}

	@Override
	public void writeUser(String nameInput, String usernameInput, String emailInput, String passwordInput,
			double startingBalance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] readUser() {
		try (BufferedReader br = new BufferedReader(new FileReader(userFilePath))) {
			String userInfo = br.readLine();
			String[] userInfoArr = userInfo.split(",");
			return userInfoArr;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveUserChanges(String nameInput, String usernameInput, String emailInput, String passwordInput,
			double newBalance) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
