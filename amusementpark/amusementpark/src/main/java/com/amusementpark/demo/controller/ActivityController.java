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

import com.amusementpark.demo.entity.Activity;
import com.amusementpark.demo.service.IActivityService;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
	
	@Autowired
	IActivityService activityService;

	public ActivityController(IActivityService activityService) {
		super();
		this.activityService = activityService;
	}
	
	// build create activity REST API
	@PostMapping()
	public ResponseEntity<Activity> insertActivity(@Valid@RequestBody Activity activity){
		return new ResponseEntity<Activity>(activityService.insertActivity(activity), HttpStatus.CREATED);
	}
	
	// build get activity REST API
	@GetMapping
	public List<Activity> viewAllActivities(){
		return activityService.viewAllActivities();
	}
	
	// build get activity by Id REST API
	// http://localhost:8090/api/activities/1
	@GetMapping("{id}")
	public ResponseEntity<Activity> viewActivityById(@PathVariable("id")long activityId){
		return new ResponseEntity<Activity>(activityService.viewActivityById(activityId), HttpStatus.OK);
	}
	
	
	// build update activity REST API
	// http://localhost:8090/api/activities/1
	@PutMapping("{id}")
	public ResponseEntity<Activity> updateActivity(@PathVariable("id") long activityId, 
			@RequestBody Activity activity){
		return new ResponseEntity<Activity>(activityService.updateActivity(activity, activityId), HttpStatus.OK);
	}
	
	//build delete activity REST API
	// http://localhost:8090/api/activities/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteActivity(@PathVariable("id") long activityId){
		
		//delete Activity from DB
		activityService.deleteActivity(activityId);
		
		return new ResponseEntity<String>("Activity Deleted Successfully", HttpStatus.OK);
	}
}
