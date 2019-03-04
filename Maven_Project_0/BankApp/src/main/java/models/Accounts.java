package models;

import java.io.Serializable;

public class Accounts implements Serializable{

	private static final long serialVersionUID = -5249102949430143029L;
private int accNum;
private String accType;
private double balance;
public int getAccNum() {
	return accNum;
}
public void setAccNum(int accNum) {
	this.accNum = accNum;
}
public String getAccType() {
	return accType;
}
public void setAccType(String accType) {
	this.accType = accType;
}
public double getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + accNum;
	result = prime * result + ((accType == null) ? 0 : accType.hashCode());
	long temp;
	temp = Double.doubleToLongBits(balance);
	result = prime * result + (int) (temp ^ (temp >>> 32));
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
	Accounts other = (Accounts) obj;
	if (accNum != other.accNum)
		return false;
	if (accType == null) {
		if (other.accType != null)
			return false;
	} else if (!accType.equals(other.accType))
		return false;
	if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
		return false;
	return true;
}
@Override
public String toString() {
	return "Accounts [accNum=" + accNum + ", accType=" + accType + ", balance=" + balance + "]";
}
public Accounts(int accNum, String accType, double balance) {
	super();
	this.accNum = accNum;
	this.accType = accType;
	this.balance = balance;
}
public Accounts() {
	super();
	// TODO Auto-generated constructor stub
}

}
