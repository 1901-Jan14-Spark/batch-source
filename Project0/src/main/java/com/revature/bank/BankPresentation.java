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
		
//		Connection c;
//		try {
//			c = ConnectionUtil.getConnection();
//			//System.out.println(c.getMetaData().getDriverName());
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		MemberDao ed = new MemberDaoImplementation();
//		int created = ed.addNewMember(new Member("David", "Van Alstine", "VanalstineDJ", "r4ndomP4ss1", "flamehrow3r@2kgod.com"));
//		System.out.println(created);
		
		Member m = ed.getMemberByAccountNumber("74873389"); 		
//		m.setFirstName("D.J.");
//		m.setLastName("Valentine");
//		m.setUserName("buck4ts");
//		m.setPassword("str4ightF!re");
//		m.setEmail("2kfl4megod@splash.com");
//		int updatedMember = ed.updateMemberInfo(m);
//		System.out.println(updatedMember);
		
		AccountDao ad = new AccountDaoImplementation();
		Account a = ad.getAccount("74873389");
		System.out.println(a);
//		int savings = ad.addNewAccount(new Account("74873389", "Savings", 25000.00));
//		System.out.println(savings);
		ad.makeDeposit(a, 2575.50);
		
		
	}
}
