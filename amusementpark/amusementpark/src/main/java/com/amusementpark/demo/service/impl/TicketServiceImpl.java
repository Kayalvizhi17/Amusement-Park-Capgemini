package com.amusementpark.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amusementpark.demo.entity.Ticket;
import com.amusementpark.demo.exception.ResourceNotFoundException;
import com.amusementpark.demo.repository.TicketRepository;
import com.amusementpark.demo.service.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService{
	
	TicketRepository ticketRepository;

	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	
	@Override
	public Ticket insertTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> viewAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket viewTicketById(Long ticketId) {
		Optional<Ticket> ticket = ticketRepository.findById(ticketId);
		if(ticket.isPresent()) {
			return ticket.get();
		}
		else {
			throw new ResourceNotFoundException("Ticket", "ticketId", ticketId);
		}
	}

	

	@Override
	public Ticket updateTicket(Ticket ticket, Long ticketId) {

		//Checking whether Activity with given Id is exist in DB or not
		Ticket existingTicket = ticketRepository.findById(ticketId).orElseThrow(
				() -> new ResourceNotFoundException("ticket", "ticketId", ticketId));
		
		
		//existingTicket.setTicketId(ticket.getTicketId());
		existingTicket.setCustomer_Id_no(ticket.getCustomer_Id_no());
		existingTicket.setActivity_Id_no(ticket.getActivity_Id_no());
		existingTicket.setDate(ticket.getDate());
		existingTicket.setTime(ticket.getTime());
		
		
		//save existing employee to DB
		return ticketRepository.save(existingTicket);
	}
	
	
	@Override
	public String deleteTicket(Long ticketId) {

		//Checking whether an Activity exist in DB or not
		ticketRepository.findById(ticketId).orElseThrow(
				() -> new ResourceNotFoundException("Ticket", "ticketId", ticketId));
		ticketRepository.deleteById(ticketId);
		return "Deleted Successfully";
	}



	
	
}
