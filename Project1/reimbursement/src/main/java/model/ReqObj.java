package model;

public class ReqObj {
	private int rId;
	private String eName;
	private String email;
	private String Desc;
	private double amount;
	private String status;
	private EmpObj resolvedBy;
	
	public ReqObj() {
		super();
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}
	
	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
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

	public EmpObj getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(EmpObj resovledBy) {
		this.resolvedBy = resovledBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Desc == null) ? 0 : Desc.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + rId;
		result = prime * result + ((resolvedBy == null) ? 0 : resolvedBy.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ReqObj other = (ReqObj) obj;
		if (Desc == null) {
			if (other.Desc != null)
				return false;
		} else if (!Desc.equals(other.Desc))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (rId != other.rId)
			return false;
		if (resolvedBy == null) {
			if (other.resolvedBy != null)
				return false;
		} else if (!resolvedBy.equals(other.resolvedBy))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReqObj [rId=" + rId + ", eName=" + eName + ", email=" + email + ", Desc=" + Desc + ", amount=" + amount
				+ ", status=" + status + ", resolvedBy=" + resolvedBy + "]";
	}

}
