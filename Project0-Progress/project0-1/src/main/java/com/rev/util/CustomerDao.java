package com.rev.util;

import java.util.HashMap;
import java.util.List;

public interface CustomerDao {

	public List<Customer> getCustomers();
	public Customer getCustomerById(int id);
	public int addCustomer(Customer c);
	public int updateCustomer(Customer c);
	public int deleteCustomer(int id);
	public void changeCustomerBalance(int id, double changeAmount);
	public  HashMap<String,String> getCustomerCredentials();
	public double getBalance(int id);
	public int getIdByname(String name);
	public int getIdByUser(String username);
	public void withdraw(int id, double bal);
	
	
}
