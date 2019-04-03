package com.revature.controllers;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.AccountClient;
import com.revature.models.Account;
import com.revature.models.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private Logger log = Logger.getLogger(CustomerController.class);
	
	private List<Customer> customers = new ArrayList<>();
	
	@Autowired
	AccountClient accountClient;
	
	public CustomerController() {
		super();
		customers.add(new Customer(1, "Sally Jones", "sjonesie@gmail.com", null));
		customers.add(new Customer(2, "Paulina Jackson", "paulinaJ@gmail.com", null));
		customers.add(new Customer(3, "Ronald McCormick", "rmccormick@gmail.com", null));
	}
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		log.info("getting all customers");
		return customers;
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId")Integer customerId) {
		log.info("getting customer by id:" + customerId);
		Customer customer = customers.stream()
				.filter(cust -> cust.getCustomerId()==customerId)
				.findFirst().get();
		List<Account> accounts = accountClient.getAccountsByCustomerId(customerId);
		customer.setAccounts(accounts);
		return customer;
	}

}
