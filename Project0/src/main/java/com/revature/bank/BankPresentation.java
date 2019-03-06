package com.revature.bank;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImplementation;
import com.revature.dao.MemberDao;
import com.revature.dao.MemberDaoImplementation;
import com.revature.util.ConnectionUtil;

public class BankPresentation {

	public static void main(String[] args) {

		MemberDao md = new MemberDaoImplementation();
//		List<Member> currentMembers = md.getAllMembers();
//		for(Member m : currentMembers) {
//			System.out.println(m);
//			System.out.println();
//		}
		
		
		AccountDao ad = new AccountDaoImplementation();
//		int checkings = ad.addNewAccount(new Account("19052594", "Checkings", 1500.00));
//		System.out.println(checkings);
//		int savings = ad.addNewAccount(new Account("19052594", "Savings", 50000.00));
//		System.out.println(savings);
		
//		Account a3 = ad.getAccountByAccountType("17263238", "Savings");
//		System.out.println(a3);
//		ad.makeDeposit("19052594", "Checkings", 2000.55);
//		ad.makeDeposit("17263238", "Checkings", 274.25);
//		ad.makeWithdrawal("17263238", "Savings", 4299.99);
		ad.makeWithdrawal("19052594", "Checkings", 0.55);
		
		
		
	}
}
