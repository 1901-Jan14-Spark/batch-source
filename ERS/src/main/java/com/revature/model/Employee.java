package com.revature.model;

public class Employee {

	private int id;
	private String email;
	private String pass;
	private String fname;
	private String lname;
	private int reportsto;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String email, String pass, String fname, String lname, int reportsto) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.fname = fname;
		this.lname = lname;
		this.reportsto = reportsto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getReportsto() {
		return reportsto;
	}

	public void setReportsto(int reportsto) {
		this.reportsto = reportsto;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", pass=" + pass + ", fname=" + fname + ", lname=" + lname
				+ ", reportsto=" + reportsto + "]";
	}
	
}
