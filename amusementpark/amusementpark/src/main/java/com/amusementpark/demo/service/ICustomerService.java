package com.amusementpark.demo.service;

import java.util.List;

import com.amusementpark.demo.entity.Customer;

public interface ICustomerService {
	public Customer insertCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	public Customer getCustomerById(Long customer_id);
	
	Customer updateCustomer(Customer customer,long customer_id);
	
	void deleteCustomer(long customer_id);
}
