package com.amusementpark.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amusementpark.demo.entity.Activity;
import com.amusementpark.demo.exception.ResourceNotFoundException;
import com.amusementpark.demo.repository.ActivityRepository;
import com.amusementpark.demo.service.IActivityService;


@Service
public class ActivityServiceImpl implements IActivityService {

	ActivityRepository activityRepository;
	
	
	public ActivityServiceImpl(ActivityRepository activityRepository) {
		super();
		this.activityRepository = activityRepository;
	}	
	
	//Inserting an Activity
	public Activity insertActivity(Activity activity) {
		return activityRepository.save(activity);
	}
	
	

	//Viewing all Activity
	@Override
	public List<Activity> viewAllActivities() {
		return activityRepository.findAll();
	}
	

	
	//Viewing Activity By Id
	@Override
	public Activity viewActivityById(long activityId) {
		Optional<Activity> activity = activityRepository.findById(activityId);
		if(activity.isPresent()) {
			return activity.get();
		}
		else {
			throw new ResourceNotFoundException("Activity", "activityId", activityId);
		}
	}

	
	
	//Updating an Activity
	@Override
	public Activity updateActivity(Activity activity, long activityId) {
		
		//Checking whether Activity with given Id is exist in DB or not
		Activity existingActivity = activityRepository.findById(activityId).orElseThrow(
				() -> new ResourceNotFoundException("activity", "activityId", activityId));
		
		
		existingActivity.setActivityId(activity.getActivityId());
		existingActivity.setDescription(activity.getDescription());
		existingActivity.setCharges(activity.getCharges());
		
		//save existing employee to DB
		return activityRepository.save(existingActivity);
	}

	
	//Deleting an activity
	@Override
	public String deleteActivity(long activityId) {
		
		//Checking whether an Activity exist in DB or not
		activityRepository.findById(activityId).orElseThrow(
				() -> new ResourceNotFoundException("Activity", "activityId", activityId));
		activityRepository.deleteById(activityId);
		return "Deleted Successfully";
	}
}
