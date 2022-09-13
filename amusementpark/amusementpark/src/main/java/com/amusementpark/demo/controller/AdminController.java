package com.amusementpark.demo.controller;

import java.util.List;
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

import com.amusementpark.demo.entity.Activity;
import com.amusementpark.demo.entity.Admin;
import com.amusementpark.demo.service.IAdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	IAdminService adminservice;
	
	public AdminController(IAdminService adminservice) {
		super();
		this.adminservice = adminservice;
	}
	
	// build create Admin REST API
    @PostMapping
    public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin) 
    {
        return new ResponseEntity<Admin>(adminservice.insertAdmin(admin), HttpStatus.CREATED);
    }
	
    // build get all activity REST API
    @GetMapping
    public List<Activity> getAllActivities() {
        return adminservice.getAllActivities();
    }
	
     // build get admin by Id REST API
    // http://localhost:8090/api/admin/1
    @GetMapping("{id}")
     public ResponseEntity<Admin> viewAdminById(@PathVariable("id") long adminId){
     return new ResponseEntity<Admin>(adminservice.viewAdminById(adminId), HttpStatus.OK);
     }
	
    // build update admin REST API
    // http://localhost:8090/api/admin/1
    @PutMapping("{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long adminId, @RequestBody Admin admin){
    	return new ResponseEntity<Admin>(adminservice.updateAdmin(admin, adminId), HttpStatus.OK);
    }
	
    //build delete admin REST API
    // http://localhost:8090/api/admin/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") long adminId){
			
    	//delete Admin from DB
    	adminservice.deleteAdmin(adminId);
    	return new ResponseEntity<String>("Admin Deleted Successfully", HttpStatus.OK);
    }
}
