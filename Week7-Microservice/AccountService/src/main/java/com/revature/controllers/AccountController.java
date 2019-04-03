package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	private Logger log = Logger.getLogger(AccountController.class);
	
	private List<Account> accounts = new ArrayList<>();
	
	public AccountController() {
		accounts.add(new Account(1,1,750.30));
		accounts.add(new Account(2,1,100.30));
		accounts.add(new Account(3,1,23.87));
		accounts.add(new Account(4,2,98.45));
		accounts.add(new Account(5,2,1200.45));
		accounts.add(new Account(6,3,75.90));
		accounts.add(new Account(7,3,3400.43));
		accounts.add(new Account(8,3,427.32));
	}

	@GetMapping
	public List<Account> getAllAccounts(){
		log.info("getting all accounts");
		return accounts;
	}
	
	@GetMapping("/{accountId}")
	public Account getAccountById(@PathVariable("accountId") Integer accountId) {
		log.info("getting account by id: " + accountId);
		for(Account a: accounts) {
			if(accountId == a.getAccountId()) {
				return a;
			}
		}
		return null;
	}
	
	@GetMapping("/customer/{customerId}")
	public List<Account> getAccountsByCustomerId(@PathVariable("customerId") Integer customerId){
		return accounts.stream().filter(acct -> acct.getCustomerId()==customerId)
				.collect(Collectors.toList());
	}
	
}
