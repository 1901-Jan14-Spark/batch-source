package com.revature.model;

import java.sql.Date;

public class Employee {
	
	private int id;
	private String name;
	private Date birthday;
	private double monthlySalary;
	private Date hireDate;
	private String position;
	private int managerId;
	private Department department;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, Date birthday, double monthlySalary, Date hireDate, String position,
			int managerId, int departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.monthlySalary = monthlySalary;
		this.hireDate = hireDate;
		this.position = position;
		this.managerId = managerId;
		if(departmentId>0) {
			this.department = new Department(departmentId);			
		}
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(float monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + id;
		result = prime * result + managerId;
		long temp;
		temp = Double.doubleToLongBits(monthlySalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (id != other.id)
			return false;
		if (managerId != other.managerId)
			return false;
		if (Double.doubleToLongBits(monthlySalary) != Double.doubleToLongBits(other.monthlySalary))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthday=" + birthday + ", monthlySalary=" + monthlySalary
				+ ", hireDate=" + hireDate + ", position=" + position + ", managerId=" + managerId + ", department=" + department + "]";
	}

	
}
