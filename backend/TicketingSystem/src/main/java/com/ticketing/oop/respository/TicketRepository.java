package com.ticketing.oop.respository;

import com.ticketing.oop.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data JPA repository for the Ticket entity to perform CRUD operations.
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
