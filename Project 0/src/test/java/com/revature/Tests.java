package com.revature;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.AccountManager;
import com.revature.bankapp.models.User;
import com.revature.bankapp.util.ConnectionUtil;

public class Tests {
	
	static List<Account> testList = new ArrayList<Account>();
	
	@BeforeClass
	public static void createMockData() {
//		User mockUser = new User(new Account(new BigDecimal(500.15)));
		testList.add(new Account(new BigDecimal(500.15)));
		
		String sql = "{call INSERT_MOCKACC(?,?)}";
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				CallableStatement cs = con.prepareCall(sql)){
			
			cs.setString(1, "Bobby");
			cs.setBigDecimal(2, testList.get(0).getBalance());
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@AfterClass
//	public static void removeMockData() {
//		String sql = "ALTER ACCOUNTS"
//		
//	}
	
	@Test
	public void twoNumbersDeposit() {
		BigDecimal result = AccountManager.addDeposit(testList.get(0).getAccountId(), new BigDecimal(500));
		result = result.setScale(2, RoundingMode.CEILING);
		BigDecimal expected = testList.get(0).getBalance().add(new BigDecimal(500));
		expected = expected.setScale(2, RoundingMode.CEILING);
		assertEquals(expected, result);
	}
	
	@Test
	public void twoDecimals() {
		BigDecimal currentBalance = new BigDecimal(500.77);
		BigDecimal depositAmount = new BigDecimal(300.40);
//		BigDecimal result = AccountManager.addDepositJUnit(currentBalance, depositAmount);
//		result = result.setScale(2, RoundingMode.CEILING);
//		System.out.println(result);
//		BigDecimal expected = new BigDecimal(801.17);
//		expected = expected.setScale(2, RoundingMode.CEILING);
//		assertEquals(expected, result);
	}
	
//	@Test
//	public void negativeDeposit() {
//		BigDecimal currentBalance = new BigDecimal(300.00);
//		BigDecimal depositAmount = new BigDecimal(-300.00);
//		BigDecimal result = AccountManager.addDepositJUnit(currentBalance, depositAmount);
//		result = result.setScale(2, RoundingMode.CEILING);
//		System.out.println(result);
//		BigDecimal expected = new BigDecimal(0);
//		expected = expected.setScale(2, RoundingMode.CEILING);
//		assertEquals(expected, result);
//	}
}
