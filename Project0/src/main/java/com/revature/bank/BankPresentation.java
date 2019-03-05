package com.revature.bank;

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
//		int created = md.addNewMember(new Member("David", "Van Alstine", "VanalstineDJ", "r4ndomP4ss1", "flamehrow3r@2kgod.com"));
//		System.out.println(created);
		
//		Member m = md.getMemberByAccountNumber("17263238");
//		m.setAccountNumber("17263238");
//		m.setFirstName("D.J.");
//		m.setLastName("Valentine");
//		m.setUserName("buck4ts");
//		m.setPassword("str4ightF!re");
//		m.setEmail("2kfl4megod@splash.com");	
//		int updatedMember = md.updateMemberInfo(m);
//		System.out.println(updatedMember);
		
//		int newMember = md.addNewMember(new Member("David", "Van Alstine", "VanalstineDJ", "r4ndomP4ss1", "flamehrow3r@2kgod.com"));
//		System.out.println(newMember);
		
		AccountDao ad = new AccountDaoImplementation();
//		int checkings = ad.addNewAccount(new Account("17263238", "Checkings", 3500.00));
//		System.out.println(checkings);
		int savings = ad.addNewAccount(new Account("17263238", "Savings", 25000.00));
		System.out.println(savings);
//		ad.makeDeposit(a, 2575.50);
		
		
	}
}
