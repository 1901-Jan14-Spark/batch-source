package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Driver {

	private static Logger log = Logger.getRootLogger();
	static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) {
		
//		log.trace("logging a trace");
//		log.debug("logging debug");
//		log.info("logging info");
//		log.warn("logging warn");
//		log.error("logging error");
//		log.fatal("logging fatal");
		
		calculate(5,6);
		calculate(0,0);
		

	}
	
	
	public static int calculate(int x, int y) {
		if(x==0 && y==0) {
			log.error("incorrect input, exception thrown");
			throw new RuntimeException();
		}
		int sum = x+y;
		log.info("calculation was successful! Added "+x+" and "+y+". Result was "+sum);
		return sum;
	}


}
