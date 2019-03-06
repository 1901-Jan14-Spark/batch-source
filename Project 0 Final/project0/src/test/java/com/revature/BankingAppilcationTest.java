package com.revature;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.revature.dao.BankingAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.model.BankingAccount;
import com.revature.model.User;

//Used to test the methods used by the Banking Application
public class BankingAppilcationTest {
	//Testing the accessing of a user by id
	@Test
	public void testGetUserById() {
		UserDaoImpl udao = new UserDaoImpl();
		assertEquals(1, udao.getUserById(1).getId());
	}
	//Testing the accessing of a banking account by id
	@Test
	public void testGetAccountById() {
		BankingAccountDaoImpl bad = new BankingAccountDaoImpl();
		assertEquals(1, bad.getBankingAccountById(1).getAccountId());
	}
	//Testing the creation of a new user, it must not exist currently in the database
	@Test
	public void testCreateUser() {
		UserDaoImpl udao = new UserDaoImpl();
		BankingAccount bankAcc = new BankingAccount();
		User user = new User();
		bankAcc.setAccountId(60);
		bankAcc.setAccountType("Checking");
		bankAcc.setBalance(5000.00);
		user.setId(60);
		user.setUserName("testCaseUsername");
		user.setPassword("testCasePassword");
		user.setAccount(bankAcc);
		assertEquals(1, udao.createUser(user));
	}
	//Test the update of a balance when provided with more funds
	@Test
	public void testChangeAccountBalance() {
		BankingAccountDaoImpl bad = new BankingAccountDaoImpl();
		assertEquals(1, bad.changeAccountBalance(60, 500.00));
	}
	//Tests the delete of an Account after one is created,
	//must run testCreateUser first to run an accurate test with record in db
	@Test
	public void testDeleteAccount() {
		BankingAccountDaoImpl bad = new BankingAccountDaoImpl();
		assertEquals(1, bad.deleteAccount(60));
	}
}
