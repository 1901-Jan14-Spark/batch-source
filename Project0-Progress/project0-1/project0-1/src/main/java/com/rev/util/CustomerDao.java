package com.rev.util;

import java.util.HashMap;
import java.util.List;

public interface CustomerDao {

	public List<Customer> getCustomers();
	public Customer getCustomerById(int id);
	public int addCustomer(Customer c);
	public int updateCustomer(Customer c);
	public int deleteCustomer(int id);
	public void changeCustomerBalance(Customer c, double changeAmount);
	public  HashMap<String,String> getCustomerCredentials();
	
	
}
