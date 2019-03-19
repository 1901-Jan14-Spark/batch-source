package com.revature.model;

public class Employee {
	private int eID;
	private boolean isManager;
	private String fName;
	private String lName;
	private String phone;
	private String email;
	private String password;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eID, boolean isManager, String fName, String lName, String phone, String email,
			String password) {
		super();
		this.eID = eID;
		this.isManager = isManager;
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}


	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [eID=" + eID + ", isManager=" + isManager + ", fName=" + fName + ", lName=" + lName
				+ ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
