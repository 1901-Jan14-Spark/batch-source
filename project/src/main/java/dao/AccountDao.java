package dao;

import java.util.List;

import models.Account;

public interface AccountDao {

	public List<Account> getAccounts();

	public Account getAccountByID(int id);

	public Account createAccount(Account a);

	public int updateAccountBalance(Account a);
	
	public int getAccSeq();


}
