package models;

public class Reimbursements {

	int reimbursementId;
	int emp_id;
	String content;
	int reimbursementAmount;
	int isResolved;
	String resolvedMessage;
	String mngResolved;
	
	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursements(int reimbursementId, int emp_id, String content, int reimbursementAmount, int isResolved,
			String resolvedMessage, String mngResolved) {
		super();
		this.reimbursementId = reimbursementId;
		this.emp_id = emp_id;
		this.content = content;
		this.reimbursementAmount = reimbursementAmount;
		this.isResolved = isResolved;
		this.resolvedMessage = resolvedMessage;
		this.mngResolved = mngResolved;
	}
	
	public Reimbursements(int reimbursementId, int emp_id, String content, int reimbursementAmount, int isResolved, String mngResolved) {
		super();
		this.reimbursementId = reimbursementId;
		this.emp_id = emp_id;
		this.content = content;
		this.reimbursementAmount = reimbursementAmount;
		this.isResolved = isResolved;
		this.mngResolved = mngResolved;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(int reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public int getIsResolved() {
		return isResolved;
	}

	public void setIsResolved(int isResolved) {
		this.isResolved = isResolved;
	}

	public String getResolvedMessage() {
		return resolvedMessage;
	}

	public void setResolvedMessage(String resolvedMessage) {
		this.resolvedMessage = resolvedMessage;
	}

	public String getMngResolved() {
		return mngResolved;
	}

	public void setMngResolved(String mngResolved) {
		this.mngResolved = mngResolved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + emp_id;
		result = prime * result + isResolved;
		result = prime * result + reimbursementAmount;
		result = prime * result + reimbursementId;
		result = prime * result + ((resolvedMessage == null) ? 0 : resolvedMessage.hashCode());
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
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (emp_id != other.emp_id)
			return false;
		if (isResolved != other.isResolved)
			return false;
		if (mngResolved != other.mngResolved)
			return false;
		if (reimbursementAmount != other.reimbursementAmount)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (resolvedMessage == null) {
			if (other.resolvedMessage != null)
				return false;
		} else if (!resolvedMessage.equals(other.resolvedMessage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursements [reimbursementId=" + reimbursementId + ", emp_id=" + emp_id + ", content=" + content
				+ ", reimbursementAmount=" + reimbursementAmount + ", isResolved=" + isResolved + ", resolvedMessage="
				+ resolvedMessage + ", mngResolved=" + mngResolved + "]";
	}
	
	
	
	
}
