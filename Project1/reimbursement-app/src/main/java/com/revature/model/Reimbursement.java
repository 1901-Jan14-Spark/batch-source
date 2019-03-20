package com.revature.model;
import java.util.Arrays;
import java.util.Date;

import com.revature.model.Employee;
public class Reimbursement {
    private int tId;
    private Employee employee;
	private String tOption;
	private String reqCom;
	private String resCom;
	private double amount;
	private String status;
	private Date subDate;
	private Date decDate;
	private Employee manager;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int tId, Employee employee, String tOption, String reqCom, String resCom, double amount,
			String status, Date subDate, Date decDate, Employee manager) {
		super();
		this.tId = tId;
		this.employee = employee;
		this.tOption = tOption;
		this.reqCom = reqCom;
		this.resCom = resCom;
		this.amount = amount;
		this.status = status;
		this.subDate = subDate;
		this.decDate = decDate;
		this.manager = manager;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String gettOption() {
		return tOption;
	}
	public void settOption(String tOption) {
		this.tOption = tOption;
	}
	public String getReqCom() {
		return reqCom;
	}
	public void setReqCom(String reqCom) {
		this.reqCom = reqCom;
	}
	public String getResCom() {
		return resCom;
	}
	public void setResCom(String resCom) {
		this.resCom = resCom;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSubDate() {
		return subDate;
	}
	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}
	public Date getDecDate() {
		return decDate;
	}
	public void setDecDate(Date decDate) {
		this.decDate = decDate;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Reimbursement [tId=" + tId + ", employee=" + employee.toString() + ", tOption=" + tOption + ", reqCom=" + reqCom
				+ ", resCom=" + resCom + ", amount=" + amount + ", status=" + status + ", subDate=" + subDate
				+ ", decDate=" + decDate + ", manager=" + manager.toString() + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		else if(tId != other.tId)
			return false;
		return true;
	}
}
