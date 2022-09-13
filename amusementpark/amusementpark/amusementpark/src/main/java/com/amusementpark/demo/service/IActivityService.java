package com.amusementpark.demo.service;

import java.util.List;

import com.amusementpark.demo.entity.Activity;

public interface IActivityService {
	public Activity insertActivity(Activity activity);
	public List<Activity> viewAllActivities();
	public Activity viewActivityById(long activityId);
	public Activity updateActivity(Activity activity,long activityId);
	public String deleteActivity(long activityId);
	
}
