package dao;

import java.util.List;

import models.Accounts;

public interface AccountsDao {
	public List<Accounts> getAccounts();
	public Accounts getAccountByID(int id);
	public void deposit(int a, double deposit);
	public void withdraw(int a, double withdraw);
	public int deleteAccount(int id);
	 public int createAccount(Accounts a);


}
