package dao;

import models.AccountHolder;

public interface AccountHolderDao {

	public AccountHolder getAccountHolderByUsername(String username);
	public void createAccountHolder(AccountHolder ah);
	public int updateAccountHolderLogin(AccountHolder ah);
	public int deleteAccountHolder(AccountHolder ah);
	
}
