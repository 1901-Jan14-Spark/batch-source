package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;

public class Driver {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Bear b = (Bear) ac.getBean("bear");
		b.setAwake(false);
		b.setFull(false);
//		System.out.println(b);
		Bear.setWinter(true);
		b.bearHibernates();
		b.wakeBear();
		System.out.println(b);
	}

}
