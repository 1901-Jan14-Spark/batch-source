package models;

import java.io.Serializable;

public class Reimbursements implements Serializable{
		private static final long serialVersionUID = 3371139462704636235L;
		
	private int reim_id;
	private String reim_name;
	private int requester_Id;
	private double amount;
	private String reimStatus;
	private int resolvedId;
	public int getReim_id() {
		return reim_id;
	}
	public void setReim_id(int reim_id) {
		this.reim_id = reim_id;
	}
	public String getReim_name() {
		return reim_name;
	}
	public void setReim_name(String reim_name) {
		this.reim_name = reim_name;
	}
	public int getRequester_Id() {
		return requester_Id;
	}
	public void setRequester_Id(int requester_Id) {
		this.requester_Id = requester_Id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReimStatus() {
		return reimStatus;
	}
	public void setReimStatus(String reimStatus) {
		this.reimStatus = reimStatus;
	}
	public int getResolvedId() {
		return resolvedId;
	}
	public void setResolvedId(int resolvedId) {
		this.resolvedId = resolvedId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimStatus == null) ? 0 : reimStatus.hashCode());
		result = prime * result + reim_id;
		result = prime * result + ((reim_name == null) ? 0 : reim_name.hashCode());
		result = prime * result + requester_Id;
		result = prime * result + resolvedId;
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
		Reimbursements other = (Reimbursements) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (reimStatus == null) {
			if (other.reimStatus != null)
				return false;
		} else if (!reimStatus.equals(other.reimStatus))
			return false;
		if (reim_id != other.reim_id)
			return false;
		if (reim_name == null) {
			if (other.reim_name != null)
				return false;
		} else if (!reim_name.equals(other.reim_name))
			return false;
		if (requester_Id != other.requester_Id)
			return false;
		if (resolvedId != other.resolvedId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursements [reim_id=" + reim_id + ", reim_name=" + reim_name + ", requester_Id=" + requester_Id
				+ ", amount=" + amount + ", reimStatus=" + reimStatus + ", resolvedId=" + resolvedId + "]";
	}
	public Reimbursements(int reim_id, String reim_name, int requester_Id, double amount, String reimStatus,
			int resolvedId) {
		super();
		this.reim_id = reim_id;
		this.reim_name = reim_name;
		this.requester_Id = requester_Id;
		this.amount = amount;
		this.reimStatus = reimStatus;
		this.resolvedId = resolvedId;
	}
	public Reimbursements() {
		super();
	}
	public Reimbursements(String reim_name, int requester, double amount) {
		this.reim_name=reim_name;
		this.requester_Id=requester;
		this.amount=amount;
	}
	public Reimbursements(int reimId, String reimName, int requester, double amount, String status,
			String resovedBy) {
		this.reim_id=reimId;
		this.reim_name=reimName;
		this.requester_Id=requester;
		this.amount=amount;
		this.reimStatus=status;
		
	}
	
		
		
		
}
