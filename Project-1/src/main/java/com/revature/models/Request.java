package com.revature.models;

import oracle.sql.DATE;

public class Request {
	private int id;
	private String empName;
	private String category;
	private int cost;
	private String merchant;
	private String purchaseDate;
	private int approvedBy;
	private int deniedBy;
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(int id, String empName, String category, int cost, String merchant, String purchaseDate,
			int approvedBy, int deniedBy) {
		super();
		this.id = id;
		this.empName = empName;
		this.category = category;
		this.cost = cost;
		this.merchant = merchant;
		this.purchaseDate = purchaseDate;
		this.approvedBy = approvedBy;
		this.deniedBy = deniedBy;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}
	public int getDeniedBy() {
		return deniedBy;
	}
	public void setDeniedBy(int deniedBy) {
		this.deniedBy = deniedBy;
	}
	
	
}
