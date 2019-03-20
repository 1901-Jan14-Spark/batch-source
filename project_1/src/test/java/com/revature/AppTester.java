package com.revature;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.services.LoginService;
import com.revature.services.ReimbursementService;
import com.revature.utils.InputValidator;

public class AppTester {

	LoginService ls = new LoginService();
	EmployeeService es = new EmployeeService();
	ReimbursementService rs = new ReimbursementService();

	@Test
	public void getReimbursementById() {
		Reimbursement temp = rs.getReimbursementById(400000000);
		assertNotNull(temp);
	}

	@Test
	public void getEmployee() {
		Employee e = es.getEmployeeByEmail("mbiever4@friendfeed.com");
		assertNotNull(e);
	}

	@Test
	public void loginAccountHolder() {
		Employee ami = ls.login("mbiever4@friendfeed.com", "M1nTxV");
		assertNotNull(ami);
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
