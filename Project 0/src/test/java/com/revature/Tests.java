package com.revature;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bankapp.dao.UserDao;
import com.revature.bankapp.dao.UserDaoImpl;
import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.AccountManager;
import com.revature.bankapp.models.User;
import com.revature.bankapp.util.ConnectionUtil;

public class Tests {
	
	static List<User> list = new ArrayList<User>();
	static UserDao userDao2 = new UserDaoImpl();
	static Account mockAcc = new Account(new BigDecimal(400.15));
	static User mockUser = new User("JUnitTest", mockAcc);
	static int ourId;
	static BigDecimal ourBal;

	@Before
	public void createMockData() {
		list.add(mockUser);
		
		String sql = "{call INSERT_MOCKACC(?,?)}";
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				CallableStatement cs = con.prepareCall(sql)){
			
			cs.setString(1, mockUser.getUsername());
			cs.setBigDecimal(2, mockAcc.getBalance());
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void removeMockAcc() {
		int deleteId = 0;
		deleteId = userDao2.returnId(list.get(0).getUsername());
		String sql = "{call DELETE_MOCKACC(?)}";
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				CallableStatement cs = con.prepareCall(sql)){
			
			cs.setInt(1, deleteId);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void removeMockUser() {
		String sql = "{call DELETE_MOCKUSER}";
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				CallableStatement cs = con.prepareCall(sql)){
			
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTwoNumbersDeposit() {
		int holdId = 0;
		holdId = userDao2.returnId(list.get(0).getUsername());
		BigDecimal result = AccountManager.addDeposit(holdId, new BigDecimal(500));
		result = result.setScale(2, RoundingMode.CEILING);
		BigDecimal expected = mockAcc.getBalance().add(new BigDecimal(500));
		expected = expected.setScale(2, RoundingMode.CEILING);
		assertEquals(expected, result);
	}
	
	@Test
	public void twoDecimals() {
		int holdId = 0;
		holdId = userDao2.returnId(list.get(0).getUsername());
		BigDecimal result = AccountManager.addDeposit(holdId, new BigDecimal(599.15));
		result = result.setScale(2, RoundingMode.CEILING);
		BigDecimal expected = mockAcc.getBalance().add(new BigDecimal(599.15));
		expected = expected.setScale(2, RoundingMode.CEILING);
		assertEquals(expected, result);
	}
	
	@Test
	public void testTwoNumbersWithdraw() {
		int holdId = 0;
		holdId = userDao2.returnId(list.get(0).getUsername());
		BigDecimal result = AccountManager.processWithdrawal(holdId, new BigDecimal(300));
		result = result.setScale(2, RoundingMode.CEILING);
		BigDecimal expected = mockAcc.getBalance().subtract(new BigDecimal(300));
		expected = expected.setScale(2, RoundingMode.CEILING);
		assertEquals (expected, result);
	}
	
	@Test
	public void testNegativeWithdraw() {
		int holdId = 0;
		holdId = userDao2.returnId(list.get(0).getUsername());
		BigDecimal result = AccountManager.processWithdrawal(holdId, new BigDecimal(-500));
		result = result.setScale(2, RoundingMode.CEILING);
		BigDecimal expected = mockAcc.getBalance().subtract(new BigDecimal(-500));
		expected = expected.setScale(2, RoundingMode.CEILING);
		assertEquals (expected, result);
	}
	

	
}
