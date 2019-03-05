package models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6762939949521618547L;

	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Account(int id, int type, BigDecimal balance) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
	}

	private int id;
	private int type;
	private BigDecimal balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", balance=" + balance + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + id;
		result = prime * result + type;
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
		Account other = (Account) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	
}