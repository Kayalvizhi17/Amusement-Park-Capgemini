package com.amusementpark.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amusementpark.demo.entity.Customer;
import com.amusementpark.demo.service.ICustomerService;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	ICustomerService customerservice;
	
	// build create Customer REST API
	@PostMapping()
	 public ResponseEntity<Customer> insertCustomer(@Valid@RequestBody Customer customer)
	{
			return new ResponseEntity<Customer>(customerservice.insertCustomer(customer), HttpStatus.CREATED);
	}
	
	// build get Customer REST API
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerservice.getAllCustomer();
	}
	
	// build get Customer By id REST API
	// http://localhost:8090/api/customer/1
	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long customer_id)
	{
		return new ResponseEntity<Customer>(customerservice.getCustomerById(customer_id),HttpStatus.OK);
	}
	
	//build update Customer REST API
	// http://localhost:8090/api/customer/1
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long customer_id,
			@RequestBody Customer customer){
		
		return new ResponseEntity<Customer>(customerservice.updateCustomer(customer,customer_id),HttpStatus.OK);
	}
	
	//build delete Customer REST API
	// http://localhost:8090/api/customer/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long customer_id){
		
		customerservice.deleteCustomer(customer_id);
		
		return new ResponseEntity<String>("Customer deleted succesfully", HttpStatus.OK);
		
	}
	
	
	

}
