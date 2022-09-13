package com.amusementpark.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amusementpark.demo.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
