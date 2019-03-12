package com.revature;

public class Calculator {
	
	/*
	 * We're going to take a calculator which accepts a string input and returns an int
	 * 
	 * We want the method to take in 0, 1, or 2 numbers delimited by a comma 
	 * 
	 * If we provide 0 numbers (empty string), we want it to return a 0
	 * If we provide 1 number, we want it to return that number
	 * If we provide 2 numbers, we want it to return their sum
	 * If we provide an invalid or null input, we want it to return -1
	 * 
	 */

	
	public static int add(String input) {
		int sum = 0;
		if(input == null) {
			return -1;
		}
		if("".equals(input)) {
			return sum;
		}
		
		String[] numberArr = input.trim().split(",");
		
		if(numberArr.length == 1) {
			try {
				sum = Integer.parseInt(numberArr[0]);
			} catch (NumberFormatException e) {
				sum = -1;
			}
		}
		
		if(numberArr.length == 2) {
			try {
				sum = Integer.parseInt(numberArr[0])+Integer.parseInt(numberArr[1]);
			} catch (NumberFormatException e) {
				sum = -1;
			}
		}
		
		return sum;
	}
}
