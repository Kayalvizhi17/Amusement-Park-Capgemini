package com.amusementpark.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amusementpark.demo.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
