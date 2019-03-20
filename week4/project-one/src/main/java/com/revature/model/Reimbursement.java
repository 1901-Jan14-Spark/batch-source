package com.revature.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {

	
	private int rID;
	private int Eid;
	private String description;
	private BigDecimal  amount;
	private Date submittedDate;
	private int approvalStatus;
	private String approver;
	private Blob receipts;
	private Date lastActivity;
	public int getrID() {
		return rID;
	}
	public void setrID(int rID) {
		this.rID = rID;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
	public int getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public Blob getReceipts() {
		return receipts;
	}
	public void setReceipts(Blob receipts) {
		this.receipts = receipts;
	}
	public Date getLastActivity() {
		return lastActivity;
	}
	public void setLastActivity(Date lastActivity) {
		this.lastActivity = lastActivity;
	}
	@Override
	public String toString() {
		return "Reimbursement [rID=" + rID + ", Eid=" + Eid + ", description=" + description + ", amount=" + amount
				+ ", submittedDate=" + submittedDate + ", approvalStatus=" + approvalStatus + ", approver=" + approver
				+ ", receipts=" + receipts + ", lastActivity=" + lastActivity + "]";
	}
	
	
	
	
	
	
	
}
