package com.revature.dao;

import java.util.List;

import com.revature.model.AccountsHolder;


public interface AccountsHolderDao {
	
	public List<AccountsHolder> getUsers();
	public AccountsHolder validate(String id, String Pass);
	public AccountsHolder getUserById(String id, String Pass);
	public boolean createUser(AccountsHolder aU);	
	public int updateUser(AccountsHolder a);
	public int deleteUser(AccountsHolder a);
	
	

}
