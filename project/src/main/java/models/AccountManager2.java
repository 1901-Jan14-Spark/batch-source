package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.AccountHolderDao;
import dao.AccountHolderDaoImpl;
import dao.AccountManagerDao;
import dao.AccountManagerDaoImpl;
import dao.TransactionDao;
import dao.TransactionDaoImpl;

public class AccountManager2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7344188993718931415L;
	private AccountHolder accountHolder;
	private List<Account> accounts;
	private AccountManagerDao amd = new AccountManagerDaoImpl();
	private AccountHolderDao ahd = new AccountHolderDaoImpl();
	private AccountDao ad = new AccountDaoImpl();
	private TransactionDao td =new TransactionDaoImpl();

	public AccountManager2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountManager2(AccountHolder accountHolder) {
		super();
		this.accountHolder = accountHolder;
		this.accounts = amd.getAccountsAssociated(accountHolder);
	}

public boolean transfer(BigDecimal amount, Account b, Account c) {
		
		if(amount.intValue() < 0) {
			return false;
		}
		if(b == null || !accounts.contains(b) || c ==null) {
			return false;
		}
		if(b.getBalance().subtract(amount).intValue() < 0) {
			return false;
		}
		b.setBalance(b.getBalance().subtract(amount));
		c.setBalance(c.getBalance().add(amount));
		ad.updateAccountBalance(b);
		ad.updateAccountBalance(c);
		td.createTransaction(b, amount.negate(), "Transfer Out to: " + c.getId());
		td.createTransaction(c, amount, "Transfer in from: " + b.getId()); 
		return true;
	}
	
	public boolean deposit(BigDecimal amount, Account b) {
		if(amount.intValue() < 0) {
			return false;
		}
		if(b == null || !accounts.contains(b)) {
			return false;
		}
		b.setBalance(b.getBalance().add(amount));
		ad.updateAccountBalance(b);
		td.createTransaction(b, amount, "Deposit"); 
		return true;
	}
	
	public boolean withdraw(BigDecimal amount, Account b) {
		
		if(amount.intValue() < 0) {
			return false;
		}
		if(b == null || !accounts.contains(b)) {
			return false;
		}
		if(b.getBalance().subtract(amount).intValue() < 0) {
			return false;
		}
		b.setBalance(b.getBalance().subtract(amount));
		ad.updateAccountBalance(b);
		td.createTransaction(b, amount.negate(), "Withdrawal"); 
		return true;
	}
	public void printAccounts() {
		System.out.println("Please select an account by id.");
	for(Account a : accounts) {
		System.out.println(a);
	}
	}
	
	public AccountManager2(AccountHolder accountHolder, List<Account> accounts) {
		super();
		this.accountHolder = accountHolder;
		this.accounts = accounts;
	}


	public AccountHolder getAccountHolder() {
		return accountHolder;
	}


	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}


	public List<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


	@Override
	public String toString() {
		return "AccountManager2 [accountHolder=" + accountHolder + ", accounts=" + accounts + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountHolder == null) ? 0 : accountHolder.hashCode());
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
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
		if (accountHolder == null) {
			if (other.accountHolder != null)
				return false;
		} else if (!accountHolder.equals(other.accountHolder))
			return false;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		return true;
	}
	
	public boolean logout() {
		ahd.updateAccountHolderLogin(accountHolder);
		return true;
	}
	
	public boolean accessAccount(int accId) {
		for(Account a : accounts) {
			if(a.getId() == accId) {
				return false;
			}
		} 
		Account tempAccount = ad.getAccountByID(accId);
		if(tempAccount == null) {
			return false;
		}
		amd.assignAccount(tempAccount, accountHolder);
		this.accounts = amd.getAccountsAssociated(accountHolder);
		return true;
	
	}
}
