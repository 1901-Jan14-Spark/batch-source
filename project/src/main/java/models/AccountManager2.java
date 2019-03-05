package models;

import java.io.Serializable;

public class AccountManager2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7344188993718931415L;
	private AccountHolder accountHolder;
	private Account account;
	
	@Override
	public String toString() {
		return "AccountManager2 [accountHolder=" + accountHolder + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((accountHolder == null) ? 0 : accountHolder.hashCode());
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
		AccountManager2 other = (AccountManager2) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (accountHolder == null) {
			if (other.accountHolder != null)
				return false;
		} else if (!accountHolder.equals(other.accountHolder))
			return false;
		return true;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountManager2(AccountHolder accountHolder, Account account) {
		super();
		this.accountHolder = accountHolder;
		this.account = account;
	}

	public AccountManager2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
