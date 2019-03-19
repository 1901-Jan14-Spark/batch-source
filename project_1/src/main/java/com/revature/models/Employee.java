package com.revature.models;

import java.io.Serializable;

public class Employee implements Serializable{
	
	/**
	 * Setter method for id has been omitted for integrity purposes
	 */
	
	private static final long serialVersionUID = 4371188407373029227L;

	private int id;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private int managerLevel;
	
	public Employee() {
		super();
	}
	
	// TesterConstructor: create
	public Employee(String email, String password, String firstname, String lastname, int managerLevel) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.managerLevel = managerLevel;
	}

	// Constructor to generated list of employees.
	public Employee(int id, String email, String firstname, String lastname, int managerLevel) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.managerLevel = managerLevel;
	}

	//Constructor to generate employee from database
	public Employee(int id, String email, String password, String firstname, String lastname, int managerLevel) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.managerLevel = managerLevel;
	}

	public int getId() {
		return id;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getManagerLevel() {
		return managerLevel;
	}

	public void setManagerLevel(int managerLevel) {
		this.managerLevel = managerLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + managerLevel;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (managerLevel != other.managerLevel)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", managerLevel=" + managerLevel + "]";
	}

	public void setId(int id) {
		this.id=id;
		
	}
	
}
