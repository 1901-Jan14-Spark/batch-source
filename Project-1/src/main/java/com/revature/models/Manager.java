package com.revature.models;

public class Manager {
	private int id;
	private String name;
	private String birthday;
	private int salary;
	private String position;
	private int reportsto;
	private String hireDate;
	private String username;
	private String password;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(int id, String name, String birthday, int salary, String position, int reportsto, String hireDate,
			String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
		this.position = position;
		this.reportsto = reportsto;
		this.hireDate = hireDate;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getReportsto() {
		return reportsto;
	}
	public void setReportsto(int reportsto) {
		this.reportsto = reportsto;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
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
	
	
	
	
}

