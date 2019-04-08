package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.dao.AccountDaoImpl;
import com.revature.models.Account;

import com.revature.models.User;

public class BankTest {
	
	Account dummyAcc = new Account(new User("abc@123.com", "abc", "def", "123"), 100, 100);
	
	@Test
	public void checkdeposit() {
		double test = 50;
		int result = (int) AccountDaoImpl.junitTestDeposit(dummyAcc, test);
		
		assertEquals(150, result);
	}
	
	@Test
	public void checkwithdraw() {
		double test = 50;
		int result = (int) AccountDaoImpl.junitTestWithdraw(dummyAcc, test);
		
		assertEquals(50, result);
	}
}
