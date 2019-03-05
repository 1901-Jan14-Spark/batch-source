package dao;

import java.util.List;

import models.Account;
import models.AccountHolder;

public interface AccountManagerDao {

	public List<Account> getAccountsAssociated(AccountHolder ah);
	public void assignAccount(Account a, AccountHolder ah);
	public int deleteAssignedAccount(Account a, AccountHolder ah);
	
}
