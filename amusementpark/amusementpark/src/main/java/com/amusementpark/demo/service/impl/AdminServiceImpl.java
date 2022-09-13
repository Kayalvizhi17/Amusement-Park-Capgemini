package com.amusementpark.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amusementpark.demo.entity.Activity;
import com.amusementpark.demo.entity.Admin;
import com.amusementpark.demo.exception.ResourceNotFoundException;
import com.amusementpark.demo.repository.ActivityRepository;
import com.amusementpark.demo.repository.AdminRepository;
import com.amusementpark.demo.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	 AdminRepository adminRepository;

	 ActivityRepository activityRepository;
	 
	 public AdminServiceImpl(AdminRepository adminRepository, ActivityRepository activityRepository) {
		super();
		this.adminRepository = adminRepository;
		this.activityRepository = activityRepository;
	 }

	  //To insert details of Admin
	  @Override
	  public Admin insertAdmin(Admin admin) 
	  {
		 return adminRepository.save(admin);
	  }
	  
	  //Viewing Admin By Id
	 @Override
	  public Admin viewAdminById(long adminId) {
		 Optional<Admin> admin = adminRepository.findById(adminId);
		 if(admin.isPresent()) {
			 return admin.get();
	  }
		 else {
			 throw new ResourceNotFoundException("Admin", "adminId", adminId);
		 }
	 }
		
	  //To update details of admin
	  @Override
	  public Admin updateAdmin(Admin admin, long adminId) 
	  {
	    Admin existingadmin = adminRepository.findById(adminId).orElseThrow(
	    		() -> new ResourceNotFoundException("admin", "adminId", adminId));
	    
	    existingadmin.setUsername(admin.getUsername());
	    existingadmin.setPassword(admin.getPassword());
	    existingadmin.setAddress(admin.getAddress());
	    existingadmin.setMobileNumber(admin.getMobileNumber());
	    existingadmin.setEmail(admin.getEmail());
	   
	    adminRepository.save(existingadmin);
	    return existingadmin;
	  }
	  
	  //To delete records of admin. 
	  @Override
	  public String deleteAdmin(long adminId) {
			
		  //Checking whether an Activity exist in DB or not
		  adminRepository.findById(adminId).orElseThrow(
					() -> new ResourceNotFoundException("Admin", "adminId", adminId));
		  adminRepository.deleteById(adminId);
		return "Deleted Successfully";
	 }
	 
	  //To get all activities for admin to view
	  public List<Activity> getAllActivities()
	  {
		  return activityRepository.findAll();
	  }
}
