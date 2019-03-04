package com.rev.main;

import java.util.List;

import com.rev.util.Customer;
import com.rev.util.CustomerDao;
import com.rev.util.CustomerDaoImpl;

public class Driver {

	public static void main(String[] args) {
		
		CustomerDao cus1 = new CustomerDaoImpl();
		
//		int creat = cus1.addCustomer(new Customer(1,"George",200.01,"GG","fancypants1"));
//		System.out.println(creat);
		
		
		List<Customer> customers = cus1.getCustomers();
		for(Customer c: customers) {
			System.out.println(c);
		}
	}
	
}
