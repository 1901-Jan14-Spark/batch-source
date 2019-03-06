package com.revature;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.AccountHolderDao;
import dao.AccountHolderDaoImpl;
import models.Account;
import models.AccountHandler;
import models.AccountManager2;
import util.InputValidator;

public class BankTester {

	static AccountDao ad = new AccountDaoImpl();
	static AccountHolderDao ahd = new AccountHolderDaoImpl();
	static AccountManager2 am = new AccountManager2(ahd.getAccountHolderByUsername("jtest1"));
	static Account test = ad.getAccountByID(60);
	static AccountManager2 am2 = new AccountManager2(ahd.getAccountHolderByUsername("jtest2"));
	static Account test2 = ad.getAccountByID(61);
	static AccountManager2 am3 = new AccountManager2(ahd.getAccountHolderByUsername("jtest3"));
	static Account test3 = ad.getAccountByID(62);
	// Cannot login into account that is already logged in.
	@Test
	public void preventMultipleSessionsOfSameAccountHolder() {
		AccountHandler ah = new AccountHandler();
		assertNull(ah.login("jtest", "123456789"));
	}

	// Can login
	@Test
	public void allowSingleSessionsOfSameAccountHolder() {
		AccountHandler ah = new AccountHandler();
		AccountManager2 ami = ah.login("jtest3", "123456789");
		assertNotNull(ami);
		ami.logout();
	}
	// Test deposit negative value
	@Test
	public void depositNegativeIntoAccount() {
		BigDecimal amount = new BigDecimal(-5);
		assertFalse(am2.deposit(amount, test2));
	}

	// Test withdraw positive value
	@Test
	public void withdrawNegativeFromAccount() {

		BigDecimal amount = new BigDecimal(-5);
		assertFalse(am.withdraw(amount, test));
	}
	
	// Test deposit positive value
		@Test
		public void depositpositiveIntoAccount() {
			BigDecimal amount = new BigDecimal(5);
			assertTrue(am2.deposit(amount, test2));
		}

		// Test withdraw positive value
		@Test
		public void withdrawPositiveFromAccount() {
			BigDecimal amount = new BigDecimal(5);
			assertTrue(am.withdraw(amount, test));
		}
		
		// Test overdraw prevention
		@Test
		public void overWithdrawFromAccount() {
			BigDecimal amount = new BigDecimal(1000000);
			assertFalse(am3.withdraw(amount, test3));
		}
		
		@Test
		public void passwordNeedNumber() {
			assertFalse(InputValidator.validatePassword("AslkjnalLALKndlaKNlKAN"));
		}
		@Test
		public void passwordNeedlowerCap() {
			assertFalse(InputValidator.validatePassword("ASKJAFBKDBF78787"));
		}
		@Test
		public void passwordNeedUpperCap() {
			assertFalse(InputValidator.validatePassword("kjsbksbf7246"));
		}
		@Test
		public void passwordNeedatLeast6() {
			assertFalse(InputValidator.validatePassword("Ae3"));
		}
		
		@Test
		public void validPassword() {
			assertTrue(InputValidator.validatePassword("asAs123"));
		}
		
		@Test
		public void nameNoNumber() {
			assertFalse(InputValidator.validateName("AslkjnalLALKndlaKNlKAN112"));
		}
		@Test
		public void validNumber() {
			assertTrue(InputValidator.validateName("Kevin"));
		}
		
}
