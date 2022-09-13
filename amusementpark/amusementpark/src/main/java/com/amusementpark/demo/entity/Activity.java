package com.amusementpark.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="activity")
public class Activity {

	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column
		public Long activityId;
	    
	    @Column
	    @NotNull
	    @Size(min=8,message="should be of minimum 10 character")
		public String description;
	    
	    @Column
	    @NotNull
		public Long charges;
	    
	    

		public Activity(Long activityId, String description, Long charges) {
			super();
			this.activityId = activityId;
			this.description = description;
			this.charges = charges;
		}
		
		
		
		

		public Activity() {
			super();
		}





		public Long getActivityId() {
			return activityId;
		}

		public void setActivityId(Long activityId) {
			this.activityId = activityId;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getCharges() {
			return charges;
		}

		public void setCharges(Long charges) {
			this.charges = charges;
		}

		@Override
		public String toString() {
			return "Activity [activityId=" + activityId + ", description=" + description + ", charges=" + charges + "]";
		}
		
}
