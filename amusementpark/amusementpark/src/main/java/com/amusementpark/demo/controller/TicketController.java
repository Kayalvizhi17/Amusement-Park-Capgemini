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

import com.amusementpark.demo.entity.Ticket;
import com.amusementpark.demo.service.ITicketService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	@Autowired
	ITicketService ticketService;
	
	public TicketController(ITicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}


	// build create Ticket REST API
	@PostMapping()
	public ResponseEntity<Ticket> insertActivity(@RequestBody Ticket ticket){
			return new ResponseEntity<Ticket>(ticketService.insertTicket(ticket), HttpStatus.CREATED);
	}

	// build get Ticket REST API
	@GetMapping
	public List<Ticket> viewAllTickets(){
		return ticketService.viewAllTickets();
	}
	
	// build get Ticket by Id REST API
	// http://localhost:8090/api/ticket/1
	@GetMapping("{id}")
	public ResponseEntity<Ticket> viewTicketById(@PathVariable("id")long ticketId){
		return new ResponseEntity<Ticket>(ticketService.viewTicketById(ticketId), HttpStatus.OK);
	}
	
	
	// build update Ticket REST API
	// http://localhost:8090/api/ticket/1
	@PutMapping("{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") long ticketId, 
		@RequestBody Ticket ticket){
		return new ResponseEntity<Ticket>(ticketService.updateTicket(ticket, ticketId), HttpStatus.OK);
	}
		
		
		
	//build delete Ticket REST API
	// http://localhost:8090/api/ticket/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTicket(@PathVariable("id") long ticketId){
			
		//delete Activity from DB
		ticketService.deleteTicket(ticketId);
			
		return new ResponseEntity<String>("Ticket Deleted Successfully", HttpStatus.OK);
	}
}
