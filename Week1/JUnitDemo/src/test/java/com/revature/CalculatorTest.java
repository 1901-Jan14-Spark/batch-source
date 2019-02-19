package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void twoNumbersReturnSum() {
		int sum = Calculator.add("2,1");
		assertEquals(3, sum);
	}
	
	@Test
	public void singleValueReturned() {
		int sum = Calculator.add("7");
		assertEquals(7, sum);
	}
	
	@Test
	public void emptyStringReturnsZero() {
		int sum = Calculator.add("");
		assertEquals(0, sum);
	}
	
	@Test
	public void invalidInput() {
		int sum = Calculator.add("invalid input");
		assertEquals(-1, sum);
	}
	
//	@Test(expected=NumberFormatException.class)
	@Test
	public void invalidInput2() {
		int sum = Calculator.add("4,four");
		assertEquals(-1, sum);
	}
	
	@Test
//	@Ignore
	public void voidInput() {
		int sum = Calculator.add(null);
		assertEquals(-1, sum);
	}

}
