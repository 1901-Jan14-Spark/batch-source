package com.revature.model;

public class Customer {
private int id;
private int aid;
private Account acc;
private String firstname;
private String lastname;
private String email;
private String password;

public Customer() {
	super();
}
public Customer(int id, int aid, Account acc, String firstname,
String lastname, String email, String password) {
	super();
	this.id = id;
	this.aid = aid;
	this.acc = acc;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public Account getAcc() {
	return acc;
}
public void setAcc(Account acc) {
	this.acc = acc;
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
	return "Customer [id=" + id + ", aid=" + aid + ", acc=" + acc + ", firstname=" + firstname + ", lastname="
			+ lastname + ", email=" + email + ", password=" + password + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
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
	Customer other = (Customer) obj;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	return true;
}



}
