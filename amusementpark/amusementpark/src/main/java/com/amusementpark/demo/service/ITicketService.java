package com.amusementpark.demo.service;

import java.util.List;

import com.amusementpark.demo.entity.Ticket;

//Creating an interface for Services is to separate the API from the Implementation
public interface ITicketService {
	public Ticket insertTicket(Ticket ticket);
	public List<Ticket> viewAllTickets();
	public Ticket viewTicketById(Long ticketId);
	public Ticket updateTicket(Ticket ticket,Long ticketId);
	public String deleteTicket(Long ticketId);
}
