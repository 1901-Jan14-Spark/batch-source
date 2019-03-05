package models;

import java.io.Serializable;

public class BankClients implements Serializable{
	private static final long serialVersionUID = 4696949951560521088L;
private int accID;
private String firstName;
private String lastName;
private String email;
private String username;
private String password;
public int getAccID() {
	return accID;
}
public void setAccID(int accID) {
	this.accID = accID;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + accID;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
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
	BankClients other = (BankClients) obj;
	if (accID != other.accID)
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}
@Override
public String toString() {
	return "BankClients [accID=" + accID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", username=" + username + ", password=" + password + "]";
}
public BankClients(String firstName, String lastName, String email, String username, String password) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.username = username;
	this.password = password;
}
public BankClients() {
	super();
	// TODO Auto-generated constructor stub
}
public BankClients(int accID, String firstName, String lastName, String email) {
	this.accID = accID;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email; 
}

public BankClients(String username, String password) {
	this.username = username;
	this.password = password;
	}

}