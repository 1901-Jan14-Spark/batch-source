package model;

public class EmpObj {
	private int eId;
	private String eName;
	private String ePass;
	private String email;
	
	public EmpObj() {
		super();
	}

	public EmpObj(int eId) {
		super();
		this.eId = eId;
	}

	public EmpObj(int eId, String eName, String email) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.email = email;
	}
	
	public EmpObj(int eId, String eName, String ePass, String email) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.ePass = ePass;
		this.email = email;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getePass() {
		return ePass;
	}

	public void setePass(String ePass) {
		this.ePass = ePass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eId;
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + ((ePass == null) ? 0 : ePass.hashCode());
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
		EmpObj other = (EmpObj) obj;
		if (eId != other.eId)
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (ePass == null) {
			if (other.ePass != null)
				return false;
		} else if (!ePass.equals(other.ePass))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmpObj [eId=" + eId + ", eName=" + eName + ", ePass=" + ePass + ", email=" + email + "]";
	}
}
