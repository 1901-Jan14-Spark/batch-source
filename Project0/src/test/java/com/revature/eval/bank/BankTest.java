package com.revature.eval.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.revature.bank.Member;
import com.revature.bank.Transactions;



public class BankTest {
	
	private static final Transactions banktransactions = new Transactions();
	
	@Test
	public void checkDepositAmount() {
		Member m = new Member();
		
		
	}
	
	
	
	@Test
	public void checkWithdrawal() {
		double withdrawal = Transactions.makeWithdrawal(10.00, 5.00);
		assertEquals(5.00, withdrawal);
	}
	
	
}
