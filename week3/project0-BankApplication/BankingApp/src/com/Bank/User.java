package com.Bank;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	/**
	 * validation :( view control elements where?
	 */
	private static final long serialVersionUID = -2799245981064758469L;
	private String lastName;
	private String firstName;
	private int ID;
	private String username;
	private Account account;
	private String password;
	private UserDaoImp userDao;

	public User() {

		super();

		this.lastName = "New_LAST_NAME";
		this.firstName = "NEW_FIRST_NAME";
		this.username = "NEW_USERNAME";

		Account account = new Account();
		userDao = new UserDaoImp();
		ID = account.getID();
		this.account = account;

	}

	public User(String lastName, String firstName, String username) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.username = username;
		this.password = "xxxxxx";

		Account account = new Account();
		UserDaoImp ud = new UserDaoImp();
		ID = account.getID();
		this.account = account;
	}

	public UserDaoImp getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImp userDao) {
		this.userDao = userDao;
	}

	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", firstName=" + firstName + ", ID=" + ID + ", username=" + username
				+ ", account=" + account + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (ID != other.ID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ArrayList<User> retrieveUsers() {

		return null;
		// return DeserializeUser.retrieveUser();

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}