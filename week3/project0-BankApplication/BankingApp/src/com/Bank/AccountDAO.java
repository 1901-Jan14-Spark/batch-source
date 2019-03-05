package com.Bank;

import java.util.ArrayList;
import java.util.List;


public interface AccountDAO {

	public void saveAccount(User user);
	public void updateAccount(ArrayList<User> updateArray);
	public  ArrayList<Account> retrieveUser();
	public ArrayList<Account> getUserList();
    public void setAccountList(ArrayList<Account> accountListT);
	
	public List<Account> getAccounts();
	public Account getAccountById(int id);
	public Account createAccountById(int id);
	
	
	
	
	
}
