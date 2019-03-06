package com.revature.dao;
import java.util.List;

import com.revature.model.Customer;
public interface CustomerDao {
	public Customer getCustomerByEmail(String email);
	public int createCustomer(Customer cust);
	public List<Customer> getAllCustomers();
}
