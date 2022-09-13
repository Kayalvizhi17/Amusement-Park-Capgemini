package com.amusementpark.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amusementpark.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
