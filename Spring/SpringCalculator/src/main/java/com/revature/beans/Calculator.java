package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
		
	public int add(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	
	public int subtract(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
	
	public int multiply(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}
	
	public int divide(int num1, int num2) {
		if(num1 == 0 || num2 == 0) {
			throw new RuntimeException("You can't divide by 0!");
		} else {
			int result  = (num1 / num2);
			return result;
		}
	}

}
