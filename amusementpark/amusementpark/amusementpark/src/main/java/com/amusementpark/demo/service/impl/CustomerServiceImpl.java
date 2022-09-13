package com.amusementpark.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amusementpark.demo.entity.Customer;
import com.amusementpark.demo.exception.CustomerException;
import com.amusementpark.demo.repository.CustomerRepository;
import com.amusementpark.demo.service.ICustomerService;


@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	CustomerRepository customerrepository;

	@Override
	public Customer insertCustomer(Customer customer) {
		return  customerrepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerrepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long customer_id) {
		
		java.util.Optional<Customer> customer=customerrepository.findById(customer_id);
		
		if(customer.isPresent())
		{
			return customer.get();
		}
		else
			throw new CustomerException("Not found");
		
	}

	@Override
	public Customer updateCustomer(Customer customer, long customer_id) {
		
		
		Customer existingcustomer=customerrepository.findById(customer_id).orElseThrow(() ->  new CustomerException("not found") );
		
		existingcustomer.setEmail(customer.getEmail());
		existingcustomer.setAddress(customer.getAddress());
		existingcustomer.setMobileNumber(customer.getMobileNumber());
		existingcustomer.setPassword(customer.getPassword());
		existingcustomer.setUsername(customer.getUsername());
		
		
		customerrepository.save(existingcustomer);
		return existingcustomer;
		
		
	}

	@Override
	public void deleteCustomer(long customer_id) {
		
		
		customerrepository.findById(customer_id).orElseThrow(() -> new CustomerException("not found"));
		
		
		customerrepository.deleteById(customer_id);
		
	}
}
