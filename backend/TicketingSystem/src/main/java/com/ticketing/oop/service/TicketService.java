package com.ticketing.oop.service;

import com.ticketing.oop.respository.TicketRepository;
import com.ticketing.oop.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private TicketRepository ticketRepository; //Repository for database operations on tickets.

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * Adds a new ticket to the database.
     * @param ticket the ticket entity to be added.
     * @return saved ticket object.
     */
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    /**
     * Retrieves all tickets from the database.
     * @return list of all tickets.
     */
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    /**
     * Retrieves a ticket by its ID.
     * @param id The ID of the ticket to be retrieved.
     * @return The ticket entity if found, or null if not.
     */
    public Ticket getById(Long id){
        return ticketRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a ticket by its ID.
     * @param id The ID of the ticket to be deleted.
     */
    public void deleteId(Long id) {
        ticketRepository.deleteById(id);
    }
}
