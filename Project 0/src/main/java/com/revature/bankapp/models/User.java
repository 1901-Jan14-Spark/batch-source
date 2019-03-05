package com.revature.bankapp.models;

import java.math.BigDecimal;

import com.revature.bankapp.ReadWriteManager;

public class User implements ReadWriteManager {

//	private int accountId;
////	static private int accountNumber = 1;
	private int userId;
	private String name;
	private String username;
	private String email;
	private String password;
	private Account account;
	private BigDecimal balance;
	
	public User() {
		super();
//		this.accountId = accountNumber++;
	}
	
	public User (int userId, String name, String username, String password) {
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public User (String name, String username, Account account) {
		this.name = name;
		this.username = username;
		this.account = account;
	}
	
	public User(String name, String username, String email, String password, BigDecimal balance) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}
	
	public User(String username2, Account tempAcc) {
		this.username = username2;
		this.account = tempAcc;
	}

	public User(int accId, String name, String username, String email, String password, BigDecimal balance2) {
		this.userId = accId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.balance = balance2;
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

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", balance=" + balance + "]";
	}	
	
	
}
