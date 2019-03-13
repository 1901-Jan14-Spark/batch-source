package model;

public class ReqObj {
	private int rId;
	private int eId;
	private double amount;
	private String Desc;
	private int status;
	private int resovledBy;
	
	public ReqObj() {
		super();
	}

	public ReqObj(int rId, int eId, double amount, String desc, int status, int resovledBy) {
		super();
		this.rId = rId;
		this.eId = eId;
		this.amount = amount;
		Desc = desc;
		this.status = status;
		this.resovledBy = resovledBy;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getResovledBy() {
		return resovledBy;
	}

	public void setResovledBy(int resovledBy) {
		this.resovledBy = resovledBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Desc == null) ? 0 : Desc.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + eId;
		result = prime * result + rId;
		result = prime * result + resovledBy;
		result = prime * result + status;
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
		if (eId != other.eId)
			return false;
		if (rId != other.rId)
			return false;
		if (resovledBy != other.resovledBy)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReqObj [rId=" + rId + ", eId=" + eId + ", amount=" + amount + ", Desc=" + Desc + ", status=" + status
				+ ", resovledBy=" + resovledBy + "]";
	}
}
