package com.revature.bank;

public class Account {

	private String email;
	private String username;
	private int password;
		
	public Account(){
		super();
	}
	
	public Account(String email, String username, int password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [E-mail= " + email + ", Username= " + username + ", Password= " + password + "]";
	}
	
	
}
