package com.revature.services;

public class CalculatorService {
	
	public int caculate(int n1, int n2, String op) {
		int result = 0;
		switch(op) {
		case "add":
			result = n1 + n2;
			break;
		case "subtract":
			result = n1 - n2;
			break;
		case "multiply":
			result = n1*n2;
			break;
		default:
			result = 0;
		}
		return result;
	}

}
