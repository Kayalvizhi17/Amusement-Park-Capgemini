package com.amusementpark.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

@Entity
@Table
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	//primary key
	public Long ticketId;
	@Column
	@NotNull

	public Long customer_Id_no;	
	
	@Column
	@NotNull
	public Long activity_Id_no;

	@Column
	@NotNull

	public String date;
	
	@Column
	@NotNull

	public String time;
	
	// Getters and Setters
	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getCustomer_Id_no() {
		return customer_Id_no;
	}

	public void setCustomer_Id_no(Long customer_Id_no) {
		this.customer_Id_no = customer_Id_no;
	}

	public Long getActivity_Id_no() {
		return activity_Id_no;
	}

	public void setActivity_Id_no(Long activity_Id_no) {
		this.activity_Id_no = activity_Id_no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	//creating toString method to return a string representation of an object
	@Override
	public String toString() {
		return "Ticket [TicketId=" + ticketId + ", customer_Id_no=" + customer_Id_no + ", activity_Id_no="
				+ activity_Id_no + ", date=" + date + ", time=" + time + "]";
	}
	
	
}
