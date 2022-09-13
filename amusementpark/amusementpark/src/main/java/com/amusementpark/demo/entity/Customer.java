package com.amusementpark.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	public Long customer_id;
	@Column
	
	// The username should not be empty or null
	// username should have atleast 2 characters.
	
	
	@NotNull
	@Size(min=2, message="username should have atleast 2 values")
	private String username;
	@Column
	
	// The password should not be empty or null.
	// password should contain 8 characters
	
	
	@NotNull
	@Size(min=8, message="password should contain 8 characters")
	private String password;
	@Column
	
	@NotNull(message="cannot be null")
	private String address;
	@Column
	
	//Mobile number should not be null
	// Mobile number should be of 10 digits.
	
	@NotNull
	@Size(min=10,max=10,message="wrong phone number")
	private String mobileNumber;
	@Column
	// Email should be in correct format.
	@Email
	private String email;
	
	
	
	public Customer() {
		super();
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public Customer(Long customer_id, String username, String password, String address, String mobileNumber,
			String email) {
		super();
		this.customer_id = customer_id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
}
