package com.amusementpark.demo.service;

import java.util.List;
import com.amusementpark.demo.entity.Activity;
import com.amusementpark.demo.entity.Admin;

public interface IAdminService {
	
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin, long adminId);
    public String deleteAdmin(long adminId);
	public Admin viewAdminById(long adminId);
    public List<Activity> getAllActivities();
	
}
