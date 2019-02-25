package Classes;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String password;
	private String firstName, lastName;
	private float checkingBalance, savingBalance;
	
	public User(String username, String password, String firstName, String lastName)
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		checkingBalance = 0;
		savingBalance = 5;
	}

	public String getFirstName() {
		return firstName;
	}

	public float getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(float checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public float getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(float savingBalance) {
		this.savingBalance = savingBalance;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
