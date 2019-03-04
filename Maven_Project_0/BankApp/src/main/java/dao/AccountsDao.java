package dao;

import java.util.List;

import models.Accounts;

public interface AccountsDao {
	public List<Accounts> getAccounts();
	public Accounts getAccountByID(int id);
	public int updateAccount(Accounts a);
	public int deleteAccount(int id);

}
