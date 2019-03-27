package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator calc = (Calculator) ac.getBean("calculator");
		
		
		System.out.println(calc.add(1, 3));
		System.out.println(calc.multiply(4, 5));
		System.out.println(calc.subtract(1, 8));		
		System.out.println(calc.divide(2, 1));
		
		System.out.println(calc.divide(2, 0));

	}

}
