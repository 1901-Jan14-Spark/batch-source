package com.revature.eval.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.revature.bank.Transactions;



public class BankTest {
	
	@Test
	public void makeDepositWorks() {
		double deposit = Transactions.makeDeposit(10.00, 5.00);
		assertEquals(15.00, deposit);
	}
	
	@Test
	public void makeWithdrawalWorks() {
		double withdrawal = Transactions.makeWithdrawal(10.00, 5.00);
		assertEquals(5.00, withdrawal);
	}
	
	
}
