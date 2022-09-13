package com.amusementpark.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amusementpark.demo.entity.Ticket;

//Extending JPA(Java Persistence API) Repository for managing the data as it contains API for basic CRUD operations
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
